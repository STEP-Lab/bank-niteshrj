package com.thoughtworks.bank.Account;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Account {
    private final String accountNumber;
    private final String name;
    private double balance;

    public Account(String accountNumber,String name, int balance) throws MinimumBalanceException, InvalidAccountNumberException {
        throwInsufficientBalanceException(balance);
        throwInvalidAccountNumberException(accountNumber);
        this.accountNumber = accountNumber;
        this.name = name;
        this.balance = balance;
    }
    private void throwInvalidAccountNumberException(String accountNumber) throws InvalidAccountNumberException {
        String pattern = "\\b(\\d{4}-\\d{4})\\b";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(accountNumber);
        if(!m.find()){
            throw new InvalidAccountNumberException();
        }
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
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
