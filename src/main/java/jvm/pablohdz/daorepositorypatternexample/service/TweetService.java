package jvm.pablohdz.daorepositorypatternexample.service;

import jvm.pablohdz.daorepositorypatternexample.domain.UserSocialMedia;

public interface TweetService {

    UserSocialMedia fetchTweetsByEmail(String emailRequest);
}
