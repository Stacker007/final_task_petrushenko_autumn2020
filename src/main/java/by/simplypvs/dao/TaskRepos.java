package by.simplypvs.dao;

import by.simplypvs.connectors.ConnectionProvider;
import by.simplypvs.model.Task;
import lombok.SneakyThrows;


import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;



public  class TaskRepos {
    public static final String MAX_DATE = "2050-01-01";
    @SneakyThrows
    public static ArrayList<Task> getTodayList(int userID) {

        ArrayList<Task> tasks = new TaskDAO(ConnectionProvider.getConnection()).getLists(userID,
                "" + new java.sql.Date(0),getToday().toString());
        return tasks;
    }

    @SneakyThrows
    public static ArrayList<Task> getTomorrowList(int userID) {

        ArrayList<Task> tasks = new TaskDAO(ConnectionProvider.getConnection()).getLists(userID,
                getTomorrow().toString(), getTomorrow().toString());
        return tasks;
    }
    @SneakyThrows
    public static ArrayList<Task> getSomeDayList(int userID) {

        ArrayList<Task> tasks = new TaskDAO(ConnectionProvider.getConnection()).getLists(userID,
                getAfterTomorrow().toString(), MAX_DATE);
        return tasks;
    }
    @SneakyThrows
    public static ArrayList<Task> getBinList(int userID){
        return new TaskDAO(ConnectionProvider.getConnection()).getBinList(userID);

    }

    public static Date getToday(){
        return new java.sql.Date(Calendar.getInstance().getTime().getTime());
    }
    public static Date getTomorrow(){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE,1);
        return new Date(calendar.getTime().getTime());
    }

    public static Date getAfterTomorrow(){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE,2);
        return new Date(calendar.getTime().getTime());
    }

}
