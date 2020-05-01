package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * registration dao class
 *
 * @author Polina Astashko
 * @version 1.0.0
 */
public class RegistrationDAO {

    private static final String SELECT_AMOUNT_OF_STUDENT_SQL = "select Count(1) from registration where id_course = ?";

    /**
     * amount of some course's students
     *
     * @param id_course id of course
     * @return amount of students
     */
    public int readAmountOfCourseStudents(int id_course) {
        int amount = 0;

        try {
            String url = "jdbc:postgresql://ec2-18-206-84-251.compute-1.amazonaws.com:5432/d6cemgi8e24uij?sslmode=require";
            String username = "qgwntdqsqmlwpf";
            String password = "34b036ab898157ef02f8a6b2aada53afe2223dca362736979d076a4c9b5ef4e5";
            Class.forName("org.postgresql.Driver").getDeclaredConstructor().newInstance();
            
            Connection connection = DriverManager.getConnection(url, username, password);

            PreparedStatement stmt = connection.prepareStatement(SELECT_AMOUNT_OF_STUDENT_SQL);
            stmt.setInt(1, id_course);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                amount = rs.getInt(1);
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }

        return amount;
    }
}
