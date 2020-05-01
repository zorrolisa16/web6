package servlet.command;

import entity.User;
import cookie.CookieUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(urlPatterns = {"/userInfo"})
public class UserInfoCommand extends Command {

    final String urlPattern = "userInfo";

    @Override
    public String getPattern() {
        return urlPattern;
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response, ServletContext servletContext)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        String username = CookieUtils.getUserNameInCookie(request);
        String time = CookieUtils.getLoginTimeInCookie(request);
        String errorMessage = null;
        User loginedUser = (User) session.getAttribute("loginedUser");

        User.Role role = loginedUser.getRole();
        String userRoleInfo = "";
        if (role == User.Role.STUDENT) {
            userRoleInfo = "Вы вошли как студент. Вам будет недоступно обновление данных в системе.";
        } else {
            userRoleInfo = "Вы вошли как преподаватель. Вам доступно обновление данных в системе.";
        }

        if (loginedUser == null) {
            response.sendRedirect(request.getContextPath() + "?command=login");
            return;
        }
        if (username == null || time == null) {
            errorMessage = "Allow to save cookies if you want to see login time";
        }

        request.setAttribute("username", username);
        request.setAttribute("time", time);
        request.setAttribute("userRoleInfo", userRoleInfo);
        request.setAttribute("errorMessage", errorMessage);

        RequestDispatcher dispatcher = servletContext.getRequestDispatcher("/WEB-INF/views/userInfoView.jsp");
        dispatcher.forward(request, response);
    }
}
