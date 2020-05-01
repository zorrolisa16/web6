package servlet.command;

import dao.RegistrationDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

public class AmountOfCourseStudentsCommand extends Command {

    final String urlPattern = "amountOfCourseStudents";

    RegistrationDAO registrationDAO = new RegistrationDAO();

    @Override
    public String getPattern() {
        return urlPattern;
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response, ServletContext servletContext)
            throws ServletException, IOException {

        int id_course = 97;
        try {
            id_course = Integer.parseInt(request.getParameter("id_course"));
        } catch (Exception ex) {
        }

        int amount = registrationDAO.readAmountOfCourseStudents(id_course);

        request.setAttribute("amount", amount);

        RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher("/WEB-INF/views/amountOfCourseStudentsView.jsp");
        dispatcher.forward(request, response);
    }

}
