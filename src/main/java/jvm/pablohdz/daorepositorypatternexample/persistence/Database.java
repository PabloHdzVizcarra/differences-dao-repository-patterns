package jvm.pablohdz.daorepositorypatternexample.persistence;

public interface Database<T> {
    T fetchOne(T data);
}
