package jvm.pablohdz.daorepositorypatternexample.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import jvm.pablohdz.daorepositorypatternexample.dto.TweetDto;

public class MySQLTweetDatabase implements TweetDatabase<TweetDto> {
    public static final String URL = "jdbc:mysql://localhost:3306/example";
    public static final String USER = "root";
    public static final String PASSWORD = "my-secret-pw";

    @Override
    public List<TweetDto> findByEmail(String email) {
        String queryFindByEmail = "SELECT * FROM tweet_patterns WHERE tweet_email=?";

        Connection connection = createConnection();
        PreparedStatement pstmt = createPreparedStatement(connection, queryFindByEmail);
        PreparedStatement pstmtWithData =
                executeQueryFindByEmail("spiderman@marvel.com", pstmt);

        List<TweetDto> list = getTweets(pstmtWithData);
        closeConnections(connection, pstmt, pstmtWithData);
        return list;
    }

    private void closeConnections(
            Connection connection,
            PreparedStatement pstmt,
            PreparedStatement pstmtWithData
    ) {
        try {
            connection.close();
            pstmt.close();
            pstmtWithData.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Connection createConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    private PreparedStatement createPreparedStatement(Connection connection, String query) {
        try {
            return connection.prepareStatement(query);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    private PreparedStatement executeQueryFindByEmail(String email, PreparedStatement pstmt) {
        try {
            pstmt.setString(1, email);
            pstmt.executeQuery();
            return pstmt;
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    private List<TweetDto> getTweets(PreparedStatement pstmt) {
        List<TweetDto> list = new ArrayList<>();
        try (ResultSet resultSet = pstmt.getResultSet()) {
            TweetDto tweet;
            while (resultSet.next()) {
                long id = resultSet.getLong(1);
                String text = resultSet.getString(2);
                Timestamp created = resultSet.getTimestamp(3);
                String email = resultSet.getString(4);

                tweet = new TweetDto(id, text, created, email);
                list.add(tweet);
            }

            return list;

        } catch (SQLException exception) {
            exception.printStackTrace();
        }

        return new ArrayList<>();

    }
}
