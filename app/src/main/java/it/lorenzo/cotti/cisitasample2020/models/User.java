package it.lorenzo.cotti.cisitasample2020.models;

import java.util.ArrayList;
import java.util.Date;

public class User extends Object {

    public String name = "";
    public String surname = "";
    public int age = 0;
    public Date date;
    public boolean visible = true;

    public User() {

    }

    public String getFullName() {
        return name + " " + surname;
    }
}
