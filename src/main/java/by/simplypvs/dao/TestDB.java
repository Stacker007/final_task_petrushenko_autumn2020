package by.simplypvs.dao;

import by.simplypvs.connectors.ConnectionProvider;
import by.simplypvs.model.Task;
import lombok.SneakyThrows;

import java.sql.Date;
import java.util.ArrayList;

public class TestDB {
    @SneakyThrows
    public static void main(String[] args) {

//
//        System.out.println(TaskRepos.getToday());
//        System.out.println(TaskRepos.getTomorrow());
//        System.out.println(TaskRepos.getAfterTomorrow());
//
//
//        ArrayList<Task> tasks = TaskRepos.getTodayList(2);
//        for (Task task:tasks
//             ) {
//            System.out.println(task);
//        }
//        System.out.println("---");
//        tasks = TaskRepos.getTomorrowList(2);
//        for (Task task:tasks
//        ) {
//            System.out.println(task);
//        }
//        System.out.println("---");
//        tasks = TaskRepos.getSomeDayList(2);
//        for (Task task:tasks
//        ) {
//            System.out.println(task);
//        }
//        System.out.println("---");
//        tasks = TaskRepos.getBinList(1);
//        for (Task task:tasks
//        ) {
//            System.out.println(task);
//        }
//        System.out.println("---");
//        tasks = TaskRepos.getBinList(2);
//        for (Task task:tasks
//        ) {
//            System.out.println(task);
//        }



        ConnectionProvider.closeConnection();


    }


}
