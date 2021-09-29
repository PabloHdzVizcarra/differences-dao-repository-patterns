package jvm.pablohdz.daorepositorypatternexample.persistence;

import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import jvm.pablohdz.daorepositorypatternexample.dto.UserDto;

@Component
public class MySQLDatabase<T> implements Database<T> {
    public static final String USER = "root";
    public static final String PASS = "my-secret-pw";
    private final String URL_DATABASE = "jdbc:mysql://localhost:3306/example";

    @Override
    public T fetchOne() {

        try (Connection connection = DriverManager.getConnection(URL_DATABASE, USER,
                PASS
        )) {
            Statement statement = connection.createStatement();
            statement.executeQuery("SELECT * FROM user_patterns");

            try (ResultSet resultSet = statement.getResultSet()) {
                UserDto userDto = null;
                while (resultSet.next()) {
                    long userId = resultSet.getLong(1);
                    String userUsername = resultSet.getString(2);
                    String userName = resultSet.getString(3);
                    String userEmail = resultSet.getString(4);

                    userDto = new UserDto(userId, userUsername, userName, userEmail);
                }

                return (T) userDto;
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public List<T> getAll() {
        try (Connection connection = DriverManager.getConnection(URL_DATABASE, USER, PASS);
             Statement statement = connection.createStatement()) {
            statement.executeQuery("SELECT * FROM user_patterns");

            try (ResultSet resultSet = statement.getResultSet()) {
                List<UserDto> userList = new ArrayList<>();
                UserDto user = null;
                while (resultSet.next()) {
                    long userId = resultSet.getLong(1);
                    String userUsername = resultSet.getString(2);
                    String userName = resultSet.getString(3);
                    String userEmail = resultSet.getString(4);

                    user = new UserDto(userId, userUsername, userName, userEmail);
                    userList.add(user);
                }

                return (List<T>) userList;
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
