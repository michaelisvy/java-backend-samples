package com.bank.model;

import org.springframework.data.annotation.Id;

public class Invoice {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private double amount;


    public Invoice(String firstName, String lastName, double amount) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }
}
