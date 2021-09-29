package jvm.pablohdz.daorepositorypatternexample.dao;

import org.springframework.stereotype.Repository;

import jvm.pablohdz.daorepositorypatternexample.domain.User;
import jvm.pablohdz.daorepositorypatternexample.persistence.Database;

@Repository
public class UserDaoImpl implements UserDao {
    private Database<User> persistence;

    public UserDaoImpl(Database<User> persistence) {
        this.persistence = persistence;
    }


    @Override
    public void create(User user) {
        persistence.persist(user);
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
}
