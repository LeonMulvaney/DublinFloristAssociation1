package com.groupo.dublinfloristassociation;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static com.groupo.dublinfloristassociation.R.id.emailInput;
import static com.groupo.dublinfloristassociation.R.id.queryInput;
import static com.groupo.dublinfloristassociation.R.id.sendBtn;
import static com.groupo.dublinfloristassociation.R.id.subjectInput;

/**
 * Created by Kaos117 on 05/11/2016.
 */

public class ContactPage extends AppCompatActivity {

    EditText emailInput;
    EditText subjectInput;
    EditText queryInput;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_page);

        emailInput = (EditText) findViewById(R.id.emailInput);
        subjectInput = (EditText) findViewById(R.id.subjectInput);
        queryInput = (EditText) findViewById(R.id.queryInput);

    }


    public void sendEmail(View view) {
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("message/rfc822");
        i.putExtra(Intent.EXTRA_EMAIL  , new String[]{"leonmul96@gmail.com"});
        i.putExtra(Intent.EXTRA_SUBJECT,subjectInput.getText().toString());
        i.putExtra(Intent.EXTRA_TEXT, queryInput.getText().toString());
        try {
            startActivity(Intent.createChooser(i, "Send mail..."));
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(ContactPage.this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
        }
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


}

