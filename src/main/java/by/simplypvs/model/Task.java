package by.simplypvs.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Task {
    int id;
    int userID;
    String taskName;
    String description;
    java.sql.Date date;
    String filePath;
    String status;


}
