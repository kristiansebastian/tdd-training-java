package drink;

public class Tea implements IDrink {
    @Override
    public String getDrinkMakerCode() {
        return "T";
    }

    @Override
    public Float getPrice() {
        return 0.4f;
    }
}
