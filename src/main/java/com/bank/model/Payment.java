package com.bank.model;

import javax.persistence.*;

@Entity @Table(name = "payment")
public class Payment {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    private String firstName;
    private String lastName;
    private float amount;
    private String status;

    public Payment(String firstName, String lastName, float amount, String status) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.amount = amount;
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public int getId() {
        return id;
    }
}
