package jvm.pablohdz.daorepositorypatternexample.persistence;

import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import jvm.pablohdz.daorepositorypatternexample.dto.TweetDto;
import jvm.pablohdz.daorepositorypatternexample.dto.TweetRequest;

@Component
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

    @Override
    public long saveData(TweetRequest tweetRequest) {
        String query = "INSERT INTO tweet_patterns(tweet_text, tweet_created, tweet_email)" +
                " VALUES (?, ?, ?);";
        Connection connection = createConnection();
        PreparedStatement preparedStatement = createPreparedStatement(connection, query);
        PreparedStatement pstmt = executeQueryCreateTweet(preparedStatement, tweetRequest);

        long id = mapToTweet(pstmt);
        closeConnections(pstmt, preparedStatement, connection);

        return id;
    }

    private long mapToTweet(PreparedStatement pstmt) {
        long id = 0;
        try {
            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                ResultSet keys = pstmt.getGeneratedKeys();
                if (keys.next())
                    id = keys.getLong(1);
            }
            return id;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }

    private PreparedStatement executeQueryCreateTweet(
            PreparedStatement preparedStatement,
            TweetRequest tweetRequest
    ) {
        try {
            preparedStatement.setString(1, tweetRequest.getTweetText());
            preparedStatement.setTimestamp(2, Timestamp.from(Instant.now()));
            preparedStatement.setString(3, tweetRequest.getEmail());

            return preparedStatement;
        } catch (SQLException exception) {
            throw new IllegalArgumentException(exception.getMessage());
        }
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

    private void closeConnections(
            PreparedStatement pstmt,
            PreparedStatement pstmtWithData,
            Connection connection
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
            return connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
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
