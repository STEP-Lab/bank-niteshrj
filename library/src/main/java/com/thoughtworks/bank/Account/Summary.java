package com.thoughtworks.bank.Account;

public class Summary {
    private final String name;
    private final AccountNumber accountNumber;
    private final double balance;

    Summary(String name, AccountNumber accountNumber, double balance) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public AccountNumber getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }
}
