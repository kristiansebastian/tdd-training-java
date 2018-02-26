package drink;

public interface IHotDrink extends IDrink {
    default String getExtraHotDrinkMakerCode(){
        return String.format("%sh", getDrinkMakerCode());
    }
}
