package com.org.jdbc;

import com.org.MyException;
import com.org.entities.ConnectionManager;
import com.org.entities.Formation;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Elat on 11.06.2017.
 */
public class Formationjdbc {
    private static Formationjdbc INSTANCE;

    private static Connection getEmpConnection() {
        ConnectionManager connectionManager = null;
        try {
            connectionManager = new ConnectionManager("jdbc:mysql://127.0.0.1:3306/hotel?useUnicode=true&characterEncoding=utf-8", "root", "root");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Connection connection = connectionManager.getConnection();
        return connection;
    }

    public static Formationjdbc getInstance() {
        if (INSTANCE == null) {
            synchronized (Formationjdbc.class) {
                if (INSTANCE == null) {
                    INSTANCE = new Formationjdbc();
                }
            }
        }
        return INSTANCE;
    }


    public List<Formation> read() {


        List<Formation> FormationList = new LinkedList<>();
        try (Connection connection = getEmpConnection();
             Statement statement = connection.createStatement();

             ResultSet resultSet = statement.executeQuery("SELECT * FROM hotel.formation")) {


            Formation Formation = null;

            while (resultSet.next()) {

                Formation = new Formation();

                Formation.setId(Integer.parseInt(resultSet.getString("idformation")));

                Formation.setName(resultSet.getString("Name"));

                Formation.setSurname(resultSet.getString("Surname"));

                Formation.setTelephone(resultSet.getString("Telephone"));

                Formation.setNumber(Integer.parseInt(resultSet.getString("Number")));

                Formation.setDayIN(resultSet.getDate("Date_IN"));
                Formation.setDayOUT(resultSet.getDate("Date_OUT"));

                FormationList.add(Formation);

            }
            System.out.println(FormationList);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return FormationList;

    }

    public Formation getById(int id) {
        for (Formation dep : Formationjdbc.getInstance().read()) {
            if (dep.getId() == id) {
                return dep;
            }
        }
        return null;
    }


//    public void update(Booking booking) throws MyException {
//
//        try (Connection connection = getEmpConnection();
//             PreparedStatement preparedStatement = connection.prepareStatement("UPDATE `hotel`.`booking` SET `Date_of_booking`=?, `idclient`=?, `idRoom`=?, `Date_IN`=?, `Date_OUT`=? WHERE `idBooking`=?;")) {
//
//            preparedStatement.setDate(1, booking.getDayOfBooking());
//
//            preparedStatement.setInt(2, booking.getClientId());
//            preparedStatement.setInt(3, booking.getRoomId());
//            preparedStatement.setDate(4, booking.getDayIN());
//            preparedStatement.setDate(5, booking.getDayOUT());
//            preparedStatement.setInt(6, booking.getId());
//
//            preparedStatement.executeUpdate();
//
//
//        } catch (SQLException e) {
//
//            //throw new MyException("Exception while update row 'Name' in database");
//            e.printStackTrace();
//
//        }
//
//    }

    public void delete(Formation formation) {

        try (Connection connection = getEmpConnection();

             PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM `hotel`.`formation` WHERE `idformation`=?;");
        ) {


            preparedStatement.setInt(1, formation.getId());


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

    public void create(Formation formation) throws MyException {

        try (Connection connection = getEmpConnection();
             PreparedStatement ps = connection.prepareStatement("INSERT INTO `hotel`.`formation` ( `Name`, `Surname`, `Telephone`, `Number`, `Date_IN`, `Date_OUT` ) VALUES (?,?,?,?,?,?)")) {

            ps.setString(1, formation.getName());
            ps.setString(2, formation.getSurname());
            ps.setString(3, formation.getTelephone());
            ps.setInt(4, formation.getNumber());
            ps.setDate(5, formation.getDayIN());
            ps.setDate(6, formation.getDayOUT());

            ps.executeUpdate();


        } catch (SQLException e) {

            e.printStackTrace();
        }


    }

}
