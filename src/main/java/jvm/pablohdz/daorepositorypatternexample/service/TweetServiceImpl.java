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
import jvm.pablohdz.daorepositorypatternexample.exception.UserNotFoundException;
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
        if (isExistsUser(tweetRequest))
            throw new UserNotFoundException(tweetRequest.getEmail());

        tweetRequest.setTimeCreated(new Timestamp(new Date().getTime()));

        return tweetRepository.createTweet(tweetRequest);
    }

    private boolean isExistsUser(TweetRequest tweetRequest) {
        return userDao.findByEmail(tweetRequest.getEmail()) == null;
    }
}
