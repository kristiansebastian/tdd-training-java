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
        wallet = new Wallet();
        wallet.addMoney(1.0f);
        coffeeMachine = new CoffeeMachine(new DrinkManager(drinkMaker), wallet);
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

        wallet.reset();

        coffeeMachine.selectSugar(0);
        coffeeMachine.makeTea();

        verify(drinkMaker, never()).execute("T::");

        verify(drinkMaker).execute("M:There isn't enough money, left 0,400000");
    }

    @Test
    public void afterTheFirstDrinkNotServeTheSecondIfMoneyHasNotBeenAdded(){

        coffeeMachine.makeCoffee();

        verify(drinkMaker).execute("C:1:0");

        coffeeMachine.selectSugar(0);
        coffeeMachine.makeCoffee();

        verify(drinkMaker, never()).execute("C::");
    }

}
