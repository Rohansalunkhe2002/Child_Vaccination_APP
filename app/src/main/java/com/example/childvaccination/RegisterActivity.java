package com.example.childvaccination;

import android.app.DatePickerDialog;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegisterActivity extends AppCompatActivity {
    private EditText editTextRegisterFullName,editTextRegisterEmail,editTextRegisterDob,editTextRegisterMobile,
            editTextRegisterPwd,editTextRegisterConfirmPwd;
    private ProgressBar progressBar;
    private RadioGroup radioGroupRegisterGender;
    private RadioButton radioButtonRegisterGenderSelected;
    private DatePickerDialog picker;
    private static  final String TAG="RegisterActivity";
    private  static final String CHANNEL_ID="Registration channel";
    private  static final int NOTIFICATION_ID= 100;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        getSupportActionBar().setTitle("Register");

        Toast.makeText(RegisterActivity.this,"You can register now",Toast.LENGTH_LONG).show();
        progressBar = findViewById(R.id.progressBar);

        editTextRegisterFullName = findViewById(R.id.editText_register_full_name);
        editTextRegisterEmail = findViewById(R.id.editText_register_email);
        editTextRegisterDob = findViewById(R.id.editText_register_dob);
        editTextRegisterMobile = findViewById(R.id.editText_register_mobile);
        editTextRegisterPwd=findViewById(R.id.editText_register_password);
        editTextRegisterConfirmPwd=findViewById(R.id.editText_register_confirm_password);

        //RedioButton For Gender
        radioGroupRegisterGender = findViewById(R.id.radio_group_register_gender);
        radioGroupRegisterGender.clearCheck();

        //Setting up to DatePicker on Edittext
        editTextRegisterDob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar calendar = Calendar.getInstance();
                int day = calendar.get(Calendar.DAY_OF_MONTH);
                int month = calendar.get(Calendar.MONTH);
                int year = calendar.get(Calendar.YEAR);

                //Date Picker Dailog
                picker = new DatePickerDialog(RegisterActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayofMonth) {
                        editTextRegisterDob.setText(dayofMonth+"/"+(month +1)+"/"+year);
                    }
                },year,month,day);
                picker.show();
            }
        });

        Button buttonRegister = findViewById(R.id.button_register1);
        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int selectedGenderId = radioGroupRegisterGender.getCheckedRadioButtonId();
                radioButtonRegisterGenderSelected = findViewById(selectedGenderId);

                //obtain the entered data
                String textFullName =  editTextRegisterFullName.getText().toString();
                String textEmail = editTextRegisterEmail.getText().toString();
                String textDoB = editTextRegisterDob.getText().toString();
                String textMobile = editTextRegisterMobile.getText().toString();
                String textPwd = editTextRegisterPwd.getText().toString();
                String textConfirmPwd = editTextRegisterConfirmPwd.getText().toString();
                String textGender; //can't obtain the value before verifying if any button was selected or not.

                //validate the mobile number using match and pattern (Regular Expression)
                String mobileRegex = "[6-9][0-9]{9}";
                Matcher mobileMatcher;
                Pattern mobilePattern = Pattern.compile(mobileRegex);
                mobileMatcher=mobilePattern.matcher(textMobile);


                 if (TextUtils.isEmpty(textFullName)){
                     Toast.makeText(RegisterActivity.this, "please enter your full name", Toast.LENGTH_SHORT).show();
                     editTextRegisterFullName.setError("full name is required");
                     editTextRegisterFullName.requestFocus();
                 } else if (TextUtils.isEmpty(textEmail)){
                     Toast.makeText(RegisterActivity.this, "please enter your Email", Toast.LENGTH_SHORT).show();
                     editTextRegisterEmail.setError("Email is required");
                     editTextRegisterEmail.requestFocus();
                 } else if (!Patterns.EMAIL_ADDRESS.matcher(textEmail).matches()){
                     Toast.makeText(RegisterActivity.this, "please enter your email",Toast.LENGTH_LONG).show();
                     editTextRegisterEmail.setError(" valid Email is required");
                     editTextRegisterEmail.requestFocus();
                 }else if (TextUtils.isEmpty(textDoB)){
                     Toast.makeText(RegisterActivity.this, "please your date of birth", Toast.LENGTH_SHORT).show();
                     editTextRegisterDob.setError("date of Birth is Required");
                     editTextRegisterDob.requestFocus();
                 }else if(radioGroupRegisterGender.getCheckedRadioButtonId()== -1){
                     Toast.makeText(RegisterActivity.this,"please enter your email",Toast.LENGTH_LONG).show();
                     radioButtonRegisterGenderSelected.setError("Gendre is required");
                     radioButtonRegisterGenderSelected.requestFocus();
                 } else if (TextUtils.isEmpty(textMobile)) {
                     Toast.makeText(RegisterActivity.this, "please enter your mobile no.", Toast.LENGTH_LONG).show();
                     editTextRegisterMobile.setError("mobile no is required");
                     editTextRegisterMobile.requestFocus();
                 } else if (textMobile.length()!=10){
                     Toast.makeText(RegisterActivity.this,"please enter your mobile no ",Toast.LENGTH_LONG).show();
                     editTextRegisterMobile.setError("mobile No. should be 10 digits");
                     editTextRegisterMobile.requestFocus();
                 }else if (!mobileMatcher.find()){
                     Toast.makeText(RegisterActivity.this,"please enter your mobile no ",Toast.LENGTH_LONG).show();
                     editTextRegisterMobile.setError("mobile No. is not valid");
                     editTextRegisterMobile.requestFocus();

                 } else  if (TextUtils.isEmpty(textPwd)){
                     Toast.makeText(RegisterActivity.this, "Please enter your password", Toast.LENGTH_SHORT).show();
                     editTextRegisterPwd.setError("password is required");
                     editTextRegisterPwd.requestFocus();
                 } else if (textPwd.length()<6){
                     Toast.makeText(RegisterActivity.this,"Password should be at least 6 didgit",Toast.LENGTH_LONG).show();
                     editTextRegisterPwd.setError("Password is too week");
                     editTextRegisterPwd.requestFocus();
                 }else if(TextUtils.isEmpty(textConfirmPwd)){
                     Toast.makeText(RegisterActivity.this, "Please conform your Password", Toast.LENGTH_SHORT).show();
                     editTextRegisterConfirmPwd.setError("Password Confirmationb is required");
                     editTextRegisterConfirmPwd.requestFocus();
                 }else if (!textPwd.equals(textConfirmPwd)){
                    Toast.makeText(RegisterActivity.this,"please Eneter same password",Toast.LENGTH_LONG).show();
                    editTextRegisterConfirmPwd.setError("Passsword Confirmation is required");
                    editTextRegisterConfirmPwd.requestFocus();
                    //Clear the Enetred password
                     editTextRegisterConfirmPwd.clearComposingText();
                     editTextRegisterConfirmPwd.clearComposingText();
                }else {
                     textGender =radioButtonRegisterGenderSelected.getText().toString();
                     progressBar.setVisibility(View.VISIBLE);
                     registerUser(textFullName, textEmail, textDoB, textGender, textMobile, textPwd);
                 }



            }
        });


    }
    //Register User using the credential given

    private void registerUser(String textFullName, String textEmail, String textDoB, String textGender, String textMobile, String textPwd) {
        FirebaseAuth auth = FirebaseAuth.getInstance();

        //Create User Profile
        auth.createUserWithEmailAndPassword(textEmail,textPwd)
                .addOnCompleteListener(RegisterActivity.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                Notification notification;

                if (task.isSuccessful()){
                    Drawable drawable = ResourcesCompat.getDrawable(getResources(),R.drawable.registraion_icon,null);
                    BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
                    Bitmap largeIcon = bitmapDrawable.getBitmap();

                            NotificationManager rnm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                        notification = new Notification.Builder(RegisterActivity.this)
                                .setLargeIcon(largeIcon)
                                .setSmallIcon(R.drawable.app_icon)
                                .setContentText("Thanks! for registration,now you got Vaccination Information about Your Child ")
                                .setSubText("Registration successful")
                                .setChannelId(CHANNEL_ID)
                                .build();
                        rnm.createNotificationChannel(new NotificationChannel(CHANNEL_ID,"registration channel",NotificationManager.IMPORTANCE_HIGH));
                    }else {
                        notification = new Notification.Builder(RegisterActivity.this)
                                .setLargeIcon(largeIcon)
                                .setSmallIcon(R.drawable.app_icon)
                                .setContentText("Child Vaccination")
                                .setSubText("Thanks! for registration,now you got Vaccination Information about Your Child ")
                                .build();

                    }
                    rnm.notify(NOTIFICATION_ID,notification);

                    FirebaseUser firebaseUser = auth.getCurrentUser();

                    //Update Display Name of user
                    UserProfileChangeRequest profileChangeRequest = new UserProfileChangeRequest.Builder().setDisplayName(textFullName).build();
                    firebaseUser.updateProfile(profileChangeRequest);

                    //Enter User data into Firebase Realtime Database.
                    ReadWriteUserDetails writeUserDetails = new ReadWriteUserDetails(textFullName, textDoB, textGender,textMobile,textPwd);

                    //Extracting User reference from Database
                    DatabaseReference referenceProfile = FirebaseDatabase.getInstance().getReference("Register Users");

                    referenceProfile.child(firebaseUser.getUid()).setValue(writeUserDetails).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {

                            if (task.isSuccessful()){

                                //send verification Email
                                firebaseUser.sendEmailVerification();

                                Toast.makeText(RegisterActivity.this,"User registerd succesfully.please verify your email",
                                        Toast.LENGTH_LONG).show();

                                //Open User Profile after successful registration
                                Intent intent = new Intent(RegisterActivity.this, HomeActivity.class);
                                //to Prevent User from returning back to Register Activity on pressing back button after register
                                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP| Intent.FLAG_ACTIVITY_CLEAR_TASK
                                                | Intent.FLAG_ACTIVITY_NEW_TASK);
                                startActivity(intent);
                                finish();   //to close Register Activity

                            }else{
                                Toast.makeText(RegisterActivity.this,"User registered Failed.please try again",
                                        Toast.LENGTH_LONG).show();
                            }
                            //Hide ProgressBar while User is successful or Failed
                            progressBar.setVisibility(View.GONE);

                        }   
                    });
                }else{
                    try {
                        throw task.getException();
                    }catch (FirebaseAuthWeakPasswordException e){
                        editTextRegisterPwd.setError("Password must 6 Character");
                        editTextRegisterPwd.requestFocus();
                    }catch (FirebaseAuthInvalidCredentialsException e){
                        editTextRegisterPwd.setError("Your Email is invalid or already in use.kindly re-enter.");
                        editTextRegisterPwd.requestFocus();
                    }catch (FirebaseAuthUserCollisionException e){
                        editTextRegisterPwd.setError("User is already register with this email.Use another email.");
                        editTextRegisterPwd.requestFocus();
                    }catch (Exception e){
                        Log.e(TAG,e.getMessage());
                        Toast.makeText(RegisterActivity.this,e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                    //Hide ProgressBar while User is successful or Failed
                    progressBar.setVisibility(View.GONE);
                }
            }
        });
    }
}