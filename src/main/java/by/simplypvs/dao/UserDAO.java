package by.simplypvs.dao;

import by.simplypvs.model.User;
import org.jetbrains.annotations.NotNull;
//import com.sun.istack.internal.NotNull;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO implements DAO<User,String> {

    /**
     * Connection of database.
     */
    @NotNull
    private final Connection connection ;

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
            statement.setString(3,user.getRole());
            result = statement.executeQuery().next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;

    }

    @Override
    public User read(@NotNull final String login) {
        final User result = new User();
        result.setId(-1);

        try (PreparedStatement statement = connection.prepareStatement(SQLUser.GET.QUERY)) {
            statement.setString(1, login);
            final ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                result.setId(Integer.parseInt(rs.getString("id")));
                result.setLogin(login);
                result.setPassword(rs.getString("password"));
                result.setRole(rs.getString("role"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * Update User's password by id.
     *
     * @param user new user's state.
     * @return True if success. False if fail.
     */
    @Override
    public boolean update(@NotNull final User user) {
        boolean result = false;

        try (PreparedStatement statement = connection.prepareStatement(SQLUser.UPDATE.QUERY)) {
            statement.setString(1, user.getPassword());
            statement.setInt(2, user.getId());
            result = statement.executeQuery().next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

     @Override
    public boolean delete(@NotNull final User user) {
        boolean result = false;

        try (PreparedStatement statement = connection.prepareStatement(SQLUser.DELETE.QUERY)) {
            statement.setInt(1, user.getId());
            statement.setString(2, user.getLogin());
            statement.setString(3, user.getPassword());
            result = statement.executeQuery().next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
    enum SQLUser {
        GET("SELECT u.id, u.login, u.password, u.role FROM users AS u  WHERE u.login = (?)"),
        INSERT("INSERT INTO users (id, login, password, role) VALUES (DEFAULT, (?), (?), CAST ((?) AS roles)) RETURNING id"),
        DELETE("DELETE FROM users WHERE id = (?) AND login = (?) AND password = (?) RETURNING id"),
        UPDATE("UPDATE users SET password = (?) WHERE id = (?) RETURNING id");

        String QUERY;

        SQLUser(String QUERY) {
            this.QUERY = QUERY;
        }
    }


}
