import com.sun.xml.internal.bind.v2.model.core.ID;

public class DrinkManager {

    private DrinkMaker drinkMaker;

    public DrinkManager(DrinkMaker drinkMaker) {
        this.drinkMaker = drinkMaker;
    }

    public void execute(IDrink drink, int sugar){
        String sugarString = sugar > 0 ? Integer.toString(sugar) : "";
        String stick = sugar > 0 ? "0" : "";
        drinkMaker.execute(String.format("%s:%s:%s", drink.getDrinkMakerCode(), sugarString, stick));
    }
}
