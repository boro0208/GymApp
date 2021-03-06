package com.gym.GymApp.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

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
    @Column(nullable = false, unique = true, length = 255)
    private String email;
    @Column(nullable = false, length = 255, name = "mobile_phone")
    private String mobilePhone;
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
    @Column(nullable = false, length = 255, name = "date_birth")
    private String dateOfBirth;
    @Column(nullable = false, length = 255, name = "date_created")
    private String creationDate;
    @Column(nullable = false, length = 255, name = "loy_card")
    private String loyCard;
    @Column(nullable = false, name = "user_create")
    private int userCreated;

    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<Role> roles = new ArrayList<>();

    public User() {
    }

    public User(Long id, String name, String surname, String password, String email, String mobilePhone, String address, String city, int zip, String gender, String status, String dateOfBirth, String creationDate, String loyCard, int userCreated, Collection<Role> roles) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.email = email;
        this.mobilePhone = mobilePhone;
        this.address = address;
        this.city = city;
        this.zip = zip;
        this.gender = gender;
        this.status = status;
        this.dateOfBirth = dateOfBirth;
        this.creationDate = creationDate;
        this.loyCard = loyCard;
        this.userCreated = userCreated;
        this.roles = roles;
    }

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public String getLoyCard() {
        return loyCard;
    }

    public void setLoyCard(String loyCard) {
        this.loyCard = loyCard;
    }

    public int getUserCreated() {
        return userCreated;
    }

    public void setUserCreated(int userCreated) {
        this.userCreated = userCreated;
    }

    public Collection<Role> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }

}
