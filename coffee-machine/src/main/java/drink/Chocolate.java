package drink;

public class Chocolate implements IHotDrink {
    @Override
    public String getDrinkMakerCode() {
        return "H";
    }

    @Override
    public Float getPrice() {
        return 0.5f;
    }
}
