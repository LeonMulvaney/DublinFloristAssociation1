package com.groupo.dublinfloristassociation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

/**
 * Created by Kaos117 on 05/11/2016.
 */

public class CataloguePage extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalogue);
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
