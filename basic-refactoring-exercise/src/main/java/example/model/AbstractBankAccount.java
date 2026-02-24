package example.model;

public abstract class AbstractBankAccount implements BankAccount{

    protected double balance;
    private final AccountHolder holder;

    public AbstractBankAccount(AccountHolder holder, double balance) {
        this.holder = holder;
        this.balance = balance;
    }

    @Override
    public double getBalance() {
        return this.balance;
    }

    @Override
    public void deposit(int userID, double amount) {
        if (checkUser(userID)) {
            this.balance += amount;
        }
    }

    @Override
    public void withdraw(int userID, double amount) {
        if (checkUser(userID) && isWithdrawAllowed(amount)) {
            this.balance -= (amount + getWithdrawFee());
        }
    }

    protected abstract double getWithdrawFee();

    private boolean isWithdrawAllowed(final double amount){
        return this.balance >= amount + getWithdrawFee();
    }

    private boolean checkUser(final int id) {
        return this.holder.id() == id;
    }
}
