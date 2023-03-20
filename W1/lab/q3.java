import java.util.Date;

public class q3 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Enter id: ");
        int id = sc.nextInt();
        System.out.print("Enter balance: ");
        double balance = sc.nextDouble();
        System.out.print("Enter annual interest rate: ");
        double annualInterestRate = sc.nextDouble();
        Account acc = new Account(id, balance, annualInterestRate);
        acc.withdraw(1500);
        acc.deposit(3000);
        System.out.println();
        System.out.println("Balance: RM" + acc.getBalance());
        System.out.printf("Monthly interest: RM%.2f", acc.getMonthlyInterest());
        System.out.println("Date created: " + acc.getDateCreated());
    }
}

class Account {
    private int id;
    private double balance;
    private double annualInterestRate;
    private Date dateCreated;

    public Account() {
        id = 0;
        balance = 0;
        annualInterestRate = 0;
        dateCreated = new Date();
    }

    public Account(int id, double balance, double interest) {
        this.id = id;
        this.balance = balance;
        this.annualInterestRate = interest;
        dateCreated = new Date();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public double getMonthlyInterestRate() {
        return annualInterestRate / 12;
    }

    public double getMonthlyInterest() {
        return balance * getMonthlyInterestRate() / 100;
    }

    public void withdraw(double amount) {
        balance -= amount;
    }

    public void deposit(double amount) {
        balance += amount;
    }
}
