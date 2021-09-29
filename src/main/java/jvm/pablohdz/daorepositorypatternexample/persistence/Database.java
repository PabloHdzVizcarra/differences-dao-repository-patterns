package jvm.pablohdz.daorepositorypatternexample.persistence;

public interface Database<T> {
    void persist(T data);
}
