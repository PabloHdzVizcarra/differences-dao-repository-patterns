package jvm.pablohdz.daorepositorypatternexample.persistence;

public interface Database<T> {
    T persist(T data);
}
