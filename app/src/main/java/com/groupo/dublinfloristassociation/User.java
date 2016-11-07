package com.groupo.dublinfloristassociation;

/**
 * Created by Kaos117 on 28/10/2016.
 */

public class User {


    //var we will use
    private int _id;
    private String _email;
    private String _name;
    private String _phoneNum;
    private String _address;
    private String _password;
    private String _passwordConfirm;

    public User(){

    }

    //constructor for instances
    public User(String email, String name, String phoneNum, String address, String password) {
        this._email = email;
        this._name = name;
        this._phoneNum = phoneNum;
        this._address = address;
        this._password = password;
    }

    //setters
    public void set_email(String _email) { this._email = _email;}

    public void set_name(String _name) {
        this._name = _name;
    }

    public void set_phoneNum(String _phoneNum) {
        this._phoneNum = _phoneNum;
    }

    public void set_address(String _address) {
        this._address = _address;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public void set_password(String _password) {
        this._password = _password;
    }

    public void set_passwordConfirm(String _passwordConfirm) { this._passwordConfirm = _passwordConfirm; }

    //getters
    public int get_id() {
        return _id;
    }

    public String get_email() { return _email;}

    public String get_name() {
        return _name;
    }

    public String get_phoneNum() {
        return _phoneNum;
    }

    public String get_address() {
        return _address;
    }

    public String get_password() {
        return _password;
    }

    public String get_passwordConfirm() {
        return _passwordConfirm;
    }


}

