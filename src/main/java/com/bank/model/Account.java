package com.bank.model;

import javax.persistence.*;

@Entity @Table(name = "account")
public class Account {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private float amount;

    public Account() {
    }

    public Account(float amount) {
        this.id = id;
        this.amount = amount;
    }

    public float getAmount() {
        return amount;
    }
}
