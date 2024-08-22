package com.example.childvaccination;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {
    private ImageView profileImg,vaccinationImg,feedbackImg,vaccinationcenterImg,jobImg,vaccinationstatusImg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);




        profileImg = findViewById(R.id.profile_logo);
        profileImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this,deleteActyivity.class);
                startActivity(intent);
            }
        });
        vaccinationImg = findViewById(R.id.vaccinationlist);
        vaccinationImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this,VaccinationActivity.class);
                startActivity(intent);
            }
        });
        feedbackImg = findViewById(R.id.feedback);
        feedbackImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this,FeedbackActivity.class);
                startActivity(intent);
            }
        });
        vaccinationcenterImg = findViewById(R.id.vaccinationcenter);
        vaccinationcenterImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this,VcentersActivity.class);
                startActivity(intent);
            }
        });
        jobImg = findViewById(R.id.Jobs);
        jobImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this,Jobs.class);
                startActivity(intent);
            }
        });
        vaccinationstatusImg = findViewById(R.id.vaccinationstatus);
        vaccinationstatusImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this,Vaccinationstatus.class);
                startActivity(intent);
            }
        });

        jobImg = findViewById(R.id.Jobs);
        jobImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this,Jobs.class);
                startActivity(intent);
            }
        });






    }
}