package jvm.pablohdz.daorepositorypatternexample.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

import jvm.pablohdz.daorepositorypatternexample.dao.TweetDao;
import jvm.pablohdz.daorepositorypatternexample.dao.UserDao;
import jvm.pablohdz.daorepositorypatternexample.domain.UserSocialMedia;
import jvm.pablohdz.daorepositorypatternexample.dto.TweetDto;
import jvm.pablohdz.daorepositorypatternexample.dto.TweetRequest;
import jvm.pablohdz.daorepositorypatternexample.dto.UserDto;

@Repository
public class TweetRepository {
    private final TweetDao tweetDao;
    private final UserDao userDao;

    @Autowired
    public TweetRepository(TweetDao tweetDao, UserDao userDao) {
        this.tweetDao = tweetDao;
        this.userDao = userDao;
    }

    // TODO: 10/1/21 refactor move mapping object
    public UserSocialMedia findByEmail(String email) {
        UserSocialMedia userSocialMedia = new UserSocialMedia();
        UserDto user = userDao.findByEmail(email);
        List<TweetDto> listTweets = tweetDao.fetchTweetsByEmail(email);

        userSocialMedia.setId(user.getId());
        userSocialMedia.setName(user.getName());
        userSocialMedia.setUsername(user.getUsername());
        userSocialMedia.setEmail(user.getEmail());
        userSocialMedia.setTweetList(listTweets);

        return userSocialMedia;
    }

    public long createTweet(TweetRequest tweetRequest) {
       return tweetDao.create(tweetRequest);
    }
}
