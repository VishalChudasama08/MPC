package com.droid08.SpringSecurtyEx.modal;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Users {
    @Id
    private int id;
    private String username;
    private String password;
}
