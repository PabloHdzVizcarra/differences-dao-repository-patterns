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
    @Override
    public List<TweetDto> findByEmail(String email) {
        List<TweetDto> listTweet = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/example",
                "root", "my-secret-pw"
        );
             PreparedStatement pstmt = conn.prepareStatement(
                     "SELECT * FROM tweet_patterns WHERE tweet_email=?")
        ) {

            pstmt.setString(1, email);
            pstmt.executeQuery();

            try (ResultSet resultSet = pstmt.getResultSet()) {
                TweetDto tweet;
                while (resultSet.next()) {
                    long id = resultSet.getLong(1);
                    String text = resultSet.getString(2);
                    Timestamp created = resultSet.getTimestamp(3);

                    tweet = new TweetDto(id, text, created);
                    listTweet.add(tweet);
                }
            }

            return listTweet;

        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return new ArrayList<>();
    }
}
