package by.simplypvs.servlets;

import by.simplypvs.connectors.ConnectionProvider;
import by.simplypvs.dao.UserDAO;
import by.simplypvs.model.User;
import lombok.SneakyThrows;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.concurrent.atomic.AtomicReference;

@WebListener
public class ContextListener implements ServletContextListener {
    /**
     * Fake database connector.
     */
    private AtomicReference<UserDAO> dao;

    /**
     * Open DB connection before start first servlet
     * @param servletContextEvent
     */

    @SneakyThrows
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        Connection connection = ConnectionProvider.getConnection();
    }

    @SneakyThrows
    @Override
    public void contextDestroyed(ServletContextEvent sce) {

        ConnectionProvider.closeConnection();
    }
}