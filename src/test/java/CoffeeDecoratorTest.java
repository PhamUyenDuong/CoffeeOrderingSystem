import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static java.lang.Math.round;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CoffeeDecoratorTest {
//    static Coffee basicCoffee;
//
//    @BeforeAll
//    public static void setUp() {
//        basicCoffee = new BasicCoffee();
//    }

    @Test
    public void test_cream(){
        Coffee basicCoffee = new Cream(new BasicCoffee());
        assertEquals(5, basicCoffee.makeCoffee());
    }

    @Test
    public void test_sugar(){
        Coffee basicCoffee = new Sugar(new Cream(new BasicCoffee()));
        assertEquals(5.5, basicCoffee.makeCoffee());
    }

    @Test
    public void test_extraShot(){
       Coffee basicCoffee = new ExtraShot(new Sugar(new Cream(new BasicCoffee())));
        assertEquals(6.7, basicCoffee.makeCoffee());
    }

    @Test
    public void test_chocolate(){
        Coffee basicCoffee = new Chocolate(new ExtraShot(new Sugar(new Cream(new BasicCoffee()))));
        assertEquals(7.7, basicCoffee.makeCoffee());
    }

    @Test
    public void test_gold(){
        Coffee basicCoffee = new Gold(new Chocolate(new ExtraShot(new Sugar(new Cream(new BasicCoffee())))));
        assertEquals(17.7, basicCoffee.makeCoffee());
    }

    @Test
    public void test_diffCombs(){
        Coffee basicCoffee = new Sugar(new Chocolate(new ExtraShot(new Gold(new Cream(new BasicCoffee())))));
        assertEquals(17.7, basicCoffee.makeCoffee());
    }

    @Test
    public void test_moreAddOns(){
        Coffee basicCoffee = new Gold(new Gold(new Sugar(new Chocolate(new ExtraShot(new Gold(new Cream(new BasicCoffee())))))));
        assertEquals(37.7, basicCoffee.makeCoffee());
    }

    @Test
    public void test_multipleSugar(){
        Coffee basicCoffee = new Sugar(new Sugar(new Sugar(new BasicCoffee())));
        assertEquals(6, basicCoffee.makeCoffee());
    }

    @Test
    public void test_multipleCream(){
        Coffee basicCoffee = new Cream(new Cream(new Cream(new BasicCoffee())));
        assertEquals(6, basicCoffee.makeCoffee());
    }

    @Test
    public void test_multipleChocolate(){
        Coffee basicCoffee = new Chocolate(new Chocolate(new Chocolate(new BasicCoffee())));
        assertEquals(7.5, basicCoffee.makeCoffee());
    }

    @Test
    public void test_multipleExtraShot(){
        Coffee basicCoffee = new ExtraShot(new ExtraShot(new ExtraShot(new BasicCoffee())));
        assertEquals(8.1, basicCoffee.makeCoffee());
    }

    @Test
    public void test_multipleGold(){
        Coffee basicCoffee = new Gold(new Gold(new Gold(new BasicCoffee())));
        assertEquals(34.5, basicCoffee.makeCoffee());
    }

    @Test
    public void test_manyAlotMultipleGold(){
        Coffee basicCoffee = new Gold(new Gold(new Gold(new Gold(new Gold(new Gold(new Gold(new BasicCoffee())))))));
        assertEquals(74.5, basicCoffee.makeCoffee());
    }

    @Test
    public void test_manyAlotMultipleCream(){
        Coffee basicCoffee = new Cream(new Cream(new Cream(new Cream(new Cream(new Cream(new Cream(new BasicCoffee())))))));
        assertEquals(8, basicCoffee.makeCoffee());
    }

    @Test
    public void test_manyAlotMultipleSugar(){
        Coffee basicCoffee = new Sugar(new Sugar(new Sugar(new Sugar(new Sugar(new Sugar(new Sugar(new BasicCoffee())))))));
        assertEquals(8, basicCoffee.makeCoffee());
    }

    @Test
    public void test_manyAlotMultipleExtraShot(){
        Coffee basicCoffee = new ExtraShot(new ExtraShot(new ExtraShot(new ExtraShot(new ExtraShot(new ExtraShot(new ExtraShot(new BasicCoffee())))))));
        assertEquals(13, round(basicCoffee.makeCoffee()));
    }

    @Test
    public void test_manyAlotMultipleChocolate(){
        Coffee basicCoffee = new Chocolate(new Chocolate(new Chocolate(new Chocolate(new Chocolate(new Chocolate(new Chocolate(new BasicCoffee())))))));
        assertEquals(11.5, basicCoffee.makeCoffee());
    }
}
