package by.simplypvs.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private int id;

    private String login;

    private String password;

    private Role role;


    @Data
    @AllArgsConstructor
    public static class Role {

        private int id;

        String role;


    }


}