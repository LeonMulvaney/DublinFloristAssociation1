package com.groupo.dublinfloristassociation;

/**
 * Created by Leon on 18/11/2016.
 */

public class Florist {

   private int _id;
    private String name;
    private String location;
    private String phone;
    private String email;

    //Constructor
    public Florist(int _id,String name, String location, String phone, String email){
        this._id = _id;
        this.name = name;
        this.location = location;
        this.phone = phone;
        this.email = email;

    }


    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    //Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
