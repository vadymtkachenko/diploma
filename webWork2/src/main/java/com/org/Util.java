package com.org;

import com.org.entities.Booking;
import com.org.entities.Client;
import com.org.entities.Room;
import com.org.jdbc.Bookingjdbc;
import com.org.jdbc.Clientjdbc;
import com.org.jdbc.Roomjdbc;

/**
 * Created by Elat on 08.04.2017.
 */
public class Util {

    public static void main(String[] args) {
        Roomjdbc roomjdbc = new Roomjdbc();
        Room room = new Room();
//////
        Clientjdbc clientjdbc = new Clientjdbc();
        Client client = new Client();

        Bookingjdbc bookingjdbc = new Bookingjdbc();
        Booking booking = new Booking();

//        booking.setId(4);
//bookingjdbc.delete(booking);
////        booking.setDayOfBooking(Date.valueOf("2016-12-12"));
////        booking.setClientId(4);
////        booking.setRoomId(4);
////        booking.setDayIN(Date.valueOf("2016-05-21"));
////        booking.setDayOUT(Date.valueOf("2016-05-21"));
////
////        try {
////            bookingjdbc.update(booking);
////        } catch (MyException e) {
////            e.printStackTrace();
////        }
//
//        bookingjdbc.read();
////        client.setName("Qwerty");
////        client.setSurname("qwerty");
////        client.setWith("Sisetr");
////        client.setTelephone("0666352585");
////        try {
////            clientjdbc.create(client);
////        } catch (MyException e) {
////            e.printStackTrace();
////        }
//        client.setId(1);
//        client.setName("Игорь");
//        client.setSurname("Йук");
//        client.setTelephone("0222145478");
//        client.setWith("Дочка");
////        try {
////            clientjdbc.update(client);
////        } catch (MyException e) {
////            e.printStackTrace();
////        }
////
        try {
            roomjdbc.getFreeRooms("2010-07-02","2010-07-12");
        } catch (MyException e) {
            e.printStackTrace();
        }
//        //clientjdbc.read();
//        room.setId(5);
//        roomjdbc.delete(room);
//
//        room.setNumber(54);
//        room.setStage(2);
//        room.setPrice(1220.21);
//        room.setType("Take");
//        try {
//            roomjdbc.create(room);
//        } catch (MyException e) {
//            e.printStackTrace();
//        }
     //   try {
       //     roomjdbc.update(room);
     //   } catch (MyException e) {
     //       e.printStackTrace();
        }
       // roomjdbc.read();
//        department.setId(1);
//        department.setName("Salej5");
////        department.setNumber(0);
//        try {
//            clientjdbc.create(department);
//        }
//        catch (MyException e){
//            System.out.println("ERROR");
//        }


//--------------------




}
