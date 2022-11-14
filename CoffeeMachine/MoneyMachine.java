import java.util.Scanner;

public class MoneyMachine {
    // Show ressources and update along the way
    public int money;
    public int quarters;
    public int dimes;
    public int nickels;
    public int pennies;
    private double quarterValue = 0.25;
    private double dimeValue = 0.1;
    private double nickelValue = 0.05;
    private double pennyValue = 0.01;
    private double moneyInserted;


    public MoneyMachine(){
        money = 0;
        quarters = 0;
        dimes = 0;
        nickels = 0;
        pennies = 0;
    }

    // Show money
    public void showMoney(){
        System.out.println("MONEY: $" + this.money);
    }
    // INPUT MONEY
    public void moneyInput(double price){
        boolean correctInputMoney = false;
        while (!correctInputMoney){
            insertCoin();
            correctInputMoney = moneyTreatment(price);
        }
    }
    // INSERT COIN
    public void insertCoin(){
        Scanner moneyInp = new Scanner(System.in);
        System.out.println("Please insert money");
        System.out.print("- Quarters: ");
        this.quarters += moneyInp.nextInt();
        System.out.print("- Dimes: ");
        this.dimes += moneyInp.nextInt();
        System.out.print("- Nickels: ");
        this.nickels += moneyInp.nextInt();
        System.out.print("- Pennies: ");
        this.pennies += moneyInp.nextInt();
        moneyInserted = this.quarters * this.quarterValue + this.dimes * this.dimeValue + this.nickels * this.nickelValue + this.dimes * this.dimeValue;
    }
    // MONEY TREATMENT
    public boolean moneyTreatment(double price){
        if (this.moneyInserted == price){
            this.money += price;
            return true;
        } else if (this.moneyInserted > price){
            this.money += price;
            setChange(price);
            return true;
        } else {
            System.out.println("Not enough money. Please try again.");
            return false;
        }
    }
    // CALCULATE CHANGE
    private void setChange(double price){
        if (this.moneyInserted > price){
            double changeMoney = this.moneyInserted - price;
            System.out.println("Here is your change: $" + changeMoney);
        }
    }
}   
