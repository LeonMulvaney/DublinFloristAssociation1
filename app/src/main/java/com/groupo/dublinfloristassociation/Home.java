package com.groupo.dublinfloristassociation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
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

    public void viewCatalogue(View view){
        Intent intent = new Intent(this,CataloguePage.class);
        startActivity(intent);
    }


    public void viewFloristsAZ (View view){
        Intent intent = new Intent(this,floristsAZ.class);
        startActivity(intent);
    }


    public void viewFlowerArchive(View view){
        Intent intent = new Intent(this,flowerarchive.class);
        startActivity(intent);
    }


    public void viewContact(View view){
        Intent intent = new Intent(this,ContactPage.class);
        startActivity(intent);
    }



    public void logout (View view){
        Intent intent = new Intent(this,LoginPage.class);
        startActivity(intent);
        Toast toast;
        toast = Toast.makeText(getApplicationContext(), "Thanks for dropping by!", Toast.LENGTH_LONG);
        toast.show();
        finish();
    }
}
