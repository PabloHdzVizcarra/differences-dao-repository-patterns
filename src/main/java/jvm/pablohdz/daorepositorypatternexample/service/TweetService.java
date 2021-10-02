package jvm.pablohdz.daorepositorypatternexample.service;

import jvm.pablohdz.daorepositorypatternexample.domain.UserSocialMedia;
import jvm.pablohdz.daorepositorypatternexample.dto.TweetRequest;

public interface TweetService {

    UserSocialMedia fetchTweetsByEmail(String emailRequest);

    long createTweet(TweetRequest tweetRequest);
}
