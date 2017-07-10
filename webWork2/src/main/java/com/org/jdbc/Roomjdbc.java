package com.org.jdbc;

import com.org.MyException;
import com.org.entities.ConnectionManager;
import com.org.entities.Room;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Elat on 08.04.2017.
 */
public class Roomjdbc {

    private static Roomjdbc INSTANCE;

    private static Connection getEmpConnection() throws SQLException {
        ConnectionManager connectionManager = null;
        String URL = "jdbc:mysql://127.0.0.1:3306/hotel";
        String LOGIN = "root";
        String PASSWORD = "root";

        try {
            connectionManager = new ConnectionManager(URL, LOGIN, PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        Connection connection = connectionManager.getConnection();
        return connection;
    }

    public static Roomjdbc getInstance() {
        if (INSTANCE == null) {
            synchronized (Roomjdbc.class) {
                if (INSTANCE == null) {
                    INSTANCE = new Roomjdbc();
                }
            }
        }
        return INSTANCE;
    }


    public List<Room> read() {


        List<Room> roomList = new LinkedList<>();
        try (Connection connection = getEmpConnection();
             Statement statement = connection.createStatement();

             ResultSet resultSet = statement.executeQuery("SELECT * FROM hotel.rooms");) {


            Room room = null;

            while (resultSet.next()) {

                room = new Room();

                room.setId(Integer.parseInt(resultSet.getString("idRoom")));

                room.setNumber(Integer.parseInt(resultSet.getString("Number")));

                room.setPrice(Double.parseDouble(resultSet.getString("Price")));

                room.setStage(Integer.parseInt(resultSet.getString("Stage")));

                room.setType(resultSet.getString("Type"));


                roomList.add(room);

            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(roomList);
        return roomList;

    }

        public List<Room> getFreeRooms(String in, String out) throws MyException {

        List<Room> roomList = new LinkedList<>();
        try {
            Connection connection = getEmpConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT hotel.rooms.Number, hotel.rooms.Type,hotel.rooms.Price" +
                    "  FROM hotel.rooms WHERE rooms.idRoom in (select hotel.booking.idRoom from hotel.booking where (? < hotel.booking.Date_IN and ? <= hotel.booking.Date_IN)" +
                    " or (? >= hotel.booking.Date_OUT and ? > hotel.booking.Date_OUT))" +
                    " or hotel.rooms.idRoom not in (select hotel.booking.idRoom from hotel.booking);");
            preparedStatement.setString(1, in);
            preparedStatement.setString(2, out);
            preparedStatement.setString(3, in);
            preparedStatement.setString(4, out);
            ResultSet resultSet = preparedStatement.executeQuery();


            Room room1 = null;

            while (resultSet.next()) {

                room1 = new Room();

                room1.setNumber(Integer.parseInt(resultSet.getString("Number")));

                room1.setType(resultSet.getString("Type"));

                room1.setPrice(resultSet.getDouble("Price"));

                roomList.add(room1);

            }

            resultSet.close();
            preparedStatement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new MyException("Exception while getting LIST");
        }
            System.out.println(roomList);

        return roomList;

    }


    public Room getById(int id) {
        for (Room emp : Roomjdbc.getInstance().read()) {
            if (emp.getId() == id) {
                return emp;
            }
        }
        return null;
    }

    public void update(Room room) throws MyException {

        try (Connection connection = getEmpConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("UPDATE `hotel`.`rooms` SET `Number`=?, `Price`=?, `Stage`=?, `Type`=? WHERE `idRoom`=?;");
        ) {

            preparedStatement.setInt(1, room.getNumber());

            preparedStatement.setDouble(2, room.getPrice());

            preparedStatement.setInt(3, room.getStage());

            preparedStatement.setString(4, room.getType());

            preparedStatement.setInt(5, room.getId());

            preparedStatement.executeUpdate();


        } catch (SQLException e) {

            throw new MyException("Exception while updating database");

        }

    }

    public void delete(Room room) {

        try (Connection connection = getEmpConnection();

             PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM `hotel`.`rooms` WHERE `idRoom`=?;");
        ) {

            preparedStatement.setInt(1, room.getId());

            preparedStatement.executeUpdate();


        } catch (SQLException e) {

            // TODO Auto-generated catch block

            e.printStackTrace();

        }

    }


    public void create(Room room) throws MyException {

        try (Connection connection = getEmpConnection();
             PreparedStatement ps = connection.prepareStatement("INSERT INTO `hotel`.`rooms` ( `Number`, `Type`, `Stage`, `Price`) VALUES (?,?,?,?)");
        ) {


            ps.setInt(1, room.getNumber());

            ps.setString(2, room.getType());

            ps.setInt(3, room.getStage());

            ps.setDouble(4, room.getPrice());


            ps.executeUpdate();


        } catch (SQLException e) {

            throw new MyException("Exception while accessing database");
        }


    }
}
