package jvm.pablohdz.daorepositorypatternexample.persistence;

import java.util.List;

public interface TweetDatabase<T> {

    List<T> findByEmail(String email);
}
