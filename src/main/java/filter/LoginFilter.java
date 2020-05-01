package filter;

import entity.User;

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
 * class login filter
 *
 * @author Polina Astashko
 * @version 1.0.0
 */
@WebFilter(filterName = "loginFilter", urlPatterns = {"/*"})
public class LoginFilter implements Filter {

    @Override
    public void init(FilterConfig fConfig) throws ServletException {
    }

    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpSession session = httpServletRequest.getSession();
        User loginedUser = (User) session.getAttribute("loginedUser");
        String command = request.getParameter("command");
        if (loginedUser == null && !(command == null || command.equals("login") || command.equals("register"))) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/loginView.jsp");
            dispatcher.forward(request, response);
            return;
        }
        chain.doFilter(request, response);
    }

}
