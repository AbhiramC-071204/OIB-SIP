package com.atm.model;

import java.sql.Timestamp;

public class Transaction {

    private String type;
    private double amount;
    private Timestamp date;

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }

    public Timestamp getDate() { return date; }
    public void setDate(Timestamp date) { this.date = date; }
}