package com.thoughtworks.bank;

import java.util.Date;
import java.util.Objects;

public class Transaction {

    private final Date date;
    private final int amount;
    private final String another_account;

    protected Transaction(Date date, int amount, String another_account) {
        this.date = date;
        this.amount = amount;
        this.another_account = another_account;
    }

    public Date getDate() {
        return date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return amount == that.amount &&
                Objects.equals(another_account, that.another_account);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, another_account);
    }
}
