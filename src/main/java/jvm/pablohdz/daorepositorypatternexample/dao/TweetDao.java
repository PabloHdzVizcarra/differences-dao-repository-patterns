package jvm.pablohdz.daorepositorypatternexample.dao;

import java.util.List;

import jvm.pablohdz.daorepositorypatternexample.dto.TweetDto;
import jvm.pablohdz.daorepositorypatternexample.dto.TweetRequest;

public interface TweetDao {
    List<TweetDto> fetchTweetsByEmail(String email);

    long create(TweetRequest tweetRequest);
}
