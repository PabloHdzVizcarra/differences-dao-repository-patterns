package jvm.pablohdz.daorepositorypatternexample.persistence;

import java.util.List;

public interface Database<T> {
    T fetchOne();

    List<T> getAll();
}
