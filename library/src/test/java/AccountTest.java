import com.thoughtworks.bank.Account.Account;
import com.thoughtworks.bank.Account.InvalidAccountNumberException;
import com.thoughtworks.bank.Account.MinimumBalanceException;
import com.thoughtworks.bank.Account.Summary;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class AccountTest {

    private Account account;

    @Before
    public void setUp() throws Exception, MinimumBalanceException, InvalidAccountNumberException {
        account = new Account("1234-5678","Nitesh Ranjan", 1000);
    }

    @Test
    public void checkBalance(){
        assertThat(account.getBalance(),is(1000.0));
    }

    @Test
    public void checkAccountNumber() {
        assertThat(account.getAccountNumber(),is("1234-5678"));
    }

    @Test(expected = MinimumBalanceException.class)
    public void checkMinimumBalance() throws MinimumBalanceException, InvalidAccountNumberException {
        new Account("1234","Nitesh Ranjan",900);
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

    @Test(expected = InvalidAccountNumberException.class)
    public void checkForInvalidAccountNumberWithLessThan8Characters() throws MinimumBalanceException, InvalidAccountNumberException {
        new Account("123-12","Nitesh Ranjan",1000);
    }

    @Test(expected = InvalidAccountNumberException.class)
    public void checkForInvalidAccountNumberWithoutHyphen() throws MinimumBalanceException, InvalidAccountNumberException {
        new Account("12345678","Nitesh Ranjan",1000);
    }

    @Test(expected = InvalidAccountNumberException.class)
    public void checkForInvalidAccountNumberWithAlphabets() throws MinimumBalanceException, InvalidAccountNumberException {
        new Account("1234-a678","Nitesh Ranjan",1000);
    }

    @Test(expected = InvalidAccountNumberException.class)
    public void checkForInvalidAccountNumberWithSpecialCharacters() throws MinimumBalanceException, InvalidAccountNumberException {
        new Account("12*4-&678","Nitesh Ranjan",1000);
    }

    @Test
    public void getSummary() {
        assertThat(account.getSummary(),is(Summary.class));
    }
}
