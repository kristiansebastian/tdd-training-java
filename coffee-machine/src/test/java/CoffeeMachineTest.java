import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class CoffeeMachineTest {

    private DrinkMaker drinkMaker;
    private CoffeeMachine coffeeMachine;

    @Before
    public void setup(){
        drinkMaker = mock(DrinkMaker.class);
        coffeeMachine = new CoffeeMachine(new DrinkManager(drinkMaker));
    }

    @Test
    public void makeCoffeeWithoutSugar(){

        coffeeMachine.makeCoffee();

        verify(drinkMaker).execute("C::");
    }

    @Test
    public void makeTeaWithoutSugar() {

        coffeeMachine.makeTea();

        verify(drinkMaker).execute("T::");
    }

    @Test
    public void makeChocolateWithoutSugar() {

        coffeeMachine.makeChocolate();

        verify(drinkMaker).execute("H::");
    }


}
