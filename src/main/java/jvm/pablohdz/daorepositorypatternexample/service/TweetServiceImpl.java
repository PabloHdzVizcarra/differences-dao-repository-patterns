package jvm.pablohdz.daorepositorypatternexample.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Date;

import jvm.pablohdz.daorepositorypatternexample.domain.UserSocialMedia;
import jvm.pablohdz.daorepositorypatternexample.dto.TweetRequest;
import jvm.pablohdz.daorepositorypatternexample.repository.TweetRepository;

@Service
public class TweetServiceImpl implements TweetService {
    Logger logger = LoggerFactory.getLogger(TweetServiceImpl.class);
    private final TweetRepository tweetRepository;

    @Autowired
    public TweetServiceImpl(TweetRepository tweetRepository) {
        this.tweetRepository = tweetRepository;
    }

    @Override
    public UserSocialMedia fetchTweetsByEmail(String email) {
        logger.info("fetch all tweets from the database with email: " +
                email);

        return tweetRepository.findByEmail(email);
    }

    // TODO: 10/1/21 validate user exists before create tweet
    @Override
    public long createTweet(TweetRequest tweetRequest) {
        tweetRequest.setTimeCreated(new Timestamp(new Date().getTime()));

        return tweetRepository.createTweet(tweetRequest);
    }
}
