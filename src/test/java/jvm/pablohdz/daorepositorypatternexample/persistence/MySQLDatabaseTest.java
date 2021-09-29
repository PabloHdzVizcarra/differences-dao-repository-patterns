package jvm.pablohdz.daorepositorypatternexample.persistence;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
        System.out.println(user);
    }
}