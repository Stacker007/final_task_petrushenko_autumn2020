package by.simplypvs.dao;

import by.simplypvs.model.Task;
import org.jetbrains.annotations.NotNull;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TaskDAO implements DAO<Task, Integer> {
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

    public TaskDAO(final Connection connection) {
        this.connection = connection;
    }


    @Override
    public boolean create(Task newTask) {
        boolean result = false;

        try (PreparedStatement statement = connection.prepareStatement(TaskDAO.SQLTask.INSERT.QUERY)) {
            statement.setInt(1, newTask.getUserID());
            statement.setString(2, newTask.getTaskName());
            statement.setString(3,newTask.getDescription());
            statement.setDate(4, newTask.getDate());
            statement.setString(5, newTask.getFilePath());
            statement.setString(6,newTask.getStatus());
            result = statement.executeQuery().next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Task read(Integer id) {
        final Task result = new Task();
        result.setId(id);

        try (PreparedStatement statement = connection.prepareStatement(TaskDAO.SQLTask.GET.QUERY)) {
            statement.setInt(1, id);
            final ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                result.setUserID(rs.getInt("user_id"));
                result.setTaskName(rs.getString("task_name"));
                result.setDescription(rs.getString("description"));
                result.setDate(rs.getDate("task_date"));
                result.setFilePath(rs.getString("file_path"));
                result.setStatus(rs.getString("status"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;

    }

    @Override
    public boolean update(Task task) {
        boolean result = false;

        try (PreparedStatement statement = connection.prepareStatement(TaskDAO.SQLTask.UPDATE.QUERY)) {
            statement.setInt(1, task.getUserID());
            statement.setString(2, task.getTaskName());
            statement.setString(3, task.getDescription());
            statement.setDate(4, task.getDate());
            statement.setString(5, task.getFilePath());
            statement.setString(6, task.getStatus());
            statement.setInt(7, task.getId());
            result = statement.executeQuery().next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean delete(Task task) {
        boolean result = false;

        try (PreparedStatement statement = connection.prepareStatement(SQLTask.DELETE.QUERY)) {
            statement.setInt(1, task.getId());

            result = statement.executeQuery().next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
    public ArrayList<Task> getLists (int userID,  String afterDate, String beforeDate){
        ArrayList<Task> tasks = new ArrayList<>();
        try(PreparedStatement statement = connection.prepareStatement(SQLTask.GET_LIST.QUERY)){
            statement.setInt(1, userID);
            statement.setString(2,afterDate);
            statement.setString(3,beforeDate);

            final ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                Task task = new Task();
                task.setId(rs.getInt("id"));
                task.setUserID(rs.getInt("user_id"));
                task.setTaskName(rs.getString("task_name"));
                task.setDescription(rs.getString("description"));
                task.setDate(rs.getDate("task_date"));
                task.setFilePath(rs.getString("file_path"));
                task.setStatus(rs.getString("status"));
                tasks.add(task);
//                rs.next();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tasks;
    }
    public ArrayList<Task> getBinList (int userID){
        ArrayList<Task> tasks = new ArrayList<>();
        try(PreparedStatement statement = connection.prepareStatement(SQLTask.GET_BIN_LIST.QUERY)){
            statement.setInt(1, userID);

            final ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                Task task = new Task();
                task.setId(rs.getInt("id"));
                task.setUserID(rs.getInt("user_id"));
                task.setTaskName(rs.getString("task_name"));
                task.setDescription(rs.getString("description"));
                task.setDate(rs.getDate("task_date"));
                task.setFilePath(rs.getString("file_path"));
                task.setStatus(rs.getString("status"));
                tasks.add(task);
//                rs.next();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tasks;
    }

    enum SQLTask {
        GET("SELECT t.id, t.user_id, t.task_name, t.description, t.task_date, t.file_path, t.status FROM tasks AS t  WHERE t.id = (?)"),
        INSERT("INSERT INTO tasks (id, user_id, task_name, description, task_date, file_path, status) " +
                "VALUES (DEFAULT, (?), (?), (?), (?), (?), CAST ((?) AS tsk_stat)) RETURNING id"),
        DELETE("DELETE FROM tasks WHERE id = (?) RETURNING id"),
        UPDATE("UPDATE tasks SET user_id = (?), task_name = (?), description = (?), task_date = (?), file_path = (?), status = CAST ((?) AS tsk_stat)   WHERE id = (?) RETURNING id"),
        GET_LIST("SELECT * FROM tasks WHERE user_id = (?) AND task_date >= CAST((?) AS date) AND task_date <= CAST((?) AS date) AND status = 'active'"),
        GET_BIN_LIST("SELECT * FROM tasks WHERE status = 'trash' and user_id = (?) ");
//        OR status = 'trash' OR status = 'completed'and user_id = (?)

        String QUERY;

        SQLTask(String QUERY) {
            this.QUERY = QUERY;
        }
    }


}
