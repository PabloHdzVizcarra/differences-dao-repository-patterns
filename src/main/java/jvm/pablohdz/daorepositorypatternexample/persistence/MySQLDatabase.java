package jvm.pablohdz.daorepositorypatternexample.persistence;

import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// TODO: 9/29/21 response with userDto
@Component
public class MySQLDatabase<T> implements Database<T> {
    private final String URL_DATABASE = "jdbc:mysql://localhost:3306/example";

    @Override
    public T fetchOne(T data) {

        try (Connection connection = DriverManager.getConnection(URL_DATABASE, "root",
                "my-secret-pw"
        )) {
            Statement statement = connection.createStatement();
            statement.executeQuery("SELECT * FROM user_patterns");

            try (ResultSet resultSet = statement.getResultSet()) {
                while (resultSet.next()) {
                    String column01 = resultSet.getString(1);
                    System.out.println(column01);
                }
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
