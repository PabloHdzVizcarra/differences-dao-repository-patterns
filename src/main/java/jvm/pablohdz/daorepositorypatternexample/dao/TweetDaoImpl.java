package jvm.pablohdz.daorepositorypatternexample.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

import jvm.pablohdz.daorepositorypatternexample.dto.TweetDto;
import jvm.pablohdz.daorepositorypatternexample.persistence.Database;

@Repository
public class TweetDaoImpl implements TweetDao {
    private Database<TweetDao> database;

    @Autowired
    public TweetDaoImpl(Database<TweetDao> database) {
        this.database = database;
    }


    @Override
    public List<TweetDto> fetchTweetsByEmail(String email) {
        return null;
    }
}
