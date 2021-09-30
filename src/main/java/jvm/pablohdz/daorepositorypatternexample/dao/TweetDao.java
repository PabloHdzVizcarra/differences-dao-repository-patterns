package jvm.pablohdz.daorepositorypatternexample.dao;

import java.util.List;

import jvm.pablohdz.daorepositorypatternexample.dto.TweetDto;

public interface TweetDao {
    List<TweetDto> fetchTweetsByEmail(String email);
}
