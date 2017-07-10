package com.org.jdbc;

import com.org.MyException;
import com.org.entities.Client;
import com.org.entities.ConnectionManager;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Elat on 11.04.2017.
 */
public class Clientjdbc {

    private static Clientjdbc INSTANCE;

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

    public static Clientjdbc getInstance() {
        if (INSTANCE == null) {
            synchronized (Clientjdbc.class) {
                if (INSTANCE == null) {
                    INSTANCE = new Clientjdbc();
                }
            }
        }
        return INSTANCE;
    }


    public List<Client> read() {


        List<Client> depList = new LinkedList<>();
        try (Connection connection = getEmpConnection();
             Statement statement = connection.createStatement();

             ResultSet resultSet = statement.executeQuery("SELECT * FROM hotel.clients")) {


            Client client = null;

            while (resultSet.next()) {

                client = new Client();

                client.setId(Integer.parseInt(resultSet.getString("idclient")));

                client.setName(resultSet.getString("Name"));

                client.setSurname(resultSet.getString("Surname"));

                client.setTelephone(resultSet.getString("Telephone"));

                client.setWith(resultSet.getString("With"));

                depList.add(client);

            }
            System.out.println(depList);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return depList;

    }

    public Client getById(int id) {
        for (Client dep : Clientjdbc.getInstance().read()) {
            if (dep.getId() == id) {
                return dep;
            }
        }
        return null;
    }


    public void update(Client client) throws MyException {

        try (Connection connection = getEmpConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("UPDATE `hotel`.`clients` SET `Name`=?, `Surname`=?, `With`=?, `Telephone`=? WHERE `idclient`=?;")) {

            preparedStatement.setString(1, client.getName());

            preparedStatement.setString(2, client.getSurname());
            preparedStatement.setString(3, client.getWith());
            preparedStatement.setString(4, client.getTelephone());
            preparedStatement.setInt(5, client.getId());

            preparedStatement.executeUpdate();


        } catch (SQLException e) {

            throw new MyException("Exception while update row 'Telephone' in database");


        }

    }

    public void delete(Client client){

        try (Connection connection = getEmpConnection();

             PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM `hotel`.`clients` WHERE `idclient`=?;");
        ) {


            preparedStatement.setInt(1, client.getId());


            preparedStatement.executeUpdate();


        } catch (SQLException e) {

            // TODO Auto-generated catch block

            e.printStackTrace();

        }


    }

//    public List<Room> getEmployeesById(Client client) throws MyException {
//
//        List<Room> roomList = new LinkedList<>();
//        try {
//            Connection connection = getEmpConnection();
//            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM mydb.employees where idDep = ?;");
//            preparedStatement.setInt(1, client.getId());
//            ResultSet resultSet = preparedStatement.executeQuery();
//
//
//            Room room1 = null;
//
//            while (resultSet.next()) {
//
//                room1 = new Room();
//
//                room1.setId(Integer.parseInt(resultSet.getString("idEmployees")));
//
//                room1.setName(resultSet.getString("name"));
//
//                room1.setSurname(resultSet.getString("surname"));
//
//                room1.setEmail(resultSet.getString("email"));
//
//                room1.setDepId(Integer.parseInt(resultSet.getString("idDep")));
//
//                room1.setDate(Date.valueOf(resultSet.getString("birthday")));
//
//                roomList.add(room1);
//
//            }
//
//            resultSet.close();
//            preparedStatement.close();
//            connection.close();
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//            throw new MyException("Exception while getting LIST");
//        }
//
//        //System.out.println(roomList);
//        return roomList;
//
//    }
//

    public void create(Client client) throws MyException {

        try (Connection connection = getEmpConnection();
             PreparedStatement ps = connection.prepareStatement("INSERT INTO `hotel`.`clients` ( `Name`, `Surname`, `With`, `Telephone` ) VALUES (?,?,?,?)")) {

            ps.setString(1, client.getName());

            ps.setString(2, client.getSurname());

            ps.setString(3,client.getWith());

            ps.setString(4,client.getTelephone());

            ps.executeUpdate();


        } catch (SQLException e) {

            throw new MyException("Exception while accessing database");
        }


    }


}
