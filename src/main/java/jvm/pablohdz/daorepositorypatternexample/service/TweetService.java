package jvm.pablohdz.daorepositorypatternexample.service;

import java.util.List;

import jvm.pablohdz.daorepositorypatternexample.dto.EmailRequest;

public interface TweetService {

    List<?> fetchTweetsByEmail(EmailRequest emailRequest);
}
