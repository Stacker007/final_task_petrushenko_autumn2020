package by.simplypvs.servlets;

import by.simplypvs.connectors.ConnectionProvider;
import by.simplypvs.dao.UserDAO;
import by.simplypvs.model.User;
import lombok.SneakyThrows;
import org.apache.commons.codec.digest.DigestUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;

import static java.util.Objects.nonNull;

@WebServlet("/reg")
public class RegServlet extends HttpServlet {

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String login = req.getParameter("login");
        String password = null;
        if (nonNull(req.getParameter("password"))) {

            password = DigestUtils.md5Hex(req.getParameter("password"));
        }
        final HttpSession session = req.getSession();
        if (nonNull(session) &&
                nonNull(session.getAttribute("login")) &&
                nonNull(session.getAttribute("password"))) {
            req.getRequestDispatcher("tasks").forward(req, resp);
        } else if (nonNull(login) && nonNull(password)) {

            try {
                User user = new User(-1,login,password,"user");
                if ((new UserDAO(ConnectionProvider.getConnection())).create(user)){
                    req.getSession().setAttribute("password", password);
                    req.getSession().setAttribute("login", login);
                    req.getSession().setAttribute("role", user.getRole());

                    req.setAttribute("message", "ok");
                    resp.sendRedirect("tasks");

                } else {
                    req.setAttribute("message", "Create user error.");
                    req.getRequestDispatcher("WEB-INF/view/index.jsp").forward(req, resp);
                }

            } catch (SQLException | ClassNotFoundException e) {
                req.setAttribute("message", "Authorization error.");
                req.getRequestDispatcher("WEB-INF/view/index.jsp").forward(req, resp);
            }

        } else{
            req.setAttribute("message", "Invalid data");
            req.getRequestDispatcher("WEB-INF/view/index.jsp").forward(req, resp);
        }
    }

    public void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
            throws IOException, ServletException {
        httpServletRequest.getRequestDispatcher("/WEB-INF/view/index.jsp").forward(httpServletRequest, httpServletResponse);
    }


}