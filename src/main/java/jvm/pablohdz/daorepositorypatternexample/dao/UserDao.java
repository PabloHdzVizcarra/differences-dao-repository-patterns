package jvm.pablohdz.daorepositorypatternexample.dao;

import jvm.pablohdz.daorepositorypatternexample.domain.User;

public interface UserDao {
    void create(User user);

    User read(Long id);

    void update(User user);

    void delete(String username);
}
