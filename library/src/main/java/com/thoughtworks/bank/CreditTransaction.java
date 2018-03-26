package com.thoughtworks.bank;

import java.util.Date;

class CreditTransaction extends Transaction {
    protected CreditTransaction(Date date, int amount, String another_account) {
        super(date, amount, another_account);
    }
    public CreditTransaction(int amount,String name){
        this(new Date(),amount,name);
    }
}
