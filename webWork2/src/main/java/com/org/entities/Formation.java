package com.org.entities;

import java.sql.Date;

/**
 * Created by Elat on 11.06.2017.
 */
public class Formation {
    private int id;
    private String name;
    private String surname;
    private String telephone;
    private int number;
    private Date dayIN;
    private Date dayOUT;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
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
}
