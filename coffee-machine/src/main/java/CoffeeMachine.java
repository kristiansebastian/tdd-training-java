public class CoffeeMachine {

    private DrinkManager drinkManager;

    private int sugar = 1;

    public CoffeeMachine(DrinkManager drinkManager) {
        this.drinkManager = drinkManager;
    }

    public void makeCoffee() {
        drinkManager.execute(new Coffee(), this.sugar);
    }

    public void makeTea() {
        drinkManager.execute(new Tea(), this.sugar);
    }

    public void makeChocolate() {
        drinkManager.execute(new Chocolate(), this.sugar);
    }

    public void selectSugar(int sugar) {
        if (sugar > 2){
            this.sugar = 2;
        } else if (sugar < 0){
            this.sugar = 0;
        } else {
            this.sugar = sugar;
        }
    }
}
