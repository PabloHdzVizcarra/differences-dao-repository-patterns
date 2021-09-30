package jvm.pablohdz.daorepositorypatternexample.dto;

import java.sql.Timestamp;
import java.util.Date;

public class TweetDto {
    private String email;
    private String tweetText;
    private Date dateCreated;
    private long id;

    public TweetDto(long id, String text, Date dateCreated, String email) {
        this.id = id;
        this.tweetText = text;
        this.dateCreated = dateCreated;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }


    public String getTweetText() {
        return tweetText;
    }


    public Date getDateCreated() {
        return dateCreated;
    }

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "TweetDto{" +
                "email='" + email + '\'' +
                ", tweetText='" + tweetText + '\'' +
                ", dateCreated=" + dateCreated +
                ", id=" + id +
                '}';
    }
}
