package com.apidemo.entities;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Slf4j
@Entity
@Table(name = "student")
public class Student {

    @Id
    @Column(name = "id")
    private int id;

    private String firstName;
    private String lastName;
    private String email;

    @Override
    public String toString() {
        log.info("First name: "+ firstName + ", Last name: " + lastName);
        return "First name: "+ firstName + ", Last name: " + lastName;
    }
}