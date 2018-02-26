import drink.IDrink;

public class DrinkManager {

    private DrinkMaker drinkMaker;

    public DrinkManager(DrinkMaker drinkMaker) {
        this.drinkMaker = drinkMaker;
    }

    public void execute(IDrink drink, int sugar){
        String sugarString = sugar > 0 ? Integer.toString(sugar) : "";
        String stick = sugar > 0 ? "0" : "";
        this.drinkMaker.execute(String.format("%s:%s:%s", drink.getDrinkMakerCode(), sugarString, stick));
    }

    public void executeNoDrink(IDrink drink, float moneyLeft) {
        this.drinkMaker.execute(
                String.format("%s:There isn't enough money, left %f", drink.getDrinkMakerCode(), moneyLeft));
    }
}
