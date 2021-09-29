package jvm.pablohdz.daorepositorypatternexample.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

import jvm.pablohdz.daorepositorypatternexample.dao.UserDao;
import jvm.pablohdz.daorepositorypatternexample.dto.UserDto;
import jvm.pablohdz.daorepositorypatternexample.dto.UserRequest;

@Service
public class UserServiceImpl implements UserService {
    Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }


    @Override
    public List<UserDto> fetchUsers() {
        List<UserDto> list = userDao.fetchAll();
        logger.info("Fetch " + list.size() + " users from the database");
        return list;
    }

    @Override
    public long save(UserRequest userRequest) {
        long id = userDao.create(userRequest);
        logger.info("Create new user with id: " + id);
        return id;
    }
}
