package by.simplypvs.servlets;

import by.simplypvs.connectors.ConnectionProvider;
import by.simplypvs.dao.UserDAO;
import by.simplypvs.model.User;
import lombok.SneakyThrows;
import org.apache.commons.codec.digest.DigestUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

import static java.util.Objects.nonNull;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        final String login = req.getParameter("login");
        String password = null;
        if (nonNull(req.getParameter("password"))) {
            password = req.getParameter("password");
            password = DigestUtils.md5Hex(password);
        }
        final HttpSession session = req.getSession();
        if (nonNull(session) &&
                nonNull(session.getAttribute("login")) &&
                nonNull(session.getAttribute("password"))) {
            req.getRequestDispatcher(req.getContextPath()+"/").forward(req, resp);
        } else if (nonNull(login) && nonNull(password)) {

            try {
                User user = new UserDAO(ConnectionProvider.getConnection()).read(login);
                if (password.equals(user.getPassword())) {
                    req.getSession().setAttribute("password", password);
                    req.getSession().setAttribute("login", login);
                    req.getSession().setAttribute("role", user.getRole().getRole());

                    req.setAttribute("message", "ok");
                    resp.sendRedirect(req.getContextPath()+"/");

                } else {
                    req.setAttribute("message", "Authentication error.");
                    req.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(req, resp);
                }

            } catch (SQLException e) {
                req.setAttribute("message", "Authorization error.");
                req.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(req, resp);
            }

        } else req.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(req, resp);
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException, ServletException {
        req.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(req, resp);

    }




}
