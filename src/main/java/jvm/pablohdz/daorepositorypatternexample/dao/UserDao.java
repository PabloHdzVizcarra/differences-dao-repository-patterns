package jvm.pablohdz.daorepositorypatternexample.dao;

import java.util.List;

import jvm.pablohdz.daorepositorypatternexample.domain.User;
import jvm.pablohdz.daorepositorypatternexample.dto.UserDto;
import jvm.pablohdz.daorepositorypatternexample.dto.UserRequest;

public interface UserDao {
    long create(UserRequest user);

    User read(Long id);

    void update(User user);

    void delete(String username);

    List<UserDto> fetchAll();

    void findByEmail(String email);
}
