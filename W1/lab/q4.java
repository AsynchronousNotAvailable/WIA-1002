import java.util.Date;
import java.util.Scanner;
import java.util.ArrayList;

class Transaction {
    private Date date;
    private char type;
    private double amount;
    private double balance;
    private String description;

    public Transaction(char type, double amount, double balance, String description){
        this.date = new Date();
        this.type = type;
        this.amount = amount;
        this.balance = balance;
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public char getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    public double getBalance() {
        return balance;
    }

    public String getDescription() {
        return description;
    }
}

class Account1 {
    private int id;
    private String name;
    private double balance;
    private double annualInterestRate;
    private Date dateCreated;

    private ArrayList<Transaction> transactions;

    public Account1(){
        id = 0;
        name = "";
        balance = 0;
        annualInterestRate = 0;
        dateCreated = new Date();
        transactions = new ArrayList<>();
    }

    public Account1(int id, String name, double balance, double interest){
        this.id = id;
        this.name = name;
        this.balance = balance;
        this.annualInterestRate = interest;
        dateCreated = new Date();
        transactions = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public double getMonthlyInterestRate(){
        return annualInterestRate / 12;
    }

    public double getMonthlyInterest(){
        return balance * getMonthlyInterestRate() / 100;
    }

    public void withdraw(double amount){
        balance -= amount;
        Transaction t = new Transaction('W', amount, balance, "Withdraw");
        transactions.add(t);
    }

    public void deposit(double amount){
        balance += amount;
        Transaction t = new Transaction('D', amount, balance, "Deposit");
        transactions.add(t);
    }

    public ArrayList<Transaction> getTransactions(){
        return transactions;
    }
}

class q4 {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.print("Enter id: ");
        int id = sc.nextInt();
        System.out.print("Enter name: ");
        sc.next(); // consume the newline character
        String name = sc.nextLine();
        System.out.print("Enter balance: ");
        double balance = sc.nextDouble();
        System.out.print("Enter annual interest rate: ");
        double annualInterestRate = sc.nextDouble();
        Account1 acc = new Account1(id, name, balance, annualInterestRate);
        acc.deposit(30);
        acc.deposit(40);
        acc.deposit(50);
        acc.withdraw(5);
        acc.withdraw(4);
        acc.withdraw(2);
        System.out.println();
        System.out.println("Account holder: " + acc.getName());
        System.out.println("Interest rate: " + acc.getAnnualInterestRate());
        System.out.println("Final Balance: " + acc.getBalance());
        System.out.printf("%-35s%-5s%-10s%-14s%-15s\n", "Date", "Type", "Amount", "Balance", "Description");
        for (Transaction t : acc.getTransactions()) {
            System.out.printf("%-35s%-5s%-10.2f%-14.2f%-15s\n", t.getDate(), t.getType(), t.getAmount(), t.getBalance(), t.getDescription());
        }
    }
}