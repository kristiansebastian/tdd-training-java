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

        coffeeMachine.selectSugar(0);
        coffeeMachine.makeCoffee();

        verify(drinkMaker).execute("C::");
    }

    @Test
    public void makeTeaWithoutSugar() {

        coffeeMachine.selectSugar(0);
        coffeeMachine.makeTea();

        verify(drinkMaker).execute("T::");
    }

    @Test
    public void makeChocolateWithoutSugar() {

        coffeeMachine.selectSugar(0);
        coffeeMachine.makeChocolate();

        verify(drinkMaker).execute("H::");
    }

    @Test
    public void makeChocolateWithOneSugar() {

        coffeeMachine.selectSugar(1);
        coffeeMachine.makeChocolate();

        verify(drinkMaker).execute("H:1:0");
    }

    @Test
    public void makeChocolateWithTwoSugar() {

        coffeeMachine.selectSugar(2);
        coffeeMachine.makeChocolate();

        verify(drinkMaker).execute("H:2:0");
    }

    @Test
    public void maxSugarShouldBeTwo() {

        coffeeMachine.selectSugar(3);
        coffeeMachine.makeChocolate();

        verify(drinkMaker).execute("H:2:0");
    }

    @Test
    public void minSugarShouldBeZero() {

        coffeeMachine.selectSugar(-1);
        coffeeMachine.makeChocolate();

        verify(drinkMaker).execute("H::");
    }

}
