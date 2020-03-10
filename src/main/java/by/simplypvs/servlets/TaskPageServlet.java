package by.simplypvs.servlets;

import by.simplypvs.connectors.Auth;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/simply/task-page")
public class TaskPageServlet extends HttpServlet {
    public void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
            throws IOException, ServletException {
        if (!Auth.checkAuth(httpServletRequest.getSession(),"admin","user")){
            httpServletRequest.getRequestDispatcher("/WEB-INF/view/access-denied.jsp").forward(httpServletRequest,httpServletResponse);
        }else
            httpServletRequest.getRequestDispatcher("/WEB-INF/view/task_page.jsp").forward(httpServletRequest, httpServletResponse);
    }

}