package jvm.pablohdz.daorepositorypatternexample.persistence;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import jvm.pablohdz.daorepositorypatternexample.dto.TweetDto;
import jvm.pablohdz.daorepositorypatternexample.dto.TweetRequest;

import static org.junit.jupiter.api.Assertions.*;

class MySQLTweetDatabaseTest {
    private MySQLTweetDatabase database;

    @BeforeEach
    void setUp() {
        database = new MySQLTweetDatabase();
    }

    @Test
    void testThatFindTweetsByEmail() {

        List<TweetDto> list = database.findByEmail("spiderman@marvel.com");

        System.out.println(list);
        assertTrue(list.size() > 0);
    }

    @Test
    void testThatSaveTweetInDatabase() {
        TweetRequest tweetRequest = new TweetRequest(
                "spiderman@marvel.com",
                "i need kill to doctor octopus"
        );
        long id = database.saveData(tweetRequest);

        assertTrue(id > 0);
    }
}