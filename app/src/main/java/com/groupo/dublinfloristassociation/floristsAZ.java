package com.groupo.dublinfloristassociation;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.groupo.dublinfloristassociation.webViews.tulipWebView;

import static android.R.attr.button;

public class floristsAZ extends AppCompatActivity {

    TextView floristDetails;
    DBhandler myDBHandler;
    String buttonClick;
    Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_florists_az);

        floristDetails = (TextView) findViewById(R.id.floristTV);

        myDBHandler = new DBhandler(this,null,null,1);
       // myDBHandler.addFlorist();
        //printDatabase();



        button = (Button)findViewById(R.id.floristBtn1);
        button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                printFlorist1();
                ImageView image = (ImageView)findViewById(R.id.floristIV);
                image.setImageResource(R.drawable.florist1image);
            }
        });

        button = (Button)findViewById(R.id.floristBtn2);
        button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                printFlorist2();
                ImageView image = (ImageView)findViewById(R.id.floristIV);
                image.setImageResource(R.drawable.florist2image);
            }
        });

        button = (Button)findViewById(R.id.floristBtn3);
        button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                printFlorist3();
                ImageView image = (ImageView)findViewById(R.id.floristIV);
                image.setImageResource(R.drawable.florist3image);
            }
        });

        }

    //Create the icons in the Action Bar - i.e. Home button for easy navigation
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.actionbarhomebtn:
                Intent intent = new Intent(this, Home.class);
                this.startActivity(intent);
        }

        return true;
    }

    public void printFlorist1(){
        floristDetails.setText("");
        String dbString = myDBHandler.floristToString1();
        floristDetails.setText(dbString);
    }

    public void printFlorist2(){
        floristDetails.setText("");
        String dbString = myDBHandler.floristToString2();
        floristDetails.setText(dbString);
    }

    public void printFlorist3(){
        floristDetails.setText("");
        String dbString = myDBHandler.floristToString3();
        floristDetails.setText(dbString);
    }






    //Check to see which button is clicked - the string will be used to select which query should be executed in DBHandler class
   /* public String button1Clicked(){
        buttonClick = "SELECT * FROM " + myDBHandler.AZ_TABLE + " WHERE " + myDBHandler.AZ_ID + "=" + 1;
        return buttonClick;

    }

    public String button2Clicked(){
        buttonClick = "SELECT * FROM " + myDBHandler.AZ_TABLE + " WHERE " + myDBHandler.AZ_ID + "=" + 2;;
        return buttonClick;
    }
*/






}
