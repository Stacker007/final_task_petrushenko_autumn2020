package by.simplypvs.servlets.filters;

import by.simplypvs.connectors.ConnectionProvider;
import by.simplypvs.dao.UserDAO;
import by.simplypvs.model.User;
import lombok.SneakyThrows;
import org.apache.commons.codec.digest.DigestUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;

import static java.util.Objects.nonNull;

public class AuthFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig)  {
    }

    @SneakyThrows
    @Override
    public void doFilter(final ServletRequest request,
                         final ServletResponse response,
                         final FilterChain filterChain) {

        final HttpServletRequest req = (HttpServletRequest) request;
        final HttpServletResponse res = (HttpServletResponse) response;

        final String login = request.getParameter("login");
        String password = null;
        if (nonNull(req.getParameter("password"))) {
            password = DigestUtils.md5Hex(req.getParameter("password"));
        }
        final HttpSession session = req.getSession();


        //Logged user.
        if (nonNull(session) &&
                nonNull(session.getAttribute("login")) &&
                nonNull(session.getAttribute("password"))) {
            filterChain.doFilter(request, response);
//            req.getRequestDispatcher("/WEB-INF/view/task_page.jsp").forward(req, res);
        } else if (nonNull(login) && nonNull(password)) {

            try {
                User user = new UserDAO(ConnectionProvider.getConnection()).read(login);
                if (password.equals(user.getPassword())) {
                    req.getSession().setAttribute("password", password);
                    req.getSession().setAttribute("login", login);
                    req.getSession().setAttribute("role", user.getRole().getRole());
                }
                req.setAttribute("message", "ok");
                res.sendRedirect("/simply/task-page");
            } catch (SQLException e) {
                req.setAttribute("message", "Authentication error.");
            }

        } else req.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(req, res);

    }


    @Override
    public void destroy() {
    }

}