package by.simplypvs.servlets;

import by.simplypvs.connectors.Auth;
import by.simplypvs.connectors.ConnectionProvider;
import by.simplypvs.dao.TaskRepos;
import by.simplypvs.dao.UserDAO;
import by.simplypvs.model.Task;
import by.simplypvs.model.User;
import lombok.SneakyThrows;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/tasks")
public class TaskPageServlet extends HttpServlet {

    @SneakyThrows
    public void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
            throws IOException, ServletException {
        if (!Auth.checkAuth(httpServletRequest.getSession(), "admin", "user")) {
            httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/err403");
        } else {
            String login = httpServletRequest.getSession().getAttribute("login").toString();
            User user = new UserDAO(ConnectionProvider.getConnection()).read(login);
            httpServletRequest.setAttribute("troday-list", TaskRepos.getTodayList(user.getId()));
            for (Task task: TaskRepos.getTodayList(user.getId())
                 ) {
                System.out.println(task);
            }

            httpServletRequest.setAttribute("login", login);
            httpServletRequest.getRequestDispatcher("/WEB-INF/view/task-page.jsp").forward(httpServletRequest, httpServletResponse);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (!Auth.checkAuth(req.getSession(), "admin", "user")) {
            resp.sendRedirect(req.getContextPath() + "/err403");
//            httpServletRequest.send().forward(httpServletRequest,httpServletResponse);
        } else {
            req.setAttribute("login", req.getSession().getAttribute("login"));
            req.getRequestDispatcher("/WEB-INF/view/task-page.jsp").forward(req, resp);
        }


    }
}