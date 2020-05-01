package dao;

import entity.Mark;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * mark dao class
 *
 * @author Polina Astashko
 * @version 1.0.0
 */
public class MarkDAO {

    private static final String SELECT_MARKS_OF_STUDENT_SQL = "select * from mark where id_student = ?";

    /**
     * marks by id of student
     *
     * @param id_student_ id of student
     * @return list of marks
     */
    public List<Mark> readMarksByIdStudent(int id_student_) {
        List<Mark> marks = new ArrayList<Mark>();

        try {
            String url = "jdbc:postgresql://ec2-18-206-84-251.compute-1.amazonaws.com:5432/d6cemgi8e24uij?sslmode=require";
            String username = "qgwntdqsqmlwpf";
            String password = "34b036ab898157ef02f8a6b2aada53afe2223dca362736979d076a4c9b5ef4e5";
            Class.forName("org.postgresql.Driver").getDeclaredConstructor().newInstance();

            Connection connection = DriverManager.getConnection(url, username, password);

            PreparedStatement stmt = connection.prepareStatement(SELECT_MARKS_OF_STUDENT_SQL);
            stmt.setInt(1, id_student_);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                int value = rs.getInt(2);
                int id_student = rs.getInt(3);
                int id_course = rs.getInt(4);
                Mark mark = new Mark(id, value, id_student, id_course);
                marks.add(mark);
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }

        return marks;
    }
}
