package jvm.pablohdz.daorepositorypatternexample.service;

import jvm.pablohdz.daorepositorypatternexample.domain.UserSocialMedia;
import jvm.pablohdz.daorepositorypatternexample.dto.EmailRequest;

public interface TweetService {

    UserSocialMedia fetchTweetsByEmail(EmailRequest emailRequest);
}
