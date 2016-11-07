package com.groupo.dublinfloristassociation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class flowerarchive extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flowerarchive);
    }

    public void viewTulip(View view){
        Intent intent = new Intent(this,tulip.class);
        startActivity(intent);
    }

    public void viewDaffodil(View view){
        Intent intent = new Intent(this,daffodil.class);
        startActivity(intent);
    }


}
