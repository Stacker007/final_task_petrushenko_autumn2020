package by.simplypvs.dao;

import by.simplypvs.connectors.ConnectionProvider;
import by.simplypvs.model.Task;
import lombok.SneakyThrows;

import java.sql.Date;

public class TestDB {
    @SneakyThrows
    public static void main(String[] args) {
//        Task task = new Task(-1,
//                2,
//                "find more resolves",
//                "you must do it",
//                new Date((new java.util.Date()).getTime()),
//                "/file_path",
//                "active"
//                );
//        if (new TaskDAO(ConnectionProvider.getConnection()).create(task)){
//            System.out.println("ok");
//
//        }
//        System.out.println("" +
//

             Task task =   new TaskDAO(ConnectionProvider.getConnection()).read(5);
//             task.setStatus("completed");
//        System.out.println(new TaskDAO(ConnectionProvider.getConnection()).update(task));
//        System.out.println(new TaskDAO(ConnectionProvider.getConnection()).read(5));
        System.out.println(new TaskDAO(ConnectionProvider.getConnection()).delete(task));



        ConnectionProvider.closeConnection();


    }


}
