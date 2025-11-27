package com.fitness.userservice.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table
public class User {

    private UserRole role = UserRole.USER;


}
