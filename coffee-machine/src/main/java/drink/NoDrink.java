package drink;

public class NoDrink implements IDrink {

    @Override
    public String getDrinkMakerCode() {
        return "M";
    }

    @Override
    public Float getPrice() {
        return -1.0f;
    }

}
