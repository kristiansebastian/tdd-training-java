package drink;

public interface IDrink {
    String getDrinkMakerCode();
    default String getExtraHotDrinkMakerCode(){
        return getDrinkMakerCode();
    }
    Float getPrice();
}
