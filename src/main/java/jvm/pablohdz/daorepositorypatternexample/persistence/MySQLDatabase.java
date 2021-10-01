package jvm.pablohdz.daorepositorypatternexample.persistence;

import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import jvm.pablohdz.daorepositorypatternexample.dto.UserDto;
import jvm.pablohdz.daorepositorypatternexample.dto.UserRequest;

@Component
public class MySQLDatabase<T> implements Database<T> {
    public static final String USER = "root";
    public static final String PASS = "my-secret-pw";
    private final String URL = "jdbc:mysql://localhost:3306/example";

    @Override
    public T fetchOne() {

        try (Connection connection = DriverManager.getConnection(URL, USER,
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
        try (Connection connection = DriverManager.getConnection(URL, USER, PASS);
             Statement statement = connection.createStatement()) {
            statement.executeQuery("SELECT * FROM user_patterns");

            try (ResultSet resultSet = statement.getResultSet()) {
                List<UserDto> userList = mapToUserList(resultSet);

                return (List<T>) userList;
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public long save(UserRequest data) {
        long id = 0;
        String query = "INSERT INTO user_patterns" +
                "(user_username, user_name, user_email) VALUES (?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASS);
             PreparedStatement pstmt = conn.prepareStatement(
                     query,
                     Statement.RETURN_GENERATED_KEYS
             )) {

            pstmt.setString(1, data.getUsername());
            pstmt.setString(2, data.getName());
            pstmt.setString(3, data.getEmail());

            int affectedRows = pstmt.executeUpdate();

            if (affectedRows > 0) {
                try (ResultSet rs = pstmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        id = rs.getLong(1);
                    }
                } catch (SQLException exception) {
                    System.out.println(exception.getMessage());
                }
            }

            return id;

        } catch (SQLException throwables) {
            System.out.println(throwables.getMessage());
        }

        return 0;
    }

    @Override
    public UserDto findByEmail(String email) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASS);
             PreparedStatement pstmt = conn.prepareStatement(
                     "SELECT * FROM user_patterns WHERE user_email = ?")) {

            pstmt.setString(1, email);

            pstmt.executeQuery();

            try (ResultSet resultSet = pstmt.getResultSet()) {
                UserDto userDto = null;
                while (resultSet.next()) {
                    long id = resultSet.getLong(1);
                    String username = resultSet.getString(2);
                    String name = resultSet.getString(3);
                    String userEmail = resultSet.getString(4);

                    userDto = new UserDto(id, username, name, userEmail);
                }

                return userDto;
            }

        } catch (SQLException exception) {
            exception.printStackTrace();
        }

        return null;
    }

    private List<UserDto> mapToUserList(ResultSet resultSet) throws SQLException {
        UserDto user;
        List<UserDto> userList = new ArrayList<>();
        while (resultSet.next()) {
            long userId = resultSet.getLong(1);
            String userUsername = resultSet.getString(2);
            String userName = resultSet.getString(3);
            String userEmail = resultSet.getString(4);

            user = new UserDto(userId, userUsername, userName, userEmail);
            userList.add(user);
        }

        return userList;
    }
}
