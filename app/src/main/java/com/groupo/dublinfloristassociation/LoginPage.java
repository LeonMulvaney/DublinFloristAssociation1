package com.groupo.dublinfloristassociation;

import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginPage extends AppCompatActivity {

    EditText emailInput;
    EditText passwordInput;
    DBhandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        emailInput = (EditText) findViewById(R.id.emailInput);
        passwordInput = (EditText) findViewById(R.id.passwordInput);
        final Button btnLogin = (Button) findViewById(R.id.btnLogin);

        // create the object to connect to the db
        dbHandler = new DBhandler(this, null, null, 1);
        dbHandler.addFlorist();

        btnLogin.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                try
                {
                    // check if all fields were supplied
                    boolean loginFieldsSupplied = dbHandler.loginFieldsSupplied(emailInput.getText().toString(), passwordInput.getText().toString());

                    // check if email in table already
                    boolean emailUsed = dbHandler.checkUserInTable(emailInput.getText().toString());

                    if(loginFieldsSupplied)
                    {
                        // if their is no account associated with this email
                        if(!emailUsed)
                        {
                            Toast.makeText(getApplicationContext(), "No account associated with this " +
                                    "email, please create an account and try again.", Toast.LENGTH_LONG).show();
                        }
                        else    // email exists in the database, no compare the password given to stored password
                        {
                            // login and direct to home screen
                            boolean success = dbHandler.login(emailInput.getText().toString(), passwordInput.getText().toString());
                            if(success)
                            {
                                Toast.makeText(getApplicationContext(), "You are now logged in.", Toast.LENGTH_LONG).show();
                                // change screen to the Home page
                                Intent myIntent = new Intent(getApplicationContext(), Home.class);
                                // pass the name of the logged in user to the home page
                                myIntent.putExtra("user", emailInput.getText().toString());
                                startActivity(myIntent);
                            }
                            else    // password doesn't match
                            {
                                Toast.makeText(getApplicationContext(), "Incorrect password, try again.", Toast.LENGTH_LONG).show();
                            }
                        }
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(), "Please fill in all fields and try again.", Toast.LENGTH_LONG).show();
                    }
                }
                catch (Exception e)
                {
                    Toast.makeText(getApplicationContext(), "Error logging in, please try again.", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void viewHome(View view) {
        Intent viewHome = new Intent(this,Home.class);
        startActivity(viewHome);
        finish();
    }


    public void viewRegisterUser(View view){
        Intent viewRegisterUser = new Intent(this,RegisterPage.class);
        startActivity(viewRegisterUser);
    }



}
