package com.students.demo.model;


import javax.persistence.*;
import java.util.List;

import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "students")
public class Students {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "name")
    @NotEmpty
    private String name = new String();

    @Column(name = "dob")
    @NotEmpty
    private String dob = new String();

    @Column(name = "gender")
    @NotEmpty
    private String gender = new String();

    @Column(name = "mail")
    @NotEmpty
    private String email = new String();


    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "students")
    private List<Contact> contactList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public int getId() {
        return id;
    }

    public void setId(int studentID) {
        this.id = studentID;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Contact> getContactList() {
        return contactList;
    }

    public void setContactList(List<Contact> contactList) {
        this.contactList = contactList;
    }

    public Students() {

    }
}
