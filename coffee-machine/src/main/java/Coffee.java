public class Coffee implements IDrink {
    @Override
    public String getDrinkMakerCode() {
        return "C";
    }

    @Override
    public Float getPrice() {
        return 0.6f;
    }
}
