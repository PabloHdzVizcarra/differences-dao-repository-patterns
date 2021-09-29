package jvm.pablohdz.daorepositorypatternexample.persistence;

import java.util.List;

import jvm.pablohdz.daorepositorypatternexample.dto.UserRequest;

public interface Database<T> {
    T fetchOne();

    List<T> getAll();

    long save(UserRequest data);
}
