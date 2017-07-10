package com.org.entities;

import java.sql.Date;

/**
 * Created by Elat on 02.06.2017.
 */
public class Booking {
    private int id;
    private Date dayOfBooking;
    private Date dayIN;
    private Date dayOUT;
    private int clientId;
    private int roomId;

    @Override
    public String toString() {
        return "Booking{" +
                "id=" + id +
                ", dayOfBooking=" + dayOfBooking +
                ", dayIN=" + dayIN +
                ", dayOUT=" + dayOUT +
                ", clientId=" + clientId +
                ", roomId=" + roomId +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDayOfBooking() {
        return dayOfBooking;
    }

    public void setDayOfBooking(Date dayOfBooking) {
        this.dayOfBooking = dayOfBooking;
    }

    public Date getDayIN() {
        return dayIN;
    }

    public void setDayIN(Date dayIN) {
        this.dayIN = dayIN;
    }

    public Date getDayOUT() {
        return dayOUT;
    }

    public void setDayOUT(Date dayOUT) {
        this.dayOUT = dayOUT;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }
}
