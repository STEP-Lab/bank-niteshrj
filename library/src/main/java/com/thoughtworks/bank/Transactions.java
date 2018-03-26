package com.thoughtworks.bank;

import java.util.ArrayList;

public class Transactions {
    protected ArrayList<Transaction> list;

    protected Transactions(){
        this.list = new ArrayList<>();
    }

    public void debit(int amount,String name){
        this.list.add(new DebitTransaction(amount,name));
    }
}
