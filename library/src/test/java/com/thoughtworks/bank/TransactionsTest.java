package com.thoughtworks.bank;

import org.junit.Test;

import java.util.Date;

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
}
