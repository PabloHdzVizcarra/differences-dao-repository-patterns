package jvm.pablohdz.daorepositorypatternexample.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;

import jvm.pablohdz.daorepositorypatternexample.dao.UserDao;
import jvm.pablohdz.daorepositorypatternexample.domain.UserSocialMedia;
import jvm.pablohdz.daorepositorypatternexample.dto.TweetRequest;
import jvm.pablohdz.daorepositorypatternexample.dto.UserDto;
import jvm.pablohdz.daorepositorypatternexample.repository.TweetRepository;

@Service
public class TweetServiceImpl implements TweetService {
    Logger logger = LoggerFactory.getLogger(TweetServiceImpl.class);
    private final TweetRepository tweetRepository;
    private final UserDao userDao;

    @Autowired
    public TweetServiceImpl(
            TweetRepository tweetRepository,
            UserDao userDao
    ) {
        this.tweetRepository = tweetRepository;
        this.userDao = userDao;
    }

    @Override
    public UserSocialMedia fetchTweetsByEmail(String email) {
        logger.info("fetch all tweets from the database with email: " +
                email);

        return tweetRepository.findByEmail(email);
    }

    @Override
    public long createTweet(TweetRequest tweetRequest) {
        UserDto byEmail = userDao.findByEmail(tweetRequest.getEmail());

        if (byEmail == null)
            throw new RuntimeException("The user with email: " +
                    tweetRequest.getEmail() +
                    " is not exists, please check the email is correct");

        tweetRequest.setTimeCreated(new Timestamp(new Date().getTime()));

        return tweetRepository.createTweet(tweetRequest);
    }
}
