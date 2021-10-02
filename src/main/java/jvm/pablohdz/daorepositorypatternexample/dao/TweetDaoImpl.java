package jvm.pablohdz.daorepositorypatternexample.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

import jvm.pablohdz.daorepositorypatternexample.dto.TweetDto;
import jvm.pablohdz.daorepositorypatternexample.dto.TweetRequest;
import jvm.pablohdz.daorepositorypatternexample.persistence.TweetDatabase;

@Repository
public class TweetDaoImpl implements TweetDao {
    private final TweetDatabase<TweetDto> database;

    @Autowired
    public TweetDaoImpl(TweetDatabase<TweetDto> database) {
        this.database = database;
    }


    @Override
    public List<TweetDto> fetchTweetsByEmail(String email) {
        return database.findByEmail(email);
    }

    @Override
    public long create(TweetRequest tweetRequest) {
        return database.saveData(tweetRequest);
    }
}
