package com.thoughtworks.bank.Account;

public class Account {
    private final String accountNumber;
    private int balance;

    public Account(String accountNumber, int balance) throws MinimumBalanceException {
        this.accountNumber = accountNumber;
        if(balance<1000) {
           throw new MinimumBalanceException();
        }
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public int credit(int amount) {
        this.balance += amount;
        return this.balance;
    }

    public int debit(int amount) {
        this.balance -= amount;
        return this.balance;
    }
}
