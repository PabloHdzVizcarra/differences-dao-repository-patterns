package jvm.pablohdz.daorepositorypatternexample.dto;

import java.util.Date;

public class TweetDto {
    private String email;
    private String tweetText;
    private Date dateCreated;
    private long id;

    public TweetDto() {
    }

    public TweetDto(String email, String tweetText, Date dateCreated, long id) {
        this.email = email;
        this.tweetText = tweetText;
        this.dateCreated = dateCreated;
        this.id = id;
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
