public class DrinkManager {

    private DrinkMaker drinkMaker = new DrinkMaker();

    public void execute(String command){
        drinkMaker.execute(command);
    }
}
