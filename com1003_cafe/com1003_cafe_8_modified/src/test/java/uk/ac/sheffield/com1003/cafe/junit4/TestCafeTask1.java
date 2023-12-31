package uk.ac.sheffield.com1003.cafe.junit4;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import uk.ac.sheffield.com1003.cafe.Cafe;
import uk.ac.sheffield.com1003.cafe.Recipe;
import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.Coffee;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk;
import uk.ac.sheffield.com1003.cafe.ingredients.Unit;
import uk.ac.sheffield.com1003.cafe.ingredients.Water;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestCafeTask1 {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    protected Recipe createEspressoRecipe() {
        try {
            Recipe espresso = new Recipe("Espresso", 1.5, Recipe.Size.SMALL, 2);
            espresso.addIngredient(new Coffee());
            espresso.addIngredient(new Water());
            return espresso;
        } catch (TooManyIngredientsException exc) {
            System.err.println(exc.getMessage());
            return null;
        }
    }

    protected Recipe createEspressoRecipeAlt() {
        try {
            Recipe espresso = new Recipe("Espresso", 1.5, Recipe.Size.SMALL, 2);
            espresso.addIngredient(new Water());
            espresso.addIngredient(new Coffee());
            return espresso;
        } catch (TooManyIngredientsException exc) {
            System.err.println(exc.getMessage());
            return null;
        }
    }

    protected Recipe createEspressoRecipeIncomplete() {
        try {
            Recipe espresso = new Recipe("Espresso", 1.5, Recipe.Size.SMALL, 2);
            espresso.addIngredient(new Water());
            return espresso;
        } catch (TooManyIngredientsException exc) {
            System.err.println(exc.getMessage());
            return null;
        }
    }

//    protected ArrayList<String> getOutLines() {
//        Stream<String> lines = outContent.toString().lines();
//        ArrayList<String> arrayList = new ArrayList<>();
//        lines.forEach(arrayList::add);
//        return arrayList;
//    }

    protected void resetOutLines() {
        outContent.reset();
    }

//    protected ArrayList<String> getErrLines() {
//        Stream<String> lines = errContent.toString().lines();
//        ArrayList<String> arrayList = new ArrayList<>();
//        lines.forEach(arrayList::add);
//        return arrayList;
//    }

    @Test
    public void testAppClassExists() throws ClassNotFoundException {
        Class<?> clazz = Class.forName("uk.ac.sheffield.com1003.cafe.App");
        assertNotNull(clazz);
    }

    @Test
    public void testAddRecipeAndMenuSize() throws Exception {
        Cafe cafe = new Cafe("Central Perk");
        Recipe espresso = createEspressoRecipe();
        assertTrue(cafe.addRecipe(espresso));
        Recipe americano = new Recipe("Americano", 2, Recipe.Size.REGULAR, 2);
        americano.addIngredient(new Coffee());
        americano.addIngredient(new Water());
        assertTrue(cafe.addRecipe(americano));
        assertEquals(2, cafe.getMenu().length);
    }

    @Test
    public void testAddRecipeMenuSizeZero() throws Exception {
        Cafe cafe = new Cafe("Central Perk", 0, 10); // only one recipe can be allowed
        Recipe espresso = createEspressoRecipe();
        assertFalse(cafe.addRecipe(espresso));
        assertEquals(0, cafe.getMenu().length);
    }

    @Test
    public void testAddRecipeExceedingMenuSize() throws Exception {
        Cafe cafe = new Cafe("Central Perk", 1, 10); // only one recipe can be allowed
        Recipe espresso = createEspressoRecipe();
        assertTrue(cafe.addRecipe(espresso));
        Recipe americano = new Recipe("Americano", 2, Recipe.Size.REGULAR, 2);
        americano.addIngredient(new Coffee());
        americano.addIngredient(new Water());
        assertFalse(cafe.addRecipe(americano)); // should not be added
        assertEquals(1, cafe.getMenu().length);
    }

    @Test
    public void testCoffeeConstructor() throws IllegalAccessException {
        Coffee c = new Coffee();
        assertEquals("Coffee", c.getName());
        assertEquals(8, c.getAmount());
        assertEquals(Unit.GR, c.getUnit());

        // Having to use reflection because we didn't provide
        // a getter for Coffee.decaf or ask for one to be implemented
        assertFalse(c.getDecaf());
    }

    @Test
    public void testCoffeeConstructorOverloaded() throws InvocationTargetException, NoSuchMethodException, IllegalAccessException, InstantiationException {
        // if Coffee(int amount) has not been implemented, this will throw NoSuchMethodException

        Coffee c = new Coffee(30);
        assertEquals("Coffee", c.getName());
        assertEquals(30, c.getAmount());
        assertEquals(Unit.GR, c.getUnit());
        assertFalse(c.getDecaf());
    }

    @Test
    public void testWaterConstructorOverloaded() throws InvocationTargetException, NoSuchMethodException, IllegalAccessException, InstantiationException {
        Water w = new Water(120);
        assertNotNull(w);
        assertEquals("Water", w.getName());
        assertEquals(120, w.getAmount());
        assertEquals(Unit.ML, w.getUnit());
    }

    @Test
    public void testWaterConstructor() {
        Water w = new Water();
        assertEquals("Water", w.getName());
        assertEquals(Unit.ML, w.getUnit());
    }

    @Test
    public void testTooManyIngredients() {
        Recipe latte = new Recipe("Just Water", 1, Recipe.Size.LARGE, 1);
        assertThrows(TooManyIngredientsException.class, () -> {
            latte.addIngredient(new Water());
            latte.addIngredient(new Coffee());
        });
    }

    @Test
    public void testSoyMilkOptionExists() {
        boolean flag = false;
        for (Milk.Type type : Milk.Type.values()) {
            if (type.name().equals("SOY")) {
                flag = true;
                break;
            }
        }
        assertTrue(flag);

    }

}
