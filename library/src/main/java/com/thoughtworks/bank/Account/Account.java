package com.thoughtworks.bank.Account;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Account {
    private final String accountNumber;
    private int balance;

    public Account(String accountNumber, int balance) throws MinimumBalanceException, InvalidAccountNumberException {
        throwInsufficientBalanceException(balance);
        throwInvalidAccountNumberException(accountNumber);
        this.accountNumber = accountNumber;
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

    public int debit(int amount) throws MinimumBalanceException {
        throwInsufficientBalanceException(this.balance-amount);
        this.balance -= amount;
        return this.balance;
    }
    public void throwInsufficientBalanceException(int balance) throws MinimumBalanceException {
        if(balance<1000) {
            throw new MinimumBalanceException();
        }
    }
}
