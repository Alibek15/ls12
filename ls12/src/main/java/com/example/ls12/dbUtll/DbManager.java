package com.example.ls12.dbUtll;

import com.example.ls12.entity.User;

import java.sql.*;

public class DbManager {

    private Connection connection;

    private String url = "jdbc:postgresql://localhost:5432/postgres";
    private String name = "postgres";
    private String password = "postgres";

    public void setConnection(){
        try {
            Class.forName("org.postgresql.Driver"); //говорит какой драйвер использовать, через какой класс запускать то
            //или иное соединение
            connection= DriverManager.getConnection(url,name,password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }

    public User getUserByEmail(String email) {
        User user = new User();



        try ( PreparedStatement statement = connection.prepareStatement("Select * from users where email = ? limit 1")){
            statement.setString(1,email);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                user.setId(Long.valueOf(resultSet.getInt(1)));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
}
