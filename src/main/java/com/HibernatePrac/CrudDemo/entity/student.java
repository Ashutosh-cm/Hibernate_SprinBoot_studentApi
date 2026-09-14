package com.HibernatePrac.CrudDemo.entity;

import jakarta.persistence.*;

@Entity
@Table(name="student")
public class student extends Object {
    // define fields

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="first_name")
    private String firstname;

    @Column(name="last_name")
    private String lastname;

    @Column(name="email")
    private String email;


    // define constructor

    public student() {


    }

    public student(String firstname, String lastname, String email) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
    }


    //define getter and setter

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getFirstname() {
        return firstname;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }


    //define tostring() methods


    @Override
    public String toString() {
        return "student{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}



// TRY TO NAME THE CLASS AND THE COLUMN AND FIEILD NAME SAME SO YOU DON HAVE TO MUGG THE THINGS UP

// @GeneratedValue(strategy = GenerationType.IDENTITY)
// this tells us that the id will be auto incremented, that will be used in the table

// tostring method
//               . as we know every class by default extends that OBJECT CLASS, so tostring is one of the funtion of the
//                 of the object class .
//                let say we make a class and we make it instance (object ) of it like take student as class
//                  and we have this student s=student("ashutohs")
//                  so when we will try to do System.out.print(s).. it will give some random
//                 inside it will call the to string mehod of object class thus will give us the random values
//                 thus we override dit to give us the good values.