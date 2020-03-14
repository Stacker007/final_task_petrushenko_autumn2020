package by.simplypvs.servlets.listeners;

import by.simplypvs.connectors.ConnectionProvider;
import lombok.SneakyThrows;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@WebListener
public class AppContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
    }

    @SneakyThrows
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        ConnectionProvider.closeConnection();
    }
}
