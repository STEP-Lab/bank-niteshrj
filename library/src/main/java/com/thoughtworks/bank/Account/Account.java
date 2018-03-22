package com.thoughtworks.bank.Account;

public class Account {
    private final AccountNumber accountNumber;
    private final String name;
    private double balance;

    public Account(AccountNumber accountNumber, String name, int balance) throws MinimumBalanceException, InvalidAccountNumberException {
        throwInsufficientBalanceException(balance);
        this.accountNumber = accountNumber;
        this.name = name;
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public double credit(int amount) {
        this.balance += amount;
        return this.balance;
    }

    public double debit(int amount) throws MinimumBalanceException {
        throwInsufficientBalanceException(this.balance-amount);
        this.balance -= amount;
        return this.balance;
    }
    public void throwInsufficientBalanceException(double balance) throws MinimumBalanceException {
        if(balance<1000) {
            throw new MinimumBalanceException();
        }
    }

    public Summary getSummary() {
        return new Summary(name, accountNumber, balance);
    }
}
