package servlet;

import servlet.command.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Polina
 */
@WebServlet(urlPatterns = {"/"})
public class MainServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private final Map<String, Command> commands;

    public MainServlet() {
        super();
        this.commands = new HashMap<String, Command>();
    }

    @Override
    public void init() {
        Command[] arr = {new HomeCommand(), new LoginCommand(), new RegistrationCommand(), new UserInfoCommand(),
            new AmountOfCourseStudentsCommand(), new TeachersWithManyCoursesCommand(), new MarksOfStudentCommand(),
            new OpenNewCourseCommand()};
        for (Command c : arr) {
            this.commands.put(c.getPattern(), c);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String command = request.getParameter("command");
        if (command == null) {
            commands.get("home").doGet(request, response, this.getServletContext());
        } else if (commands.containsKey(command)) {
            commands.get(command).doGet(request, response, this.getServletContext());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String command = request.getParameter("command");
        if (command == null) {
            commands.get("home").doGet(request, response, this.getServletContext());
        } else if (commands.containsKey(command)) {
            commands.get(command).doPost(request, response, this.getServletContext());
        }
    }
}
