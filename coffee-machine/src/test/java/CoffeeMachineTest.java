import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class CoffeeMachineTest {

    @Test
    public void doCoffee(){
        DrinkManager drinkManager = mock(DrinkManager.class);
        CoffeeMachine coffeeMachine = new CoffeeMachine(drinkManager);

        coffeeMachine.makeCoffee();

        verify(drinkManager).execute("C::");
    }


}
