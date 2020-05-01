package servlet.command;

import dao.TeacherDAO;
import entity.Teacher;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

public class TeachersWithManyCoursesCommand extends Command {

    final String urlPattern = "teachersWithManyCoursesList";

    TeacherDAO teacherDAO = new TeacherDAO();

    @Override
    public String getPattern() {
        return urlPattern;
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response, ServletContext servletContext)
            throws ServletException, IOException {

        List<Teacher> list = teacherDAO.readTeachersWithManyCourses();

        if (list.size() > 0) {
            request.setAttribute("teacherList", list);
        }

        RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher("/WEB-INF/views/teachersWithManyCoursesView.jsp");
        dispatcher.forward(request, response);
    }

}
