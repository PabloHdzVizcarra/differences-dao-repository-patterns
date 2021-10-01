package jvm.pablohdz.daorepositorypatternexample.domain;

import java.util.List;

import jvm.pablohdz.daorepositorypatternexample.dto.TweetDto;

public class UserSocialMedia {
    private Long id;
    private String username;
    private String name;
    private String email;
    private List<TweetDto> tweetList;

    public UserSocialMedia() {
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public List<TweetDto> getTweetList() {
        return tweetList;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTweetList(List<TweetDto> tweetList) {
        this.tweetList = tweetList;
    }
}
