package com.org.jdbc;

import com.org.entities.Admin;
import com.org.entities.ConnectionManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Elat on 11.06.2017.
 */
public class Loginjdbc {
    private static Loginjdbc INSTANCE;

    private static Connection getEmpConnection() {
        ConnectionManager connectionManager = null;
        try {
            connectionManager = new ConnectionManager("jdbc:mysql://127.0.0.1:3306/hotel", "root", "root");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Connection connection = connectionManager.getConnection();
        return connection;
    }

    public static Loginjdbc getInstance() {
        if (INSTANCE == null) {
            synchronized (Loginjdbc.class) {
                if (INSTANCE == null) {
                    INSTANCE = new Loginjdbc();
                }
            }
        }
        return INSTANCE;
    }


    public String readLogin() {
        String login = "";
        try (Connection connection = getEmpConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT hotel.admin.Login FROM hotel.admin;")) {
            Admin admin = null;
            while (resultSet.next()) {
                admin = new Admin();
                admin.setLogin(resultSet.getString("Login"));
                login = admin.getLogin();
            }
            System.out.println(login + "");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return login;
    }
    public String readPassword() {
        String password = "";
        try (Connection connection = getEmpConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT hotel.admin.Password FROM hotel.admin;")) {
            Admin admin = null;
            while (resultSet.next()) {
                admin = new Admin();
                admin.setPassword(resultSet.getString("Password"));
                password = admin.getPassword();
            }
            System.out.println(password + "");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return password;
    }
}
