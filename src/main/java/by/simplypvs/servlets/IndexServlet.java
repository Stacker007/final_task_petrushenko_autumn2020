package by.simplypvs.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
@WebServlet("/")
public class IndexServlet extends HttpServlet {
    public void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
            throws IOException, ServletException {
        httpServletRequest.getRequestDispatcher("./index.jsp").forward(httpServletRequest, httpServletResponse);
    }

}