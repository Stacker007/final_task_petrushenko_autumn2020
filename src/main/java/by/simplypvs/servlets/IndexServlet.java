package by.simplypvs.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
@WebServlet("/index")
public class IndexServlet extends HttpServlet {
    public void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
            throws IOException, ServletException {
        httpServletRequest.getRequestDispatcher("/WEB-INF/view/index.jsp").forward(httpServletRequest, httpServletResponse);
    }

}