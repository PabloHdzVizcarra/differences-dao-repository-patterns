package jvm.pablohdz.daorepositorypatternexample.persistence;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import jvm.pablohdz.daorepositorypatternexample.dto.UserDto;

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
}