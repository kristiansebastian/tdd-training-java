package drink;

public class Orange implements IDrink {
    @Override
    public String getDrinkMakerCode() {
        return "O";
    }

    @Override
    public Float getPrice() {
        return 0.6f;
    }
}
