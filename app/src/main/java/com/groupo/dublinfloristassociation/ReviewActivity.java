package com.groupo.dublinfloristassociation;

import android.app.Activity;
import android.content.Intent;
import android.media.Rating;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

/**
 * Created by Kaos117 on 07/11/2016.
 */

public class ReviewActivity extends Activity implements RatingBar.OnRatingBarChangeListener {

    EditText nameInput;
    EditText reviewInput;
    RatingBar starsInput;
    DBhandler db;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review_page);

        nameInput = (EditText) findViewById(R.id.nameInput);
        reviewInput = (EditText) findViewById(R.id.reviewInput);

        starsInput = (RatingBar) findViewById(R.id.starsInput);
        starsInput.setOnRatingBarChangeListener(this);

        final Button sendBtn = (Button) findViewById(R.id.sendBtn);

        db = new DBhandler(this, null, null, 1);



        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Reviewer r = new Reviewer(
                        nameInput.getText().toString(),
                        reviewInput.getText().toString(),
                        starsInput.getNumStars());

                boolean success = true;
                if (success) {
                    try {
                        if (nameInput.getText().toString().length() == 0) {
                            nameInput.setError("Name required");
                            nameInput.requestFocus();
                        }
                        if (reviewInput.getText().toString().length() == 0) {
                            reviewInput.setError("Please add a review");
                            reviewInput.requestFocus();
                        }
                        if (starsInput.getNumStars() == 0) {
                            Toast.makeText(getApplicationContext(), "Why not give us 5 stars?", Toast.LENGTH_SHORT).show();
                        }
                        r.addReview();
                        Toast.makeText(getApplicationContext(), "Thanks for helping to make the app better!!!!", Toast.LENGTH_LONG).show();

                        Intent myIntent = new Intent(getApplicationContext(), Home.class);
                        startActivity(myIntent);

                    } catch (Exception e) {
                        Toast.makeText(getApplicationContext(), "Error sending question, please try again.", Toast.LENGTH_LONG).show();
                    }
                }

            }
        });}

    @Override
    public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {

    }
}

