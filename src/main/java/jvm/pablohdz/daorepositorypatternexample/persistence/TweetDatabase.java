package jvm.pablohdz.daorepositorypatternexample.persistence;

import java.util.List;

import jvm.pablohdz.daorepositorypatternexample.dto.TweetDto;
import jvm.pablohdz.daorepositorypatternexample.dto.TweetRequest;

public interface TweetDatabase<T> {

    List<T> findByEmail(String email);

    TweetDto saveData(TweetRequest tweetRequest);
}
