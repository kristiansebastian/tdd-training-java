import drink.Coffee;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.*;

public class CoffeeMachineTest {

    private DrinkMaker drinkMaker;
    private Wallet wallet;
    private Printer printer;
    private CoffeeMachine coffeeMachine;

    @Before
    public void setupCoffeeMachineWithOneEuro(){
        drinkMaker = mock(DrinkMaker.class);
        printer = mock(Printer.class);
        wallet = new Wallet();
        wallet.addMoney(1.0f);
        coffeeMachine = new CoffeeMachine(new DrinkManager(drinkMaker), wallet, printer);
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
    public void makeOrangeWithoutSugar() {

        coffeeMachine.selectSugar(0);
        coffeeMachine.makeOrange();

        verify(drinkMaker).execute("O::");
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

    @Test
    public void makeHotCoffee(){

        coffeeMachine.selectSugar(1);
        coffeeMachine.setExtraHot(true);
        coffeeMachine.makeCoffee();

        verify(drinkMaker).execute("Ch:1:0");
    }

    @Test
    public void makeColdOrangeEvenSettingExtraHot(){

        coffeeMachine.selectSugar(1);
        coffeeMachine.setExtraHot(true);
        coffeeMachine.makeOrange();

        verify(drinkMaker).execute("O:1:0");
    }

    @Test
    public void printReport(){

        coffeeMachine.printReport();

        Map<String, Integer> drinksSold = new HashMap<>();
        verify(printer).printReport(drinksSold, 0.0f);

        coffeeMachine.makeCoffee();
        coffeeMachine.printReport();

        Coffee coffee = new Coffee();
        drinksSold.put(coffee.getDrinkMakerCode(), 1);
        verify(printer).printReport(drinksSold, coffee.getPrice());

        wallet.addMoney(1.0f);
        coffeeMachine.makeCoffee();
        coffeeMachine.printReport();

        drinksSold.put(coffee.getDrinkMakerCode(), 2);
        verify(printer).printReport(drinksSold, coffee.getPrice() * 2);


    }

}
