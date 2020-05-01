package filter;

import entity.User;
import dao.UserDAO;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * class registration filter
 *
 * @author Polina Astashko
 * @version 1.0.0
 */
@WebFilter(filterName = "registrationFilter", urlPatterns = {"/*"})
public class RegistrationFilter implements Filter {

    UserDAO userDAO = new UserDAO();

    @Override
    public void init(FilterConfig fConfig) throws ServletException {
    }

    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        String command = request.getParameter("command");
        if (command == null || !command.equals("register")) {
            chain.doFilter(request, response);
            return;
        }
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        if (httpServletRequest.getMethod().equalsIgnoreCase("POST")) {
            HttpSession session = httpServletRequest.getSession();

            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String isTeacherStr = request.getParameter("isTeacher");
            boolean isTeacher = "1".equals(isTeacherStr);
            int t = (isTeacher ? 0 : 1);

            User loginedUser = (User) session.getAttribute("loginedUser");
            if (loginedUser == null) {
                if (userDAO.findUser(username) == null) {
                    if (username.length() >= 6) {
                        if (password.length() >= 5) {
                            User newUser = new User(username, password, t);
                            userDAO.insertUser(newUser);

                            session.setAttribute("loginedUser", newUser);
                            RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/homeView.jsp");
                            dispatcher.forward(request, response);
                            return;
                        } else {
                            request.setAttribute("errorCode", "passwordLength");
                        }
                    } else {
                        request.setAttribute("errorCode", "usernameLength");
                    }
                } else {
                    request.setAttribute("errorCode", "userExists");
                }
            } else {
                request.setAttribute("errorCode", "sessionUserExists");
            }

            RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/registrationView.jsp");
            dispatcher.forward(request, response);
        }
        chain.doFilter(request, response);
    }

}
