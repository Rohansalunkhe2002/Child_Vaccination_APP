package com.example.childvaccination;

public class VaccinationModel {
    String Age,Vaccination,Gender;
    VaccinationModel(){

    }

    public VaccinationModel(String age, String vaccination, String gender) {
        Age = age;
        Vaccination = vaccination;
        Gender = gender;
    }

    public String getAge() {
        return Age;
    }

    public void setAge(String age) {
        Age = age;
    }

    public String getVaccination() {
        return Vaccination;
    }

    public void setVaccination(String vaccination) {
        Vaccination = vaccination;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }
}
