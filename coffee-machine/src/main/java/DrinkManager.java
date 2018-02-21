import com.sun.xml.internal.bind.v2.model.core.ID;

public class DrinkManager {

    private DrinkMaker drinkMaker;

    public DrinkManager(DrinkMaker drinkMaker) {
        this.drinkMaker = drinkMaker;
    }

    public void execute(IDrink drink){
        drinkMaker.execute(String.format("%s::", drink.getDrinkMakerCode()));
    }
}
