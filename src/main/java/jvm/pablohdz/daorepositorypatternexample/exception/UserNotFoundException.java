package jvm.pablohdz.daorepositorypatternexample.exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String email) {
        super("The user with email: " +
                email +
                " is not exists, please check the email is correct");
    }
}
