package example.model;

public class BankAccountWithFee extends AbstractBankAccount {

    private static double WITHDRAW_FEE = 1.0;

    public BankAccountWithFee(AccountHolder holder, double balance) {
        super(holder, balance);
    }

    @Override
    protected double getWithdrawFee() {
        return WITHDRAW_FEE;
    }
}
