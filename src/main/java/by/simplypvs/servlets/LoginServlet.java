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
import java.io.IOException;

@WebServlet("/simply")
public class LoginServlet extends HttpServlet {

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username  = req.getParameter("login");
        String password = DigestUtils.md5Hex(req.getParameter("password"));
//        String submitParam = req.getParameter("submit");
        User user = new UserDAO(ConnectionProvider.getConnection()).read(username);

        if (password.equals(user.getPassword())){
            req.setAttribute("message", "Data not found. Try again. ");
            req.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(req, resp);


        } else{
            req.setAttribute("message", "Data not found. Try again. ");
            req.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(req, resp);

        }


        super.doPost(req, resp);
    }

    @Override
    public void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
            throws IOException, ServletException {
        httpServletRequest.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(httpServletRequest, httpServletResponse);

    }



}
