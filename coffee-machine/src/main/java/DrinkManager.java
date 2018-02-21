public class DrinkManager {

    private DrinkMaker drinkMaker;

    public DrinkManager(DrinkMaker drinkMaker) {
        this.drinkMaker = drinkMaker;
    }

    public void execute(String command){
        drinkMaker.execute(command);
    }
}
