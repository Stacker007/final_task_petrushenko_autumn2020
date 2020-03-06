package by.simplypvs.dao;

import by.simplypvs.model.Task;

public class TaskDAO implements DAO<Task, Integer> {

    @Override
    public boolean create(Task model) {
        return false;
    }

    @Override
    public Task read(Integer integer) {
        return null;
    }

    @Override
    public boolean update(Task model) {
        return false;
    }

    @Override
    public boolean delete(Task model) {
        return false;
    }
}
