import drink.IDrink;
import drink.IHotDrink;

public class DrinkManager {

    private DrinkMaker drinkMaker;

    public DrinkManager(DrinkMaker drinkMaker) {
        this.drinkMaker = drinkMaker;
    }

    public void execute(IDrink drink, int sugar){
        this.drinkMaker.execute(
                String.format("%s:%s:%s", drink.getDrinkMakerCode(), getSugarCode(sugar), getStickCode(sugar)));
    }

    public void executeHotDrink(IHotDrink drink, int sugar) {
        this.drinkMaker.execute(
                String.format("%s:%s:%s", drink.getExtraHotDrinkMakerCode(), getSugarCode(sugar), getStickCode(sugar)));
    }

    public void executeNoDrink(IDrink drink, float moneyLeft) {
        this.drinkMaker.execute(
                String.format("%s:There isn't enough money, left %f", drink.getDrinkMakerCode(), moneyLeft));
    }

    private String getStickCode(int sugar) {
        return sugar > 0 ? "0" : "";
    }

    private String getSugarCode(int sugar) {
        return sugar > 0 ? Integer.toString(sugar) : "";
    }
}
