package com.groupo.dublinfloristassociation;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Button;

import java.util.ArrayList;

/**
 * Created by Kaos117 on 28/10/2016.
 */

public class DBhandler extends SQLiteOpenHelper {

    //Database Version
    private static final int DATABASE_VERSION = 1;

    //Database Name
    private static final String DATABASE_NAME = "floristAppDB.db"; //Database file - .db extension tells android that a database file is stored here

    //user table
    private static final String DATABASE_TABLE = "userRegisterInfo";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_EMAIL = "email";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_PHONENUM = "phoneNum";
    private static final String COLUMN_ADDRESS = "address";
    private static final String COLUMN_PASSWORD = "password";

    // review table attributes
    public static final String REVIEW_TABLE = "Reviews";
    private static final String REVIEW_NAME = "name";
    private static final String COLUMN_REVIEW = "review";
    private static final String COLUMN_STARS = "stars";

    //Add new Florists A-Z Table
    public static final String AZ_TABLE = "FloristsAZ";
    public static final String AZ_ID = "_id";
    public static final String FLORIST_NAME = "FloristName";
    public static final String FLORIST_LOCATION = "Location";
    public static final String FLORIST_PHONE = "Phone";
    public static final String FLORIST_EMAIL = "Email";



    public DBhandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }


    //creates table and columns
    @Override
    public void onCreate(SQLiteDatabase db) {
        String users = "CREATE TABLE " + DATABASE_TABLE + "(" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_EMAIL + " TEXT," +
                COLUMN_NAME + " TEXT," +
                COLUMN_PHONENUM + " INTEGER," +
                COLUMN_ADDRESS + " TEXT," +
                COLUMN_PASSWORD + " TEXT" +
                ");";
        db.execSQL(users);

        String review = "CREATE TABLE " + REVIEW_TABLE + "(" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                REVIEW_NAME + " TEXT NOT NULL," +
                COLUMN_REVIEW + " TEXT NOT NULL," +
                COLUMN_STARS + " INTEGER" +
                ");";
        db.execSQL(review);

        String az = "CREATE TABLE " + AZ_TABLE + "(" +
                AZ_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                FLORIST_NAME + " TEXT," +
                FLORIST_LOCATION + " TEXT," +
                FLORIST_PHONE + " TEXT ,"+
                FLORIST_EMAIL + " TEXT"+
                ");";
        db.execSQL(az);




    }

    //update table
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + REVIEW_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + AZ_TABLE);
        onCreate(db);
    }

    //Add Florist entry to the database
    public void addFlorist(){
       SQLiteDatabase db = getWritableDatabase();
        //String query = "Insert into FloristsAZ (FloristName,Location,PhoneNumber,Email) Values ('Florist 1','Clondalkin','11221','info@florist1.ie');";
        String query1 = "INSERT INTO " + AZ_TABLE + "(FloristName,Location,PhoneNumber,Email) Values ('Florist 1','Clondalkin','11221','info@florist1.ie');";
        db.execSQL("INSERT INTO " + AZ_TABLE + "(" + FLORIST_NAME + "," + FLORIST_LOCATION + "," + FLORIST_PHONE + "," + FLORIST_EMAIL +") VALUES('Artisan Flowers','Ballyowen Castle Shopping Centre, Lucan','086 033 1033','artisanflowersdublin@gmail.com')");
        db.execSQL("INSERT INTO " + AZ_TABLE + "(" + FLORIST_NAME + "," + FLORIST_LOCATION + "," + FLORIST_PHONE + "," + FLORIST_EMAIL +") VALUES('All Seasons Flowers','Superquinn Shopping Centre, Lucan','01 624 0801','info@allseasonsflowers.ie')");
        db.execSQL("INSERT INTO " + AZ_TABLE + "(" + FLORIST_NAME + "," + FLORIST_LOCATION + "," + FLORIST_PHONE + "," + FLORIST_EMAIL +") VALUES('Jackies Florist Ltd','Ballyfermot Road, Ballyfermot, Dublin 10','01 626 7666','info@jackiesflorist.ie')");


        /*ContentValues values = new ContentValues();
        values.put(COLUMN_EMAIL,"leonmul96@gmail.com");
        values.put(COLUMN_NAME, "Leon");
        values.put(COLUMN_PHONENUM, 1122);
        values.put(COLUMN_ADDRESS, "Clondalkin");
        values.put(COLUMN_PASSWORD, "pass");

        SQLiteDatabase db = getWritableDatabase();
        db.insert(DATABASE_TABLE, null, values); */

        //db.execSQL(query1);
        db.close();

        //db.execSQL(query2);
       // db.close();
    }



 /*https://github.com/buckyroberts/Source-Code-from-Tutorials/blob/master/Android_Beginners/049-054%20SQLite/49%20to%2054%20SQLite.txt Tutorial Online */
    public String floristToString1(){
        String dbString = "";
        SQLiteDatabase db = getReadableDatabase(); //Could also be getWritableDatabase
        String query = "SELECT * FROM " + AZ_TABLE + " WHERE " + AZ_ID + "=" + 1;

        //Cursor points to a location in your results
        Cursor recordSet = db.rawQuery(query, null);
        //Move to the first row in your results
        recordSet.moveToFirst();

        //Position after the last row means the end of the results
        while (!recordSet.isAfterLast()) {
            // null could happen if we used our empty constructor
            if (recordSet.getString(recordSet.getColumnIndex("_id")) != null) {
                dbString += recordSet.getString(recordSet.getColumnIndex("FloristName"));
                dbString += "\n";
                dbString += recordSet.getString(recordSet.getColumnIndex("Location"));
                dbString += "\n";
                dbString += recordSet.getString(recordSet.getColumnIndex("Phone"));
                dbString += "\n";
                dbString += recordSet.getString(recordSet.getColumnIndex("Email"));
                dbString += "\n";
            }
            recordSet.moveToNext();
        }
        db.close();
        return dbString;
    }

    public String floristToString2(){
        String dbString = "";
        SQLiteDatabase db = getReadableDatabase(); //Could also be getWritableDatabase
        String query = "SELECT * FROM " + AZ_TABLE + " WHERE " + AZ_ID + "=" + 2;


        //Cursor points to a location in your results
        Cursor recordSet = db.rawQuery(query, null);
        //Move to the first row in your results
        recordSet.moveToFirst();

        //Position after the last row means the end of the results
        while (!recordSet.isAfterLast()) {
            // null could happen if we used our empty constructor
            if (recordSet.getString(recordSet.getColumnIndex("_id")) != null) {
                dbString += recordSet.getString(recordSet.getColumnIndex("FloristName"));
                dbString += "\n";
                dbString += recordSet.getString(recordSet.getColumnIndex("Location"));
                dbString += "\n";
                dbString += recordSet.getString(recordSet.getColumnIndex("Phone"));
                dbString += "\n";
                dbString += recordSet.getString(recordSet.getColumnIndex("Email"));
                dbString += "\n";
            }
            recordSet.moveToNext();
        }
        db.close();
        return dbString;
    }

    public String floristToString3(){
        String dbString = "";
        SQLiteDatabase db = getReadableDatabase(); //Could also be getWritableDatabase
        String query = "SELECT * FROM " + AZ_TABLE + " WHERE " + AZ_ID + "=" + 3;


        //Cursor points to a location in your results
        Cursor recordSet = db.rawQuery(query, null);
        //Move to the first row in your results
        recordSet.moveToFirst();

        //Position after the last row means the end of the results
        while (!recordSet.isAfterLast()) {
            // null could happen if we used our empty constructor
            if (recordSet.getString(recordSet.getColumnIndex("_id")) != null) {
                dbString += recordSet.getString(recordSet.getColumnIndex("FloristName"));
                dbString += "\n";
                dbString += recordSet.getString(recordSet.getColumnIndex("Location"));
                dbString += "\n";
                dbString += recordSet.getString(recordSet.getColumnIndex("Phone"));
                dbString += "\n";
                dbString += recordSet.getString(recordSet.getColumnIndex("Email"));
                dbString += "\n";
            }
            recordSet.moveToNext();
        }
        db.close();
        return dbString;
    }
    //Delete product from database

    /* Drop table
    public void dropTable()
    {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE);
        onCreate(db);
    }

    // Delete user from the database
    public void deleteUser(String user_email)
    {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM " + DATABASE_TABLE
                + " WHERE " + COLUMN_EMAIL + "=\"" + user_email);
    }

    //add new row
    public boolean addReview(Reviewer r){
        ContentValues values = new ContentValues();
        values.put(REVIEW_NAME, r.get_name());
        values.put(COLUMN_REVIEW, r.get_review());
        values.put(COLUMN_STARS, r.get_stars());

        SQLiteDatabase db = getWritableDatabase();
        db.insert(REVIEW_TABLE, null, values);

        db.close();
        return true;
    } */

    public static boolean checkPassword(String password1, String password2)
    {
        if(password1.equals(password2))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    // function that checks if the given email is in the user table already, and returns accordingly
    public boolean checkUserInTable(String email)
    {
        SQLiteDatabase db = getWritableDatabase();
        String query = "Select * from " + DATABASE_TABLE + " where " + COLUMN_EMAIL + " = \"" + email + "\";";
        Cursor c = db.rawQuery(query, null);

        // if no users in the table have this email
        if(c.getCount() <= 0)
        {
            c.close();
            return false;
        }
        // if there the email is already in table, return true
        c.close();
        return true;
    }
    
    //add new row
    public boolean addUser(User user){
        // pass the user inputted email to the check function
        boolean userExists = checkUserInTable(user.get_email().toString());
        if(userExists)  // account already associated with this email
        {
            return false;
        }
        else    // no account associated with this email
        {
            ContentValues values = new ContentValues();
            values.put(COLUMN_EMAIL, user.get_email());
            values.put(COLUMN_NAME, user.get_name());
            values.put(COLUMN_PHONENUM, user.get_phoneNum());
            values.put(COLUMN_ADDRESS, user.get_address());
            values.put(COLUMN_PASSWORD, user.get_password());

            SQLiteDatabase db = getWritableDatabase();
            db.insert(DATABASE_TABLE, null, values);

            db.close();
            return true;

        }
    }



    // get all rows of users from the DB and store in a cursor
    public Cursor getAllUsers()
    {
        SQLiteDatabase db = getWritableDatabase();
        Cursor c = db.query(DATABASE_TABLE, null, null, null, null, null, null);
        return c;
    }

    // method to get a specific user, can add a WHERE clause to the DB query to get specific user
    public String getUser(String email)
    {
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT " + COLUMN_EMAIL + ", " + COLUMN_NAME + ", " + COLUMN_PHONENUM + ", " + COLUMN_ADDRESS
                + ", " + COLUMN_PASSWORD +
                " FROM " + DATABASE_TABLE + "WHERE "+COLUMN_EMAIL+" LIKE "+email +";"; // get the two columns
        Cursor c = db.rawQuery(query, null);
        c.moveToLast();
        String s = String.format("%s %s\n%s\n%s", c.getString(c.getColumnIndex("first_name")),
                c.getString(c.getColumnIndex("surname")),
                c.getString(c.getColumnIndex("email")), c.getString(c.getColumnIndex("password")));
        return s;
    }

    public ArrayList<Cursor> getData(String Query){
        //get writable database
        SQLiteDatabase sqlDB = this.getWritableDatabase();
        String[] columns = new String[] { "message" };
        //an array list of cursor to save two cursors one has results from the query
        //other cursor stores error message if any errors are triggered
        ArrayList<Cursor> alc = new ArrayList<Cursor>(2);
        MatrixCursor Cursor2= new MatrixCursor(columns);
        alc.add(null);
        alc.add(null);


        try{
            String maxQuery = Query ;
            //execute the query results will be save in Cursor c
            Cursor c = sqlDB.rawQuery(maxQuery, null);


            //add value to cursor2
            Cursor2.addRow(new Object[] { "Success" });

            alc.set(1,Cursor2);
            if (null != c && c.getCount() > 0) {


                alc.set(0,c);
                c.moveToFirst();

                return alc ;
            }
            return alc;
        } catch(SQLException sqlEx){
            Log.d("printing exception", sqlEx.getMessage());
            //if any exceptions are triggered save the error message to cursor an return the arraylist
            Cursor2.addRow(new Object[] { ""+sqlEx.getMessage() });
            alc.set(1,Cursor2);
            return alc;
        } catch(Exception ex){

            Log.d("printing exception", ex.getMessage());

            //if any exceptions are triggered save the error message to cursor an return the arraylist
            Cursor2.addRow(new Object[] { ""+ex.getMessage() });
            alc.set(1,Cursor2);
            return alc;
        }


    }


//LOGIN STUFF

    public Boolean loginFieldsSupplied(String email, String password)
    {
        if(email.isEmpty())
        {
            return false;
        }
        else if(password.isEmpty())
        {
            return  false;
        }
        else    // all fields are supplied
        {
            return true;
        }
    }

    // method to get a specific user for login, can add a WHERE clause to the DB query to get specific user
    public Boolean login(String email, String supplied_password)
    {
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT " + COLUMN_EMAIL
                + ", " + COLUMN_PASSWORD +
                " FROM " + DATABASE_TABLE + " WHERE "+COLUMN_EMAIL+" LIKE '"+email +"';"; // get the two columns
        Cursor c = db.rawQuery(query, null);
        c.moveToLast();
        String stored_password =  c.getString(c.getColumnIndex("password"));
        if(supplied_password.equals(stored_password))
        {
            return true;
        }
        else
        {
            return false;
        }

    }



}

