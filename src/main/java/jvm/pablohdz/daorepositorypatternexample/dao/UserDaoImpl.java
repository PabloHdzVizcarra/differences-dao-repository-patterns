package jvm.pablohdz.daorepositorypatternexample.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

import jvm.pablohdz.daorepositorypatternexample.domain.User;
import jvm.pablohdz.daorepositorypatternexample.dto.UserDto;
import jvm.pablohdz.daorepositorypatternexample.dto.UserRequest;
import jvm.pablohdz.daorepositorypatternexample.persistence.Database;

@Repository
public class UserDaoImpl implements UserDao {
    private final Database<UserDto> persistence;

    @Autowired
    public UserDaoImpl(Database<UserDto> persistence) {
        this.persistence = persistence;
    }

    @Override
    public long create(UserRequest user) {
        return persistence.save(user);
    }

    @Override
    public User read(Long id) {
        return null;
    }

    @Override
    public void update(User user) {

    }

    @Override
    public void delete(String username) {

    }

    @Override
    public List<UserDto> fetchAll() {
        return persistence.getAll();
    }

    @Override
    public UserDto findByEmail(String email) {
        return persistence.findByEmail(email);
    }
}
