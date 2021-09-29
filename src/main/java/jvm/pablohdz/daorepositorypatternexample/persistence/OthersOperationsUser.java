package jvm.pablohdz.daorepositorypatternexample.persistence;

import java.util.List;

import jvm.pablohdz.daorepositorypatternexample.dto.UserDto;

public interface OthersOperationsUser {
    List<UserDto> fetchAll();
}
