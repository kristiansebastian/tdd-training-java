public class Chocolate implements IDrink {
    @Override
    public String getDrinkMakerCode() {
        return "H";
    }

    @Override
    public Float getPrice() {
        return 0.5f;
    }
}
