package dao;

import entity.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * user dao class
 *
 * @author Polina Astashko
 * @version 1.0.0
 */
public class UserDAO {

    private static final String SELECT_USER = "select role, refid from users where username = ? AND password = ?";
    private static final String SELECT_USER_WITHOUT_PASSWORD = "select password, role, refid from users where username = ?";
    private static final String INSERT_USER_SQL = "insert into users(username, password, role) values(?, ?, ?)";

    /**
     * read user by username
     *
     * @param username_ username of user
     * @param password_ password of user
     * @return student
     */
    public User findUser(String username_, String password_) {
        User user = null;

        try {
            String url = "jdbc:postgresql://ec2-18-206-84-251.compute-1.amazonaws.com:5432/d6cemgi8e24uij?sslmode=require";
            String username = "qgwntdqsqmlwpf";
            String password = "34b036ab898157ef02f8a6b2aada53afe2223dca362736979d076a4c9b5ef4e5";
            Class.forName("org.postgresql.Driver").getDeclaredConstructor().newInstance();

            Connection connection = DriverManager.getConnection(url, username, password);

            PreparedStatement stmt = connection.prepareStatement(SELECT_USER);
            stmt.setString(1, username_);
            stmt.setString(2, password_);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                user = new User();
                user.setUserName(username_);
                user.setPassword(password_);
                user.setRole(rs.getInt("role"));
                user.setRefid(rs.getInt("refid"));
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }

        return user;
    }

    /**
     * read user by username
     *
     * @param username_ username of user
     * @return student
     */
    public User findUser(String username_) {
        User user = null;

        try {
            String url = "jdbc:postgresql://ec2-18-206-84-251.compute-1.amazonaws.com:5432/d6cemgi8e24uij?sslmode=require";
            String username = "qgwntdqsqmlwpf";
            String password = "34b036ab898157ef02f8a6b2aada53afe2223dca362736979d076a4c9b5ef4e5";
            Class.forName("org.postgresql.Driver").getDeclaredConstructor().newInstance();

            Connection connection = DriverManager.getConnection(url, username, password);

            PreparedStatement stmt = connection.prepareStatement(SELECT_USER_WITHOUT_PASSWORD);
            stmt.setString(1, username_);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                user = new User();
                String password_ = rs.getString("password");
                user.setUserName(username_);
                user.setPassword(password_);
                user.setRole(rs.getInt("role"));
                user.setRefid(rs.getInt("refid"));
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }

        return user;
    }

    /**
     * insert user
     *
     * @param user new user to insert
     */
    public void insertUser(User user) {
        try {
            String url = "jdbc:postgresql://ec2-18-206-84-251.compute-1.amazonaws.com:5432/d6cemgi8e24uij?sslmode=require";
            String username = "qgwntdqsqmlwpf";
            String password = "34b036ab898157ef02f8a6b2aada53afe2223dca362736979d076a4c9b5ef4e5";
            Class.forName("org.postgresql.Driver").getDeclaredConstructor().newInstance();

            Connection connection = DriverManager.getConnection(url, username, password);

            PreparedStatement stmt = connection.prepareStatement(INSERT_USER_SQL);
            stmt.setString(1, user.getUserName());
            stmt.setString(2, user.getPassword());
            int role = (user.getRole() == User.Role.STUDENT ? 1 : 0);
            stmt.setInt(3, role);
            stmt.execute();
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
}
