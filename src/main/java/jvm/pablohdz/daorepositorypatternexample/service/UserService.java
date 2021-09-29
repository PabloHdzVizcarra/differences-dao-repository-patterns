package jvm.pablohdz.daorepositorypatternexample.service;

import java.util.List;

import jvm.pablohdz.daorepositorypatternexample.dto.UserDto;
import jvm.pablohdz.daorepositorypatternexample.dto.UserRequest;

public interface UserService {
    List<UserDto> fetchUsers();

    long save(UserRequest userRequest);
}
