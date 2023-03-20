package code;

interface Account {
    public abstract int deposit(int money);

    public abstract boolean withdraw(int want);
}

public class BankAccount implements Account{
    private double balance;

    public BankAccount(int money) {
        this.balance = money;
    }

    public int deposit(int money) {
        return (int) (this.balance + money);
    }
    
    public boolean withdraw(int want) {
        if (want > this.balance) {
            return false;
        }
        this.balance -= want;
        return true;
    }
}
