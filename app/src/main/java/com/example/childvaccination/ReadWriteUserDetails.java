package com.example.childvaccination;

public class ReadWriteUserDetails {
    public String fullName,doB,gender,mobile,password;

    //constructor
    public ReadWriteUserDetails(){};

    public ReadWriteUserDetails(String textfullName,String textDoB,String textGender,String textMobile,String textPwd){
        this.fullName=textfullName;
        this.doB=textDoB;
        this.gender=textGender;
        this.mobile=textMobile;
        this.password=textPwd;
    }
}
