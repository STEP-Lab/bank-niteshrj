import com.thoughtworks.bank.Account.Account;
import com.thoughtworks.bank.Account.AccountNumber;
import com.thoughtworks.bank.Account.InvalidAccountNumberException;
import com.thoughtworks.bank.Account.MinimumBalanceException;
import org.junit.Test;

public class AccountNumberTest {
    @Test(expected = InvalidAccountNumberException.class)
    public void checkForInvalidAccountNumberWithLessThan8Characters() throws MinimumBalanceException, InvalidAccountNumberException {
        new AccountNumber("123-12");
    }

    @Test(expected = InvalidAccountNumberException.class)
    public void checkForInvalidAccountNumberWithoutHyphen() throws MinimumBalanceException, InvalidAccountNumberException {
        new AccountNumber("12345678");
    }

    @Test(expected = InvalidAccountNumberException.class)
    public void checkForInvalidAccountNumberWithAlphabets() throws MinimumBalanceException, InvalidAccountNumberException {
        new AccountNumber("1234-a678");
    }

    @Test(expected = InvalidAccountNumberException.class)
    public void checkForInvalidAccountNumberWithSpecialCharacters() throws MinimumBalanceException, InvalidAccountNumberException {
        new AccountNumber("12*4-&678");
    }
}
