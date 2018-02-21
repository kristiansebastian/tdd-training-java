import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class CoffeeMachineTest {

    DrinkManager drinkManager;
    CoffeeMachine coffeeMachine;

    @Before
    public void setup(){
        drinkManager = mock(DrinkManager.class);
        coffeeMachine = new CoffeeMachine(drinkManager);
    }

    @Test
    public void makeCoffeeWithoutSugar(){

        coffeeMachine.makeCoffee();

        verify(drinkManager).execute("C::");
    }

    @Test
    public void makeTeaWithoutSugar() {

        coffeeMachine.makeTea();

        verify(drinkManager).execute("T::");
    }

    @Test
    public void makeChocolateWithoutSugar() {

        coffeeMachine.makeChocolate();

        verify(drinkManager).execute("H::");
    }


}
