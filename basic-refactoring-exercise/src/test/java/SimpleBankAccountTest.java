import example.model.AccountHolder;
import example.model.BankAccount;
import example.model.SimpleBankAccount;

/**
 * The test suite for testing the SimpleBankAccount implementation
 */
class SimpleBankAccountTest extends BankAccountTest {

    @Override
    protected BankAccount createAccount(AccountHolder holder, double initialBalance) {
        return new SimpleBankAccount(holder, initialBalance);
    }
}
