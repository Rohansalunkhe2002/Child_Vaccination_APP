package com.example.childvaccination;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class FeedbackActivity extends AppCompatActivity {
    EditText email,feedback;
    Button submit;
    FirebaseDatabase db = FirebaseDatabase.getInstance();
    DatabaseReference reference = db.getReference().child("Feedback");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        email = findViewById(R.id.editText_feedback_email);
        feedback = findViewById(R.id.editText_feedback_msg);
        submit = findViewById(R.id.feedback_button);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Email =email.getText().toString();
                String Feedback =feedback.getText().toString();

                //hashMap
                HashMap<String,String> usermap = new HashMap<>();
                usermap.put("Email",Email);
                usermap.put("Feedback",Feedback);

                reference.push().setValue(usermap);
                Toast.makeText(FeedbackActivity.this,"feedback save",Toast.LENGTH_SHORT).show();
                finish();

            }
        });


    }
}