package com.bank;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
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
