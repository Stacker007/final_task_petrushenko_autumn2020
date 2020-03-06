package by.simplypvs.dao;

import by.simplypvs.model.User;
import org.jetbrains.annotations.NotNull;
//import com.sun.istack.internal.NotNull;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDAO implements DAO<User,String> {

    /**
     * Connection of database.
     */
    @NotNull
    private final Connection connection;

    /**
     * Init database connection.
     *
     * @param connection of database.
     */
    public UserDAO(final Connection connection) {
        this.connection = connection;
    }


    @Override
    public boolean create(@NotNull User user) {
        boolean result = false;

        try (PreparedStatement statement = connection.prepareStatement(SQLUser.INSERT.QUERY)) {
            statement.setString(1, user.getLogin());
            statement.setString(2, user.getPassword());
            statement.setInt(3,user.getRole().getId());
            result = statement.executeQuery().next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;

    }

    @Override
    public User read(String s) {
        return null;
    }

    @Override
    public boolean update(User model) {
        return false;
    }

    @Override
    public boolean delete(User model) {
        return false;
    }
    enum SQLUser {
        GET("SELECT u.id, u.login, u.password, r.id AS rol_id, r.role FROM users AS u LEFT JOIN roles AS r ON u.role = r.id WHERE u.login = (?)"),
        INSERT("INSERT INTO users (id, login, password, role) VALUES (DEFAULT, (?), (?), (?)) RETURNING id"),
        DELETE("DELETE FROM users WHERE id = (?) AND login = (?) AND password = (?) RETURNING id"),
        UPDATE("UPDATE users SET password = (?) WHERE id = (?) RETURNING id");

        String QUERY;

        SQLUser(String QUERY) {
            this.QUERY = QUERY;
        }
    }
}
