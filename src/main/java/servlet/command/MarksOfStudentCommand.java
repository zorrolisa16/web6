package servlet.command;

import dao.MarkDAO;
import entity.Mark;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

public class MarksOfStudentCommand extends Command {

    final String urlPattern = "marksOfStudentList";

    MarkDAO markDAO = new MarkDAO();

    @Override
    public String getPattern() {
        return urlPattern;
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response, ServletContext servletContext)
            throws ServletException, IOException {

        int id_student = 97;
        try {
            id_student = Integer.parseInt(request.getParameter("id_student"));
        } catch (Exception ex) {
        }

        List<Mark> list = markDAO.readMarksByIdStudent(id_student);

        if (list.size() > 0) {
            request.setAttribute("marksOfStudentList", list);
        }

        RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher("/WEB-INF/views/marksOfStudentListView.jsp");
        dispatcher.forward(request, response);
    }

}
