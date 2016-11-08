package com.groupo.dublinfloristassociation;

/**
 * Created by Kaos117 on 05/11/2016.
 */

public class Reviewer {

    private int _id;
    private String _name;
    private String _review;
    private int _stars;


    public Reviewer(String _name, String _review, int _stars) {
        this._name = _name;
        this._review = _review;
        this._stars = _stars;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String get_name() {
        return _name;
    }

    public void set_name(String _name) {
        this._name = _name;
    }

    public String get_review() {
        return _review;
    }

    public void set_review(String _review) {
        this._review = _review;
    }

    public int get_stars() {
        return _stars;
    }

    public void set_stars(int _stars) {
        this._stars = _stars;
    }
}
