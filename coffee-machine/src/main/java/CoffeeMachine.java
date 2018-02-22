public class CoffeeMachine {

    private DrinkManager drinkManager;

    private Wallet wallet;

    private int sugar = 1;

    public CoffeeMachine(DrinkManager drinkManager, Wallet wallet) {
        this.drinkManager = drinkManager;
        this.wallet = wallet;
    }

    public void makeCoffee() {
        makeDrink(new Coffee());
    }

    public void makeTea() {
        makeDrink(new Tea());
    }

    public void makeChocolate() {
        makeDrink(new Chocolate());
    }

    private void makeDrink(IDrink drink) {
        if (hasEnoughMoneyToMakeTheDrink(drink)) {
            this.drinkManager.execute(drink, this.sugar);
        }
    }

    private boolean hasEnoughMoneyToMakeTheDrink(IDrink drink) {
        return this.wallet.getMoney() >= drink.getPrice();
    }

    public void selectSugar(int sugar) {
        if (isSugarAboveMaximum(sugar)){
            this.sugar = 2;
        } else if (isSugarBelowMinimum(sugar)){
            this.sugar = 0;
        } else {
            this.sugar = sugar;
        }
    }

    private boolean isSugarBelowMinimum(int sugar) {
        return sugar < 0;
    }

    private boolean isSugarAboveMaximum(int sugar) {
        return sugar > 2;
    }
}
