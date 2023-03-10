package com.example.tiny_airlines.models;

public class Passenger {

    private String id;
    private String passport_num;
    private String phone_num;
    private String name;
    private String age;
    private String gender;
    private String date_of_birth;
    private String country;
    private String flight_id;
    public Passenger() {
    }

    public Passenger(String id, String passport_num, String phone_num, String name, String age, String gender, String date_of_birth, String country, String flight_id) {
        this.id = id;
        this.passport_num = passport_num;
        this.phone_num = phone_num;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.date_of_birth = date_of_birth;
        this.country = country;
        this.flight_id = flight_id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassport_num() {
        return passport_num;
    }

    public void setPassport_num(String passport_num) {
        this.passport_num = passport_num;
    }

    public String getPhone_num() {
        return phone_num;
    }

    public void setPhone_num(String phone_num) {
        this.phone_num = phone_num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(String date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getFlight_id() {
        return flight_id;
    }

    public void setFlight_id(String flight_id) {
        this.flight_id = flight_id;
    }
}
