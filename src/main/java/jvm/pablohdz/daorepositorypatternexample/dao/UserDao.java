package jvm.pablohdz.daorepositorypatternexample.dao;

import java.util.List;

import jvm.pablohdz.daorepositorypatternexample.domain.User;
import jvm.pablohdz.daorepositorypatternexample.dto.UserDto;

public interface UserDao {
    void create(User user);

    User read(Long id);

    void update(User user);

    void delete(String username);

    List<UserDto> fetchAll();
}
