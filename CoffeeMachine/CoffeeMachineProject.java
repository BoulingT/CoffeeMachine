public class CoffeeMachineProject {

    public static void main(String[] args){

        // Turn off the machine

        // CREATING COFFEE MACHINE OBJECT
        CoffeeMachine coffeeMachine = new CoffeeMachine();
        while (coffeeMachine.machineOn){
            coffeeMachine.coffeeMachineProgram();
        }
    }
}