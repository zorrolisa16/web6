package dao;

import entity.Student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * student dao class
 *
 * @author Polina Astashko
 * @version 1.0.0
 */
public class StudentDAO {

    private static final String SELECT_ALL_STUDENTS_SQL = "select * from student";
    private static final String SELECT_STUDENT_BY_ID_SQL = "select * from student where id = ?";

    /**
     * read students
     *
     * @return list of students
     */
    public List<Student> readStudents() {
        List<Student> students = new ArrayList<Student>();

        try {
            String url = "jdbc:postgresql://ec2-18-206-84-251.compute-1.amazonaws.com:5432/d6cemgi8e24uij?sslmode=require";
            String username = "qgwntdqsqmlwpf";
            String password = "34b036ab898157ef02f8a6b2aada53afe2223dca362736979d076a4c9b5ef4e5";
            Class.forName("org.postgresql.Driver").getDeclaredConstructor().newInstance();

            Connection connection = DriverManager.getConnection(url, username, password);

            PreparedStatement stmt = connection.prepareStatement(SELECT_ALL_STUDENTS_SQL);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt(1);
                String fio = rs.getString(2);
                Student student = new Student(id, fio);
                students.add(student);
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }

        return students;
    }

    /**
     * read student by id
     *
     * @param id id of student
     * @return student
     */
    public Student readStudent(int id) {
        Student student = null;

        try {
            String url = "jdbc:postgresql://ec2-18-206-84-251.compute-1.amazonaws.com:5432/d6cemgi8e24uij?sslmode=require";
            String username = "qgwntdqsqmlwpf";
            String password = "34b036ab898157ef02f8a6b2aada53afe2223dca362736979d076a4c9b5ef4e5";
            Class.forName("org.postgresql.Driver").getDeclaredConstructor().newInstance();

            Connection connection = DriverManager.getConnection(url, username, password);

            PreparedStatement stmt = connection.prepareStatement(SELECT_STUDENT_BY_ID_SQL);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String fio = rs.getString(2);
                student = new Student(id, fio);
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }

        return student;
    }
}
