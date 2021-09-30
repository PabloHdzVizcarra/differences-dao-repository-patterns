package jvm.pablohdz.daorepositorypatternexample.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import jvm.pablohdz.daorepositorypatternexample.dto.UserDto;
import jvm.pablohdz.daorepositorypatternexample.dto.UserRequest;
import jvm.pablohdz.daorepositorypatternexample.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping
    public ResponseEntity<List<UserDto>> fetchUsers() {
        List<UserDto> listUsers = userService.fetchUsers();
        return ResponseEntity.ok(listUsers);
    }

    @PostMapping
    public ResponseEntity<Long> save(@RequestBody UserRequest user) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(userService.save(user));
    }
}
