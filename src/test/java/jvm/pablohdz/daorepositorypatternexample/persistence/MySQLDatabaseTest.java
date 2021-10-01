package jvm.pablohdz.daorepositorypatternexample.persistence;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import jvm.pablohdz.daorepositorypatternexample.dto.UserDto;
import jvm.pablohdz.daorepositorypatternexample.dto.UserRequest;

import static org.junit.jupiter.api.Assertions.*;


class MySQLDatabaseTest {
    private Database<UserDto> underTest;


    @BeforeEach
    void setUp() {
        underTest = new MySQLDatabase<>();
    }

    @Test
    void testThatFetchUserCorrectly() {
        UserDto user = underTest.fetchOne();

        assertNotNull(user);
        assertNotNull(user.getEmail());
        assertNotNull(user.getUsername());
        assertNotNull(user.getName());
    }

    @Test
    void testThatFetchAllUsers() {
        List<UserDto> list = underTest.getAll();

        System.out.println(list);
        assertTrue(list.size() > 1);
    }

    @Test
    void testThatSaveUser() {
        UserRequest request = new UserRequest(
                "doctor strange", "Stephen Strange", "drstrench@marvel.com");

        long id = underTest.save(request);

        assertTrue(id > 0);
    }

    @Test
    void testThatFindUserByEmail() {
        UserDto user = underTest.findByEmail("spiderman@marvel.com");

        assertTrue(user.getEmail().equalsIgnoreCase("spiderman@marvel.com"));
    }
}