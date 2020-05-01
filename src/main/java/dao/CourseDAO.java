package dao;

import entity.Course;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 * course dao class
 *
 * @author Polina Astashko
 * @version 1.0.0
 */
public class CourseDAO {

    private static final String INSERT_COURSE_SQL = "insert into course(title, date_begin, id_teacher) values(?, ?, ?)";

    /**
     * insert course
     *
     * @param course new course to insert
     */
    public void insertCourse(Course course) {

        try {
            String url = "jdbc:postgresql://ec2-18-206-84-251.compute-1.amazonaws.com:5432/d6cemgi8e24uij?sslmode=require";
            String username = "qgwntdqsqmlwpf";
            String password = "34b036ab898157ef02f8a6b2aada53afe2223dca362736979d076a4c9b5ef4e5";
            Class.forName("org.postgresql.Driver").getDeclaredConstructor().newInstance();
           
            Connection connection = DriverManager.getConnection(url, username, password);

            PreparedStatement stmt = connection.prepareStatement(INSERT_COURSE_SQL);
            stmt.setString(1, course.getTitle());
            stmt.setString(2, course.getDatebegin());
            stmt.setInt(3, course.getIdteacher());
            stmt.execute();

        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
}
