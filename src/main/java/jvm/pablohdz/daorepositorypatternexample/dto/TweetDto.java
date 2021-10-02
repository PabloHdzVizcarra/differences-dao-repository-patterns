package jvm.pablohdz.daorepositorypatternexample.dto;

import java.util.Date;

public class TweetDto {
    private final String email;
    private final String tweetText;
    private final Date dateCreated;
    private final long id;

    public TweetDto(long id, String text, Date dateCreated, String email) {
        this.id = id;
        this.tweetText = text;
        this.dateCreated = dateCreated;
        this.email = email;
    }

    public String getEmail() {
        return email;
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
