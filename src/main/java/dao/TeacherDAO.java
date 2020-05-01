package dao;

import entity.Teacher;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * teacher dao class
 *
 * @author Polina Astashko
 * @version 1.0.0
 */
public class TeacherDAO {

    private static final String SELECT_TEACHERS_WITH_MANY_COURSES_SQL = "select t.* from teacher t inner join course c"
            + " on t.id = c.id_teacher" + " group by(t.id)" + " having count(1) > 1";

    /**
     * teachers with more than 1 course
     *
     * @return list of teachers with more than 1 course
     */
    public List<Teacher> readTeachersWithManyCourses() {
        List<Teacher> teachers = new ArrayList<Teacher>();

        try {
            String url = "jdbc:postgresql://ec2-18-206-84-251.compute-1.amazonaws.com:5432/d6cemgi8e24uij?sslmode=require";
            String username = "qgwntdqsqmlwpf";
            String password = "34b036ab898157ef02f8a6b2aada53afe2223dca362736979d076a4c9b5ef4e5";
            Class.forName("org.postgresql.Driver").getDeclaredConstructor().newInstance();

            Connection connection = DriverManager.getConnection(url, username, password);

            PreparedStatement stmt = connection.prepareStatement(SELECT_TEACHERS_WITH_MANY_COURSES_SQL);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt(1);
                String fio = rs.getString(2);
                Teacher teacher = new Teacher(id, fio);
                teachers.add(teacher);
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }

        return teachers;
    }
}
