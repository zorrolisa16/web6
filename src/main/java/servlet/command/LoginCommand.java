package servlet.command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.User;
import cookie.CookieUtils;
import dao.UserDAO;

public class LoginCommand extends Command {

    final String urlPattern = "login";

    UserDAO userDAO = new UserDAO();

    @Override
    public String getPattern() {
        return urlPattern;
    }

    public LoginCommand() {
        super();
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response, ServletContext servletContext)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        User loginedUser = (User) session.getAttribute("loginedUser");

        if (loginedUser == null) {
            CookieUtils.deleteUserCookie(response);
        }
        RequestDispatcher dispatcher = servletContext.getRequestDispatcher("/WEB-INF/views/loginView.jsp");
        dispatcher.forward(request, response);

    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response, ServletContext servletContext)
            throws ServletException, IOException {
        String userName = request.getParameter("username");
        String password = request.getParameter("password");
        String rememberMeStr = request.getParameter("rememberMe");
        boolean remember = "Y".equals(rememberMeStr);

        User user = null;
        boolean hasError = false;
        String errorString = null;

        if (userName == null || password == null || userName.length() < 2 || password.length() < 3) {
            hasError = true;
            errorString = "Required correct username and password!";
        } else {

            user = userDAO.findUser(userName, password);

            if (user == null) {
                hasError = true;
                errorString = "User Name or password invalid";
            }
        }
        if (hasError) {
            user = new User();
            user.setUserName(userName);
            user.setPassword(password);

            request.setAttribute("errorString", errorString);
            request.setAttribute("user", user);

            RequestDispatcher dispatcher = servletContext.getRequestDispatcher("/WEB-INF/views/loginView.jsp");

            dispatcher.forward(request, response);
        } else {
            HttpSession session = request.getSession();

            session.setAttribute("loginedUser", user);

            if (remember) {
                CookieUtils.storeUserCookie(response, user);
            } else {
                CookieUtils.deleteUserCookie(response);
            }

            response.sendRedirect(request.getContextPath() + "?command=userInfo");
        }
    }

}
