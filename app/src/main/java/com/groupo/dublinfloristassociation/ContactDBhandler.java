package com.groupo.dublinfloristassociation;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Kaos117 on 05/11/2016.
 */

public class ContactDBhandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "floristAppDB.db";
    private static final String DATABASE_TABLE = "contactQuery";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_NAME = "_name";
    private static final String COLUMN_QUERY = "_query";



    public ContactDBhandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query =  "CREATE TABLE" + DATABASE_TABLE + "(" +
                        COLUMN_ID + "INTEGER PRIMARY KEY AUTOINCREMENT" +
                        COLUMN_NAME + "TEXT" +
                        COLUMN_QUERY + "TEXT" + ");";

        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE);
        onCreate(db);
    }

    //add new row
    public boolean addQuery(Query q){
            ContentValues values = new ContentValues();
            values.put(COLUMN_NAME, q.get_name());
            values.put(COLUMN_QUERY, q.get_query());

            SQLiteDatabase db = getWritableDatabase();
            db.insert(DATABASE_TABLE, null, values);

            db.close();
            return true;
    }


}
