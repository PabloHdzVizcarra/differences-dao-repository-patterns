package jvm.pablohdz.daorepositorypatternexample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import jvm.pablohdz.daorepositorypatternexample.domain.UserSocialMedia;
import jvm.pablohdz.daorepositorypatternexample.dto.EmailRequest;
import jvm.pablohdz.daorepositorypatternexample.service.TweetService;

@RestController
@RequestMapping("/api/tweet")
public class TweetController {
    private final TweetService tweetService;

    @Autowired
    public TweetController(TweetService tweetService) {
        this.tweetService = tweetService;
    }


    @GetMapping("/byEmail/{email}")
    public ResponseEntity<UserSocialMedia> fetchTweets(@PathVariable(name = "email") String email) {
        UserSocialMedia userSocialMedia = tweetService.fetchTweetsByEmail(email);
        return new ResponseEntity<>(userSocialMedia, HttpStatus.ACCEPTED);
    }
}
