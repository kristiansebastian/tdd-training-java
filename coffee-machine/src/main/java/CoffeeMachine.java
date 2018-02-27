import drink.*;

import java.util.*;

public class CoffeeMachine {

    private DrinkManager drinkManager;

    private Wallet wallet;

    private Printer printer;

    private Map<String, Integer> totalDrinksSoldByType = new HashMap<>();

    private float totalMoneyEarn = 0.0f;

    private int sugar = 1;

    private boolean extraHot = false;

    public CoffeeMachine(DrinkManager drinkManager, Wallet wallet, Printer printer) {
        this.drinkManager = drinkManager;
        this.wallet = wallet;
        this.printer = printer;
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

    public void makeOrange() {
        makeDrink(new Orange());
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

    public void setExtraHot(boolean extraHot) {
        this.extraHot = extraHot;
    }

    public void printReport() {
        this.printer.printReport(this.totalDrinksSoldByType, totalMoneyEarn);
    }

    private void makeDrink(IDrink drink) {

        if (!hasEnoughMoneyToMakeTheDrink(drink)) {
            this.drinkManager.executeNoDrink(new NoDrink(), this.getMoneyLeft(drink));
            return;
        } else if (hasToMakeDrinkExtraHot(drink)){
            this.drinkManager.executeHotDrink(drink, this.sugar);
        } else {
            this.drinkManager.execute(drink, this.sugar);
        }

        this.wallet.reset();

        this.totalMoneyEarn += drink.getPrice();

        addTheDrinkToDrinksSold(drink);
    }

    private void addTheDrinkToDrinksSold(IDrink drink) {
        Integer numberOfDrinkSold = this.totalDrinksSoldByType.getOrDefault(drink.getDrinkMakerCode(), 0);
        this.totalDrinksSoldByType.put(drink.getDrinkMakerCode(), numberOfDrinkSold + 1);
    }

    private boolean hasToMakeDrinkExtraHot(IDrink drink) {
        return this.extraHot && drink instanceof IHotDrink;
    }

    private float getMoneyLeft(IDrink drink) {
        return drink.getPrice() - this.wallet.getMoney();
    }

    private boolean hasEnoughMoneyToMakeTheDrink(IDrink drink) {
        return this.wallet.getMoney() >= drink.getPrice();
    }

    private boolean isSugarBelowMinimum(int sugar) {
        return sugar < 0;
    }

    private boolean isSugarAboveMaximum(int sugar) {
        return sugar > 2;
    }
}
