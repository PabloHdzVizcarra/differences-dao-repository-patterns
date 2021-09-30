package jvm.pablohdz.daorepositorypatternexample.dto;

import java.util.Date;

public class TweetDto {
    private String email;
    private String tweetText;
    private Date dateCreated;

    public TweetDto() {
    }

    public TweetDto(String email, String tweetText, Date dateCreated) {
        this.email = email;
        this.tweetText = tweetText;
        this.dateCreated = dateCreated;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTweetText() {
        return tweetText;
    }

    public void setTweetText(String tweetText) {
        this.tweetText = tweetText;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    @Override
    public String toString() {
        return "TweetDto{" +
                "email='" + email + '\'' +
                ", tweetText='" + tweetText + '\'' +
                ", dateCreated=" + dateCreated +
                '}';
    }
}
