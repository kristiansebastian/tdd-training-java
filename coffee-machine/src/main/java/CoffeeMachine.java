public class CoffeeMachine {

    private DrinkManager drinkManager;

    public CoffeeMachine(DrinkManager drinkManager) {
        this.drinkManager = drinkManager;
    }

    public void makeCoffee() {
        drinkManager.execute(new Coffee());
    }

    public void makeTea() {
        drinkManager.execute(new Tea());
    }

    public void makeChocolate() {
        drinkManager.execute(new Chocolate());
    }
}
