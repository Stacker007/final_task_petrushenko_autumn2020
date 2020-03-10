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
import java.io.IOException;
import java.sql.SQLException;
import java.util.concurrent.atomic.AtomicReference;

import static java.util.Objects.nonNull;

public class AuthFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @SneakyThrows
    @Override
    public void doFilter(final ServletRequest request,
                         final ServletResponse response,
                         final FilterChain filterChain)

            throws IOException, ServletException {

        final HttpServletRequest req = (HttpServletRequest) request;
        final HttpServletResponse res = (HttpServletResponse) response;

         String login = req.getParameter("login");
        String password = null;
        if (nonNull(req.getParameter("password"))) {
            password = DigestUtils.md5Hex(req.getParameter("password"));
        }
        final HttpSession session = req.getSession();



        //Logged user.
        if (nonNull(session) &&
                nonNull(session.getAttribute("login")) &&
                nonNull(session.getAttribute("password"))) {

            final String role =(String)session.getAttribute("role");
            if (role.equals("admin")){
                req.getRequestDispatcher("/WEB-INF/view/admin.jsp").forward(req, res);
            }
            if (role.equals("user")){
                req.getRequestDispatcher("/WEB-INF/view/task_page.jsp").forward(req, res);
            }

//            moveToMenu(req, res, role);


        } else {
//            req.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(req, res);
            try {
                login = "admin";

                User user = new UserDAO(ConnectionProvider.getConnection()).read(login);
                if (password.equals(user.getPassword())){
                    req.getSession().setAttribute("password", password);
                    req.getSession().setAttribute("login", login);
                    req.getSession().setAttribute("role", user.getRole().getRole());
                }
                req.setAttribute("message", "ok");
            }catch (SQLException e){
                req.setAttribute("message", "Account is not exist");
            }

        }
    }

    /**
     * Move user to menu.
     * If access 'admin' move to admin menu.
     * If access 'user' move to user menu.
     */
    private void moveToMenu(final HttpServletRequest req,
                            final HttpServletResponse res,
                            final String role)
            throws ServletException, IOException {


        if (role.equals("admin")) {

            req.getRequestDispatcher("/WEB-INF/view/admin_menu.jsp").forward(req, res);

        } else if (role.equals("user")) {

            req.getRequestDispatcher("/WEB-INF/view/user_menu.jsp").forward(req, res);

        } else {

            req.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(req, res);
        }
    }


    @Override
    public void destroy() {
    }

}