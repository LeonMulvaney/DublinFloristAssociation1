package com.groupo.dublinfloristassociation;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class RegisterPage extends AppCompatActivity {

    EditText emailInput;
    EditText nameInput;
    EditText phoneInput;
    EditText addressInput;
    EditText passwordInput;
    EditText passwordConfirm;
    TextView userInfo;
    DBhandler dbHandler;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_page);

        emailInput = (EditText) findViewById(R.id.emailInput);
        nameInput = (EditText) findViewById(R.id.nameInput);
        phoneInput = (EditText) findViewById(R.id.phoneInput);
        addressInput = (EditText) findViewById(R.id.addressInput);
        passwordInput = (EditText) findViewById(R.id.passwordInput);
        passwordConfirm = (EditText) findViewById(R.id.passwordConfirm);


        final Button RegisterBtn = (Button) findViewById(R.id.RegisterBtn);

        // create the object to connect to the db
        dbHandler = new DBhandler(this, null, null, 1);





        // when user clicks the 'Create account' button in the Register page
        RegisterBtn.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                // create a new User object, getting the parameters from the textView inputs by user
                // and changing them to string as needed.
                User user = new User(
                        emailInput.getText().toString(),
                        nameInput.getText().toString(),
                        phoneInput.getText().toString(),
                        addressInput.getText().toString(),
                        passwordInput.getText().toString());

                try
                {
                    // check if the passwords supplied match
                    boolean passwordMatch = dbHandler.checkPassword(
                            passwordInput.getText().toString(),
                            passwordConfirm.getText().toString());

                    // check if email in table already
                    boolean emailUsed = dbHandler.checkUserInTable(emailInput.getText().toString());

                    // if the email is already registered
                    if(emailUsed)
                    {
                        Toast.makeText(getApplicationContext(), "Email address already used, please login or try again.", Toast.LENGTH_LONG).show();
                    }
                    else    // email not registered already, now check the passwords
                    {
                        if(passwordMatch)   // if passwords match
                        {
                            // add the user to the user database
                            boolean success = dbHandler.addUser(user);
                            if(success)
                            {
                                Toast.makeText(getApplicationContext(), "Successfully registered!", Toast.LENGTH_LONG).show();

                                Intent myIntent = new Intent(getApplicationContext(), LoginPage.class);
                                // pass the name of the logged in user to the home page
                                myIntent.putExtra("user", emailInput.getText().toString());
                                startActivity(myIntent);

                                // we get all the user rows and store in a cursor
                                Cursor c = dbHandler.getAllUsers();
                                c.moveToFirst();    // move cursor to the first row

                                // arrayList to store the rows of users
                                ArrayList<String> users = new ArrayList<>();
                                int rows = c.getCount();    // how many rows of users there are in cursor

                                // iterate over each row and add the firstname, surname, email and password
                                // to the arraylist
                                for(int i = 0; i<rows; i++)
                                {
                                    users.add(c.getString(1)+" "+c.getString(2)+"\n"+c.getString(3)+"\n"+c.getString(4)+"\n\n");
                                    c.moveToNext();     // move to next row
                                }
                            }
                        }
                        else    // passwords don't match
                        {
                            Toast.makeText(getApplicationContext(), "Passwords do not match, try again.", Toast.LENGTH_LONG).show();
                        }
                    }
                }
                catch (Exception e)
                {
                    Toast.makeText(getApplicationContext(), "Please fill all fields to proceed.", Toast.LENGTH_LONG).show();
                }



                try{
                    if(emailInput.getText().toString().length()==0){
                        emailInput.setError("Please enter valid email address");
                        emailInput.requestFocus();
                    }
                    if(phoneInput.getText().toString().length()<10){
                        phoneInput.setError("Please enter valid phone number");
                        phoneInput.requestFocus();
                    }
                    if(nameInput.getText().toString().length()==0){
                        nameInput.setError("Username is Required");
                        nameInput.requestFocus();
                    }
                    if(addressInput.getText().toString().length()==0){
                        addressInput.setError("Please enter your address");
                        addressInput.requestFocus();
                    }
                    if(passwordInput.getText().toString().length()==0){
                        passwordInput.setError("Please enter a password, at least 8 characters long and haave a number");
                        passwordInput.requestFocus();
                    }
                    if(passwordConfirm.getText().toString().length()==0){
                        passwordConfirm.setError("Please confirm password");
                        passwordConfirm.requestFocus();
                    }
                    if(!passwordInput.getText().toString().equals(passwordConfirm.getText().toString())){
                        passwordConfirm.setError("Password Not matched");
                        passwordConfirm.requestFocus();
                    }

                }
                catch (Exception e)
                {
                    Toast.makeText(getApplicationContext(), "Error creating an account, please try again.", Toast.LENGTH_LONG).show();
                }


            }
        });
    }

    public void ViewDb(View view){
        Intent ViewDb = new Intent(this, AndroidDatabaseManagerDELETEWHENCOMPLETE.class);
        startActivity(ViewDb);
    }


}


