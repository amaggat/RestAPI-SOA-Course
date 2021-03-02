package com.students.demo.model;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "contacts")
public class Contact {

    @Id
    @GeneratedValue
    private int id;

    @Column(name = "name")
    @NotEmpty
    private String name = new String();

    @Column(name = "address")
    @NotEmpty
    private String address = new String();


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "studentid")
    private Students students;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
