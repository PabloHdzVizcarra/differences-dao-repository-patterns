package jvm.pablohdz.daorepositorypatternexample.dto;

import java.sql.Timestamp;

public class TweetRequest {
    private String email;
    private String tweetText;
    private Timestamp timeCreated;

    public TweetRequest() {
    }

    public TweetRequest(String email, String tweetText, Timestamp timeCreated) {
        this.email = email;
        this.tweetText = tweetText;
        this.timeCreated = timeCreated;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return this.email;
    }

    public String getTweetText() {
        return tweetText;
    }

    public Timestamp getTimeCreated() {
        return this.timeCreated;
    }
}
