import drink.IDrink;

import java.util.Map;
import java.util.stream.Collectors;

public class Printer {

    public void printReport(Map<String, Integer> drinksSold, float money) {
        String result = drinksSold.entrySet()
                .stream()
                .map(entry -> entry.getKey() + " = " + entry.getValue())
                .collect(Collectors.joining(", "));

        System.out.println(
                String.format("Drinks sold: %s", result, money));
    }
}
