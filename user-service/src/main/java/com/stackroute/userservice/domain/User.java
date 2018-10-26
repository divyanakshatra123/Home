package com.stackroute.userservice.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
    private String name;
    private int age;
    @Id
    private int id;

    public User()
    {

    }

    public User(String name, int age, int id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }

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



    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


}
