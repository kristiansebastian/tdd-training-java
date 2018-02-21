public class CoffeeMachine {

    private DrinkManager drinkManager;

    public CoffeeMachine(DrinkManager drinkManager) {
        this.drinkManager = drinkManager;
    }

    public void makeCoffee() {
        drinkManager.execute("C::");
    }

    public void makeTea() {
        drinkManager.execute("T::");
    }
}
