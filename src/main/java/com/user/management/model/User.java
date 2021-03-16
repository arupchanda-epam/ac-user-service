package com.user.management.model;

import org.springframework.stereotype.Component;

import javax.persistence.*;

@Table(name="userdetail")
@Entity // This tells Hibernate to make a table out of this class
public class User {


    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private  Long id;
    private  String username;

    public Long getId() {
        return id;
    }


    public String getUsername() {
        return username;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
