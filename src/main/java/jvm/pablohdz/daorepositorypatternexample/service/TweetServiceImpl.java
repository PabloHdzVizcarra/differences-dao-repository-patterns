package jvm.pablohdz.daorepositorypatternexample.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

import jvm.pablohdz.daorepositorypatternexample.dto.EmailRequest;

@Service
public class TweetServiceImpl implements TweetService {
    Logger logger = LoggerFactory.getLogger(TweetServiceImpl.class);

    @Override
    public List<?> fetchTweetsByEmail(EmailRequest emailRequest) {
        logger.info("fetch all tweets from the database with email: " +
                emailRequest.getEmail());
        return null;
    }
}
