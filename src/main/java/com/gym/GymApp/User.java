package com.gym.GymApp;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 255)
    private String name;
    @Column(nullable = false, length = 255)
    private String surname;
    @Column(nullable = false, length = 255)
    private String password;
    @Column(nullable = false,unique = true, length = 255)
    private String email;
    @Column(nullable = false, length = 255)
    private String mobile_phone;
    @Column(nullable = false, length = 255)
    private String address;
    @Column(nullable = false, length = 255)
    private String city;
    @Column(nullable = false)
    private int zip;
    @Column(nullable = false, length = 255)
    private String gender;
    @Column(nullable = false, length = 255)
    private String status;
    @Column(nullable = false, length = 255)
    private String date_birth;
    @Column(nullable = false, length = 255)
    private String date_created;
    @Column(nullable = false, length = 255)
    private String loy_card;
    @Column(nullable = false)
    private int user_create;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile_phone() {
        return mobile_phone;
    }

    public void setMobile_phone(String mobile_phone) {
        this.mobile_phone = mobile_phone;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDate_birth() {
        return date_birth;
    }

    public void setDate_birth(String date_birth) {
        this.date_birth = date_birth;
    }

    public String getDate_created() {
        return date_created;
    }

    public void setDate_created(String date_created) {
        this.date_created = date_created;
    }

    public String getLoy_card() {
        return loy_card;
    }

    public void setLoy_card(String loy_card) {
        this.loy_card = loy_card;
    }

    public int getUser_create() {
        return user_create;
    }

    public void setUser_create(int user_create) {
        this.user_create = user_create;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
