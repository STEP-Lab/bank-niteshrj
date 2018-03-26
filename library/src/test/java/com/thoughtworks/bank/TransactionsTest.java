package com.thoughtworks.bank;

import org.junit.Test;

import static org.hamcrest.core.IsCollectionContaining.hasItem;
import static org.junit.Assert.assertThat;

public class TransactionsTest {
    @Test
    public void mustRecordDebitTransaction() {
        Transactions transactions = new Transactions();
        transactions.debit(1000,"Nitesh");
        for (int i = 0; i < transactions.list.size(); i++) {
            System.out.println(transactions.list.get(i));
        }
        System.out.println(transactions.list);
        assertThat(transactions.list,hasItem(new DebitTransaction(1000,"Nitesh")));
    }

    @Test
    public void mustRecordCreditTransaction() {
        Transactions transactions = new Transactions();
        transactions.credit(1000,"Nitesh");
        for (int i = 0; i < transactions.list.size(); i++) {
            System.out.println(transactions.list.get(i));
        }
        System.out.println(transactions.list);
        assertThat(transactions.list,hasItem(new CreditTransaction(1000,"Nitesh")));
    }
}
