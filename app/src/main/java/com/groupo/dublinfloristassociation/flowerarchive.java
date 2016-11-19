package com.groupo.dublinfloristassociation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.groupo.dublinfloristassociation.webViews.daffodilWebView;
import com.groupo.dublinfloristassociation.webViews.roseWebView;
import com.groupo.dublinfloristassociation.webViews.tulipWebView;
import com.groupo.dublinfloristassociation.webViews.bluebellWebView;

public class flowerarchive extends AppCompatActivity {



    private Button buttonTulip;
    private Button buttonDaffodil;
    private Button buttonRose;
    private Button buttonBluebell;



    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flowerarchive);

        buttonTulip = (Button)findViewById(R.id.tulipBtn);
        buttonRose = (Button) findViewById(R.id.roseBtn);
        buttonDaffodil = (Button) findViewById(R.id.daffodilBtn);
        buttonBluebell = (Button) findViewById(R.id.bluebellBtn);

        buttonTulip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent tulipIntent = new Intent(flowerarchive.this,tulipWebView.class);
                startActivity(tulipIntent);
            }
        });

        buttonRose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(flowerarchive.this,roseWebView.class);
                startActivity(intent);
            }
        });

        buttonDaffodil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(flowerarchive.this,daffodilWebView.class);
                startActivity(intent);
            }
        });

        buttonBluebell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent bluebellIntent = new Intent(flowerarchive.this,bluebellWebView.class);
                startActivity(bluebellIntent);
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



}
