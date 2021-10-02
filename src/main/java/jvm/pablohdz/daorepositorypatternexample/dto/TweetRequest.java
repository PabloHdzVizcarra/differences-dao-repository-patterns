package jvm.pablohdz.daorepositorypatternexample.dto;

import java.util.Date;

public class TweetRequest {
    private String email;
    private String tweetText;
    private Date dateCreated;

    public TweetRequest() {
    }

    public TweetRequest(String email, String tweetText, Date dateCreated) {
        this.email = email;
        this.tweetText = tweetText;
        this.dateCreated = dateCreated;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTweetText(String tweetText) {
        this.tweetText = tweetText;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    @Override
    public String toString() {
        return "TweetRequest{" +
                "email='" + email + '\'' +
                ", tweetText='" + tweetText + '\'' +
                ", dateCreated=" + dateCreated +
                '}';
    }
}
