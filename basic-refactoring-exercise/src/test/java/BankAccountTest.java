import example.model.AccountHolder;
import example.model.BankAccount;
import example.model.SimpleBankAccount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public abstract class BankAccountTest {

    protected AccountHolder accountHolder;
    protected BankAccount bankAccount;
    private static final double INITIAL_BALANCE = 0;
    private static final double DEPOSIT_AMOUNT = 100;
    private static final double WITHDRAW_AMOUNT = 70;
    private static final int ACCOUNT_ID = 1;
    private static final int WRONG_ACCOUNT_ID = 2;

    @BeforeEach
    void beforeEach() {
        accountHolder = new AccountHolder("Mario", "Rossi", ACCOUNT_ID);
        bankAccount = createAccount(accountHolder, INITIAL_BALANCE);
    }

    protected abstract BankAccount createAccount(AccountHolder holder, double initialBalance);

    @Test
    void testInitialBalance() {
        assertEquals(INITIAL_BALANCE, bankAccount.getBalance());
    }

    @Test
    void testDeposit() {
        bankAccount.deposit(accountHolder.id(), DEPOSIT_AMOUNT);
        assertEquals(DEPOSIT_AMOUNT, bankAccount.getBalance());
    }

    @Test
    void testWrongDeposit() {
        int wrongDepositAmount = 50;
        bankAccount.deposit(accountHolder.id(), DEPOSIT_AMOUNT);
        bankAccount.deposit(WRONG_ACCOUNT_ID , wrongDepositAmount);
        assertEquals(DEPOSIT_AMOUNT, bankAccount.getBalance());
    }

    @Test
    void testWithdraw() {
        bankAccount.deposit(accountHolder.id(), DEPOSIT_AMOUNT);
        bankAccount.withdraw(accountHolder.id(), WITHDRAW_AMOUNT);
        double expectedBalance = DEPOSIT_AMOUNT - WITHDRAW_AMOUNT;
        assertEquals(expectedBalance, bankAccount.getBalance());
    }

    @Test
    void testWrongWithdraw() {
        bankAccount.deposit(accountHolder.id(), DEPOSIT_AMOUNT);
        bankAccount.withdraw(WRONG_ACCOUNT_ID, WITHDRAW_AMOUNT );
        assertEquals(DEPOSIT_AMOUNT, bankAccount.getBalance());
    }

}