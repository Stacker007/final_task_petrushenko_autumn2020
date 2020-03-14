package by.simplypvs.connectors;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider implements SQLConnectionData {

    static Connection connection = null;

    public static Connection getConnection() throws ClassNotFoundException, SQLException {

        if (!(connection == null)) return connection;
        Class.forName("org.postgresql.Driver");
        connection = DriverManager.getConnection(connURL, username, pwd);
        return connection;
    }

    public static void closeConnection() throws SQLException {
        connection.close();
    }

}
