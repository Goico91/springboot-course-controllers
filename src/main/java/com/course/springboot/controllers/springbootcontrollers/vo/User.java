package com.course.springboot.controllers.springbootcontrollers.vo;

import java.io.Serializable;

public class User implements Serializable {
    private int idUser;

    private String name;

    private String surname;

    public User() {
    }

    public User(int idUser, String name, String surname) {
        this.idUser = idUser;
        this.name = name;
        this.surname = surname;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
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

}
