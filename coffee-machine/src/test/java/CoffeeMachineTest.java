import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class CoffeeMachineTest {

    @Test
    public void makeCoffeeWithoutSugar(){
        DrinkManager drinkManager = mock(DrinkManager.class);
        CoffeeMachine coffeeMachine = new CoffeeMachine(drinkManager);

        coffeeMachine.makeCoffee();

        verify(drinkManager).execute("C::");
    }

    @Test
    public void makeTeaWithoutSugar() {
        DrinkManager drinkManager = mock(DrinkManager.class);
        CoffeeMachine coffeeMachine = new CoffeeMachine(drinkManager);

        coffeeMachine.makeTea();

        verify(drinkManager).execute("T::");
    }

    @Test
    public void makeChocolateWithoutSugar() {
        DrinkManager drinkManager = mock(DrinkManager.class);
        CoffeeMachine coffeeMachine = new CoffeeMachine(drinkManager);

        coffeeMachine.makeChocolate();

        verify(drinkManager).execute("H::");
    }


}
