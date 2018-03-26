package com.thoughtworks.bank;

import com.thoughtworks.bank.Account.AccountNumber;
import com.thoughtworks.bank.Account.InvalidAccountNumberException;
import org.junit.Test;

public class AccountNumberTest {
    @Test(expected = InvalidAccountNumberException.class)
    public void checkForInvalidAccountNumberWithLessThan8Characters() throws InvalidAccountNumberException {
        new AccountNumber("123-12");
    }

    @Test(expected = InvalidAccountNumberException.class)
    public void checkForInvalidAccountNumberWithoutHyphen() throws InvalidAccountNumberException {
        new AccountNumber("12345678");
    }

    @Test(expected = InvalidAccountNumberException.class)
    public void checkForInvalidAccountNumberWithAlphabets() throws InvalidAccountNumberException {
        new AccountNumber("1234-a678");
    }

    @Test(expected = InvalidAccountNumberException.class)
    public void checkForInvalidAccountNumberWithSpecialCharacters() throws InvalidAccountNumberException {
        new AccountNumber("12*4-&678");
    }
}
