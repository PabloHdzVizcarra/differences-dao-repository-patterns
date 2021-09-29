package jvm.pablohdz.daorepositorypatternexample.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jvm.pablohdz.daorepositorypatternexample.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping
    public ResponseEntity<Void> fetchUsers() {
        userService.fetchUsers();
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
