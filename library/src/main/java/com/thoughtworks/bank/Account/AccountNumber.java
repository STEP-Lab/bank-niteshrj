package com.thoughtworks.bank.Account;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AccountNumber {
    public AccountNumber(String number) throws InvalidAccountNumberException {
        checkAccountNumber(number);
    }
    private void checkAccountNumber(String accountNumber) throws InvalidAccountNumberException {
        String pattern = "\\b(\\d{4}-\\d{4})\\b";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(accountNumber);
        if(!m.find()){
            throw new InvalidAccountNumberException();
        }
    }
}
