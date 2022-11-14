import java.util.Scanner;

public class CoffeeMachine {
    private String order;
    public boolean machineOn = true;
    public int water = 300;
    public int milk = 200;
    public int coffee = 100;
    public  double money = 0;
    boolean enoughRessources;
    double orderPrice;
    //Espresso:
    int waterEspresso = 50;
    int coffeeEspresso = 18;
    double moneyEspresso = 1.5;
    //Latte
    int waterLatte = 200;
    int coffeeLatte = 24;
    int milkLatte = 150;
    double moneyLatte = 2.5;
    //Cappuccino
    int waterCappuccino = 250;
    int coffeeCappuccino = 24;
    int milkCappuccino = 50;
    double moneyCappuccino = 3;

    MoneyMachine moneyMachine;


    // Ask what the user wants
    public CoffeeMachine(){
        this.moneyMachine = new MoneyMachine();
        while (this.machineOn){
            coffeeMachineProgram();
        }
    }
    // Coffee Machine program
    public void coffeeMachineProgram(){
        coffeesAvailable();
        if (inputTreatment()){
            globalRessourcesTreatment();
        }
    }
    // START FUNCTION TO TREAT THE USER INPUT
    private boolean inputTreatment(){
        boolean orderCorrect = false;
        Scanner orderInp = new Scanner(System.in);
        while (!orderCorrect){
            System.out.print("What coffee do you want: ");
            order = orderInp.nextLine();
            orderCorrect = setCorrectOrder(this.order, this.moneyMachine);
        }
        orderInp.close();
        return treatOffCommand(this.order, orderCorrect);
    } 
    // FUNCTION TO DETERMINE IF INPUT VALID
    private boolean setCorrectOrder(String orderInput, MoneyMachine moneyMachine){
        if (orderInput.equalsIgnoreCase("off") || orderInput.equalsIgnoreCase("espresso") || orderInput.equalsIgnoreCase("cappuccino") || orderInput.equalsIgnoreCase("latte")){
            return true;
        } else if (orderInput.equalsIgnoreCase("report")){
            showReport(moneyMachine);
            return false;
        } else {
            System.out.println("Error: please try again.");
            return false;}
    }
    // FUNCTION TO TREAT "OFF" COMMAND OR "REPORT COMMAND"
    private boolean treatOffCommand(String order, boolean orderCorrect){
        if (orderCorrect == true && order.equalsIgnoreCase("off")){
            machineOn = false;
            return false;
        } else {return true;}
    }


    // PRINT FUNCTIONS
    // Function to show ressources
    private void showReport(MoneyMachine moneyMachine){
        System.out.println("WATER: " + this.water + "mL");
        System.out.println("MILK: " + this.milk + "mL");
        System.out.println("COFEE: " + this.coffee + "g");
        moneyMachine.showMoney();
        System.out.println("******");
    }// Function to show coffees available
    private void coffeesAvailable(){
        System.out.println("- Espresso: $1.5\n" +
                            "- Latte: $2.5\n" +
                            "- Cappuccino: $3");}
    
    // RESSOURCES FUNCTIONS
    // Global ressources function
    private void globalRessourcesTreatment(){
        if (checkEnoughRessources(this.order) == true){
            this.moneyMachine.moneyInput(orderPrice);
            deduceRessources(this.order);
        }
    }
    // Check if enough ressources to make ordered coffeee
    private boolean checkEnoughRessources(String order){
        if (order.equalsIgnoreCase("espresso")){
            return checkRessourcesEspresso();
        } else if (order.equalsIgnoreCase("latte")){
            return checkRessourcesLatte();
        } else {
            return checkRessourcesCappuccino();
        }
    }
    // Check enough ressources for espresso
    private boolean checkRessourcesEspresso(){
        if (this.coffee >= this.coffeeEspresso && this.water >= this.waterEspresso){
            System.out.println("TEST1");
            this.orderPrice = this.moneyEspresso;
            return true;
        } else {
            System.out.println("Error: Not enough ressources. Try again later.");
            return false;
        }
    }
    //Check enough ressources for latte
    private boolean checkRessourcesLatte(){
        if (this.coffee >= this.coffeeLatte && this.water >= this.waterLatte && this.milk >= this.milkLatte){
            this.orderPrice = this.moneyLatte;
            return true;
        } else {
            System.out.println("Error: Not enough ressources. Try again later.");
            return false;
        }
    }
    // Check enough ressources Cappuccino
    private boolean checkRessourcesCappuccino(){
        if (this.coffee >= this.coffeeCappuccino && this.water >= this.waterCappuccino && this.milk >= this.milkCappuccino){
            this.orderPrice = this.moneyCappuccino;
            return true;
        } else {
            System.out.println("Error: Not enough ressources. Try again later.");
            return false;
        }
    }
    // DEDUCE ORDER RESSOURCES FORM RESSOURCES
    private void deduceRessources(String order){
        if (order.equalsIgnoreCase("espresso")){
            espressoRessourcesManagement();
            System.out.println("Here is your espresso, enjoy!");
        } else if (order.equalsIgnoreCase("latte")){
            latteRessourcesManagement();
            System.out.println("Here is your latte, enjoy!");
        } else {
            cappuccinoRessourcesManagement();
            System.out.println("Here is your cappuccino, enjoy!");
        }
    }
    // Espresso ressources management
    private void espressoRessourcesManagement(){
        this.water -= this.waterEspresso;
        this.coffee -= this.coffeeEspresso;
    }
    // Espresso ressources management
    private void latteRessourcesManagement(){
        this.water -= this.waterLatte;
        this.coffee -= this.coffeeLatte;
    }
    // Espresso ressources management
    private void cappuccinoRessourcesManagement(){
        this.water -= this.waterCappuccino;
        this.coffee -= this.coffeeCappuccino;
    }

}
