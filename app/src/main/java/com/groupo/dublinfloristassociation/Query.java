package com.groupo.dublinfloristassociation;

/**
 * Created by Kaos117 on 05/11/2016.
 */

public class Query {

    private int _id;
    private String _name;
    private String _query;


    public Query(String _name, String _query) {
        this._name = _name;
        this._query = _query;
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

    public String get_query() {
        return _query;
    }

    public void set_query(String _query) {
        this._query = _query;
    }
}
