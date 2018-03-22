import com.thoughtworks.bank.Account.*;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class AccountTest {

    private Account account;

    @Before
    public void setUp() throws Exception, MinimumBalanceException, InvalidAccountNumberException {
        account = new Account(new AccountNumber("1234-5678"),"Nitesh Ranjan", 1000);
    }

    @Test
    public void checkBalance(){
        assertThat(account.getBalance(),is(1000.0));
    }

    @Test(expected = MinimumBalanceException.class)
    public void checkMinimumBalance() throws MinimumBalanceException, InvalidAccountNumberException {
        new Account(new AccountNumber("1234-3456"),"Nitesh Ranjan",900);
    }

    @Test
    public void checkCredit() {
        assertThat(account.credit(5000),is(6000.0));
    }

    @Test
    public void checkDebit() throws MinimumBalanceException {
        account.credit(5000);
        assertThat(account.debit(4000),is(2000.0));
    }

    @Test(expected = MinimumBalanceException.class)
    public void checkDebitForInsufficientBalance() throws MinimumBalanceException {
        account.debit(500);
    }

    @Test
    public void getSummary() {
        assertThat(account.getSummary(),is(Summary.class));
    }
}
