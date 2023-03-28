import java.util.Scanner;

public class T3Q1 {
    public static void main(String[] args) {
        CandyMachine vending = new CandyMachine();
    }
}

class Dispenser{
    protected String name;
    protected double price;
    protected double total;
    protected int quantity;

    public Dispenser(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    void calcTotal(int cart){
         this.total = this.price * cart;
    }

    void deductStock(int demand){
        this.quantity -= demand;
    }

    double getTotal(){
        return this.total;
    }

    int getQuantity(){
        return this.quantity;
    }
}

class CashRegister{
    protected double cashIn;
    protected double change;
    protected double total;

    Scanner sc = new Scanner(System.in);
    public CashRegister(){
        total  = 0;
        cashIn = 0;
        change = 0;
    }



    void pay(double price){
        do{
            System.out.println("The total amount to be paid is: " + price);
            System.out.println("Pls enter the amount you pay: (Negative number to cancel)");
            double pay = sc.nextDouble();
            if(pay > 0){
                this.cashIn += pay;
            }
            else{
                this.cashIn += 0;
            }
            price -= pay;
            double remaining = price;
            if (remaining < 0){
                double change = remaining;
                System.out.println("Finished pay liao. Nah here's your change: RM " + Math.abs(change));
                break;
            }

            System.out.println("You still have to pay "+ remaining);

        }

        while(price != 0);

        System.out.println("Finished pay liao. You can fuck off le");



    }





}

class CandyMachine{
        Scanner sc = new Scanner(System.in);
        Dispenser [] itemList = {new Dispenser("candies", 0.3, 50), new Dispenser("chips", 5.0, 60), new Dispenser("gum", 1.20, 100), new Dispenser("cookies", 4.60, 88)};
        CashRegister cashier = new CashRegister();

        public CandyMachine(){
            display();
            select();
            next();
        }

        void display(){
            System.out.printf("Welcome to WH Vending Machine.\n%20s\n-------------------------------\n", "Items Available");
            System.out.printf("%-10s%1s%-3s%s\n", "Name", "Price", "", "Quantity");
            for (Dispenser i: itemList){
                System.out.printf("%-10s%1.1f%-5s%d\n", i.name, i.price, "", i.getQuantity());
            }


        }

        void select(){
            System.out.println("Pls select the item that you want: ");

            String item = sc.next();


            for(Dispenser i: itemList){
                if(item.equals(i.name)){
                    System.out.printf("The price of the %s is: RM %.1f", i.name, i.price);
                    System.out.println("Enter the amount you want to buy: ");
                    int amount = sc.nextInt();

                    if (amount > i.quantity){
                        System.out.println("The vending machine doesn't have so many item la sohai");
                    }

                    else {
                        i.deductStock(amount);
                        i.calcTotal(amount);
                        cashier.pay(i.getTotal());

                    }
                }
            }
        }

        void next(){
            System.out.println("Do you wanna continue? ");
            Scanner sc = new Scanner(System.in);
            String ans = sc.next();
            if(ans.equals("yes")){
                display();
                select();
                next();
            }
            else{
                System.exit(0);
            }
    }

}
