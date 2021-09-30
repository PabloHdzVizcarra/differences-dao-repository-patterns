package jvm.pablohdz.daorepositorypatternexample.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import jvm.pablohdz.daorepositorypatternexample.dto.EmailRequest;

@RestController
@RequestMapping("/api/tweet")
public class TweetController {

    @RequestMapping
    public ResponseEntity<List<?>> fetchTweets(@RequestBody EmailRequest emailRequest) {



        return ResponseEntity.ok(new ArrayList<>());
    }
}
