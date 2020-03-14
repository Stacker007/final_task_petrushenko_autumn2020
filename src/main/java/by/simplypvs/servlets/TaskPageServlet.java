package by.simplypvs.servlets;

import by.simplypvs.connectors.Auth;
import by.simplypvs.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/tasks")
public class TaskPageServlet extends HttpServlet {

    public void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
            throws IOException, ServletException {
        if (!Auth.checkAuth(httpServletRequest.getSession(),"admin","user")){
            httpServletResponse.sendRedirect(httpServletRequest.getContextPath()+"/err403");
//            httpServletRequest.send().forward(httpServletRequest,httpServletResponse);
        }else
            httpServletRequest.getRequestDispatcher("/WEB-INF/view/task_page.jsp").forward(httpServletRequest, httpServletResponse);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (!Auth.checkAuth(req.getSession(),"admin","user")){
            resp.sendRedirect(req.getContextPath()+"/err403");
//            httpServletRequest.send().forward(httpServletRequest,httpServletResponse);
        }else
            req.getRequestDispatcher("/WEB-INF/view/task_page.jsp").forward(req, resp);


    }
}