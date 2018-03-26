package com.thoughtworks.bank;

import java.util.Date;

class DebitTransaction extends Transaction {
    protected DebitTransaction(Date date, int amount, String another_account) {
        super(date, amount, another_account);
    }
    public DebitTransaction(int amount,String name){
        this(new Date(),amount,name);
    }
}
