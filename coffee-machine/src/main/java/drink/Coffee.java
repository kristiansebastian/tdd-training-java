package drink;

public class Coffee implements IHotDrink {
    @Override
    public String getDrinkMakerCode() {
        return "C";
    }

    @Override
    public Float getPrice() {
        return 0.6f;
    }
}
