import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class CoffeeMachineTest {

    private DrinkMaker drinkMaker;
    private Wallet wallet;
    private CoffeeMachine coffeeMachine;

    @Before
    public void setupCoffeeMachineWithOneEuro(){
        drinkMaker = mock(DrinkMaker.class);
        wallet = mock(Wallet.class);
        coffeeMachine = new CoffeeMachine(new DrinkManager(drinkMaker), wallet);

        when(wallet.getMoney()).thenReturn(1.0f);
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

    @Test
    public void doNotMakeDrinkIfNotEnoughMoney() {

        when(wallet.getMoney()).thenReturn(0.0f);

        coffeeMachine.selectSugar(0);
        coffeeMachine.makeTea();

        verify(drinkMaker, never()).execute("T::");
    }

}
