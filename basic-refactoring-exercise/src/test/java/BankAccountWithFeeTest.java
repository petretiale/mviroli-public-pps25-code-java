import example.model.AccountHolder;
import example.model.BankAccount;
import example.model.BankAccountWithFee;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class BankAccountWithFeeTest extends BankAccountTest{

    private static final double DEPOSIT_AMOUNT = 100;
    private static final double WITHDRAW_AMOUNT = 70;
    private static final double WITHDRAW_FEE = 1.0;

    @Override
    protected BankAccount createAccount(AccountHolder holder, double initialBalance) {
        return new BankAccountWithFee(holder, initialBalance);
    }

    @Override
    @Test
    void testWithdraw() {
        bankAccount.deposit(accountHolder.id(), DEPOSIT_AMOUNT);
        bankAccount.withdraw(accountHolder.id(), WITHDRAW_AMOUNT);
        double expectedBalance = DEPOSIT_AMOUNT - WITHDRAW_AMOUNT - WITHDRAW_FEE;
        assertEquals(expectedBalance, bankAccount.getBalance());
    }

    @Test
    void testWithdrawDeniedIfInsufficientFundsForFee() {
        bankAccount.deposit(accountHolder.id(), DEPOSIT_AMOUNT);
        bankAccount.withdraw(accountHolder.id(), DEPOSIT_AMOUNT);
        assertEquals(DEPOSIT_AMOUNT, bankAccount.getBalance());
    }
}
