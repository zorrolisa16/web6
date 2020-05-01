package servlet.command;

import entity.Course;
import dao.CourseDAO;
import entity.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import javax.servlet.http.HttpSession;

public class OpenNewCourseCommand extends Command {

    final String urlPattern = "openNewCourse";

    CourseDAO courseDAO = new CourseDAO();

    @Override
    public String getPattern() {
        return urlPattern;
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response, ServletContext servletContext) throws ServletException, IOException {
        HttpSession session = request.getSession();

        User loginedUser = (User) session.getAttribute("loginedUser");

        if (loginedUser == null || loginedUser.getRole() == User.Role.STUDENT) {
            response.sendRedirect(request.getContextPath() + "?command=login");
            return;
        }
        RequestDispatcher dispatcher = servletContext.getRequestDispatcher("/WEB-INF/views/openNewCourseView.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response, ServletContext servletContext)
            throws ServletException, IOException {

        int id_course = 0;
        String title = null;
        String date_begin = null;
        int id_teacher = 0;
        try {
            id_course = 0;
            title = request.getParameter("title");
            date_begin = request.getParameter("date_begin");
            id_teacher = Integer.parseInt(request.getParameter("id_teacher"));

            courseDAO.insertCourse(new Course(id_course, title, date_begin, id_teacher));

        } catch (Exception ex) {
        }

        RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher("/WEB-INF/views/openNewCourseView.jsp");
        dispatcher.forward(request, response);
    }

}
