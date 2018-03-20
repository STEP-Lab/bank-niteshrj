import com.thoughtworks.bank.Account.Account;
import com.thoughtworks.bank.Account.MinimumBalanceException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class AccountTest {

    private Account account;

    @Before
    public void setUp() throws Exception, MinimumBalanceException {
        account = new Account("1234", 1000);
    }

    @Test
    public void checkBalance(){
        assertThat(account.getBalance(),is(1000));
    }

    @Test
    public void checkAccountNumber() {
        assertThat(account.getAccountNumber(),is("1234"));
    }

    @Test(expected = MinimumBalanceException.class)
    public void checkMinimumBalance() throws MinimumBalanceException {
        new Account("1234",900);
    }

    @Test
    public void checkCredit() {
        assertThat(account.credit(5000),is(6000));
    }

    @Test
    public void checkDebit() {
        account.credit(5000);
        assertThat(account.debit(4000),is(2000));
    }
}
