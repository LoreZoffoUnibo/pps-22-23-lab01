package lab01.example.model;

public class SimpleBankAccountWithAtm implements BankAccount {
    public static double TRANSACTION_FEE = 1;
    private double balance;
    private final AccountHolder holder;
    public SimpleBankAccountWithAtm(final AccountHolder holder, final double balance) {
        this.holder = holder;
        this.balance = balance;
    }

    @Override
    public AccountHolder getHolder() {
        return null;
    }

    @Override
    public double getBalance() {
        return this.balance;
    }

    @Override
    public void deposit(final int userID, final double amount) {
        if (checkUser(userID)) {
            this.balance += amount;
            this.balance -= TRANSACTION_FEE;
        }
    }

    @Override
    public void withdraw(int userID, double amount) {
        if (checkUser(userID) && isWithdrawAllowed(amount)) {
            this.balance -= amount;
            this.balance -= TRANSACTION_FEE;
        }
    }

    private boolean checkUser(final int id) {
        return this.holder.getId() == id;
    }

    private boolean isWithdrawAllowed(final double amount){
        return this.balance >= amount;
    }
}
