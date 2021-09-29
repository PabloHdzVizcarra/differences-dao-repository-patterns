package jvm.pablohdz.daorepositorypatternexample.service;

import java.util.List;

import jvm.pablohdz.daorepositorypatternexample.dto.UserDto;

public interface UserService {
    List<UserDto> fetchUsers();
}
