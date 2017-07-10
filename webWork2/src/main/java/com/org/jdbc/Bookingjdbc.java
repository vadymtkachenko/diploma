package com.org.jdbc;

import com.org.MyException;
import com.org.entities.Booking;
import com.org.entities.ConnectionManager;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Elat on 04.06.2017.
 */
public class Bookingjdbc {
    private static Bookingjdbc INSTANCE;

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

    public static Bookingjdbc getInstance() {
        if (INSTANCE == null) {
            synchronized (Bookingjdbc.class) {
                if (INSTANCE == null) {
                    INSTANCE = new Bookingjdbc();
                }
            }
        }
        return INSTANCE;
    }


    public List<Booking> read() {


        List<Booking> BookingList = new LinkedList<>();
        try (Connection connection = getEmpConnection();
             Statement statement = connection.createStatement();

             ResultSet resultSet = statement.executeQuery("SELECT * FROM hotel.booking")) {


            Booking booking = null;

            while (resultSet.next()) {

                booking = new Booking();

                booking.setId(Integer.parseInt(resultSet.getString("idBooking")));

                booking.setClientId(Integer.parseInt(resultSet.getString("idclient")));

                booking.setRoomId(Integer.parseInt(resultSet.getString("idRoom")));

                booking.setDayOfBooking(resultSet.getDate("Date_of_booking"));

                booking.setDayIN(resultSet.getDate("Date_IN"));
                booking.setDayOUT(resultSet.getDate("Date_OUT"));

                BookingList.add(booking);

            }
            System.out.println(BookingList);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return BookingList;

    }

    public Booking getById(int id) {
        for (Booking dep : Bookingjdbc.getInstance().read()) {
            if (dep.getId() == id) {
                return dep;
            }
        }
        return null;
    }


    public void update(Booking booking) throws MyException {

        try (Connection connection = getEmpConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("UPDATE `hotel`.`booking` SET `Date_of_booking`=?, `idclient`=?, `idRoom`=?, `Date_IN`=?, `Date_OUT`=? WHERE `idBooking`=?;")) {

            preparedStatement.setDate(1, booking.getDayOfBooking());

            preparedStatement.setInt(2, booking.getClientId());
            preparedStatement.setInt(3, booking.getRoomId());
            preparedStatement.setDate(4, booking.getDayIN());
            preparedStatement.setDate(5, booking.getDayOUT());
            preparedStatement.setInt(6, booking.getId());

            preparedStatement.executeUpdate();


        } catch (SQLException e) {

            //throw new MyException("Exception while update row 'Name' in database");
            e.printStackTrace();

        }

    }

    public void delete(Booking booking){

        try (Connection connection = getEmpConnection();

             PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM `hotel`.`booking` WHERE `idBooking`=?;");
        ) {


            preparedStatement.setInt(1, booking.getId());


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

    public void create(Booking booking) throws MyException {

        try (Connection connection = getEmpConnection();
             PreparedStatement ps = connection.prepareStatement("INSERT INTO `hotel`.`booking` ( `Date_of_booking`, `idclient`, `idRoom`, `Date_IN`, `Date_OUT` ) VALUES (?,?,?,?,?)")) {

            ps.setDate(1,booking.getDayOfBooking());
            ps.setInt(2, booking.getClientId());
            ps.setInt(3, booking.getRoomId());
            ps.setDate(4,booking.getDayIN());
            ps.setDate(5,booking.getDayOUT());

            ps.executeUpdate();


        } catch (SQLException e) {

            e.printStackTrace();
        }


    }
}
