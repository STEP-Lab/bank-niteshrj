package com.thoughtworks.bank.Account;

public class Summary {
    private final String name;
    private final String accountNumber;
    private final double balance;

    Summary(String name, String accountNumber, double balance) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }
}
