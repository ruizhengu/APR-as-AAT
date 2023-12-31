/*
 * This file was automatically generated by EvoSuite
 * Wed Sep 27 16:33:58 GMT 2023
 */

package uk.ac.sheffield.com1003.cafe.evosuite.mutation;

import org.junit.Test;
import static org.junit.Assert.*;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.runner.RunWith;
import uk.ac.sheffield.com1003.cafe.Recipe;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk;
import uk.ac.sheffield.com1003.cafe.ingredients.Water;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true) 
public class Recipe_ESTest extends Recipe_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
      Recipe.Size recipe_Size0 = Recipe.Size.REGULAR;
      Recipe recipe0 = new Recipe("<(l", (-1173.0), recipe_Size0, 2258);
      Recipe recipe1 = new Recipe((String) null, 2258, recipe_Size0, 2258);
      boolean boolean0 = recipe0.equals(recipe1);
      assertEquals(2258.0, recipe1.getPrice(), 0.01);
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test01()  throws Throwable  {
      Recipe.Size recipe_Size0 = Recipe.Size.REGULAR;
      Recipe recipe0 = new Recipe("Tc", 1767.869958095486, recipe_Size0, 0);
      Recipe recipe1 = new Recipe("F1:9Gul$`;\"]io", 1767.869958095486, recipe_Size0, 0);
      boolean boolean0 = recipe0.equals(recipe1);
      assertTrue(boolean0);
      assertEquals(1767.869958095486, recipe1.getPrice(), 0.01);
  }

  @Test(timeout = 4000)
  public void test02()  throws Throwable  {
      Recipe.Size recipe_Size0 = Recipe.Size.REGULAR;
      Recipe recipe0 = new Recipe((String) null, 2258, recipe_Size0, 2258);
      Recipe recipe1 = new Recipe(" 7u<i#%&@eT{s@go", 2258, recipe_Size0, 30);
      boolean boolean0 = recipe0.equals(recipe1);
      assertFalse(boolean0);
      assertFalse(recipe1.isReady());
      assertEquals(2258.0, recipe1.getPrice(), 0.01);
  }

  @Test(timeout = 4000)
  public void test03()  throws Throwable  {
      Recipe recipe0 = new Recipe((String) null, 0.0);
      Recipe.Size recipe_Size0 = Recipe.Size.LARGE;
      Recipe recipe1 = new Recipe("", 0.0, recipe_Size0, 0);
      boolean boolean0 = recipe0.equals(recipe1);
      assertFalse(boolean0);
      assertEquals(0.0, recipe1.getPrice(), 0.01);
      assertTrue(recipe1.isReady());
  }

  @Test(timeout = 4000)
  public void test04()  throws Throwable  {
      Recipe recipe0 = new Recipe("KzT,K(-iM", 1767.869958095486);
      Recipe.Size recipe_Size0 = Recipe.Size.REGULAR;
      Recipe recipe1 = new Recipe("F1:9Gul$`;\"]io", 22.4, recipe_Size0, 0);
      boolean boolean0 = recipe0.equals(recipe1);
      assertFalse(boolean0);
      assertTrue(recipe1.isReady());
      assertEquals(22.4, recipe1.getPrice(), 0.01);
  }

  @Test(timeout = 4000)
  public void test05()  throws Throwable  {
      Recipe recipe0 = new Recipe("KzT,K(-iM", 1767.869958095486);
      boolean boolean0 = recipe0.equals("F1:9Gul$`;\"]io");
      assertEquals(1767.869958095486, recipe0.getPrice(), 0.01);
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test06()  throws Throwable  {
      Recipe.Size recipe_Size0 = Recipe.Size.LARGE;
      Recipe recipe0 = new Recipe("", 3125.4112928631, recipe_Size0, 2840);
      boolean boolean0 = recipe0.equals(recipe0);
      assertEquals(3125.4112928631, recipe0.getPrice(), 0.01);
      assertTrue(boolean0);
  }

  @Test(timeout = 4000)
  public void test07()  throws Throwable  {
      Recipe.Size recipe_Size0 = Recipe.Size.SMALL;
      Recipe recipe0 = new Recipe("{<KTn/K-.NuKgM", 434.3992266, recipe_Size0, 2732);
      Milk.Type milk_Type0 = Milk.Type.ALMOND;
      Milk milk0 = new Milk(2732, milk_Type0);
      recipe0.addIngredient(milk0);
      boolean boolean0 = recipe0.isReady();
      assertEquals(434.3992266, recipe0.getPrice(), 0.01);
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test08()  throws Throwable  {
      Recipe recipe0 = new Recipe("KzT,K(-iM", 1767.869958095486);
      Recipe.Size recipe_Size0 = Recipe.Size.REGULAR;
      Recipe recipe1 = new Recipe("Tc", 1767.869958095486, recipe_Size0, 0);
      boolean boolean0 = recipe1.equals(recipe0);
      assertFalse(recipe0.isReady());
      assertFalse(boolean0);
      assertEquals(1767.869958095486, recipe1.getPrice(), 0.01);
      assertTrue(recipe1.isReady());
  }

  @Test(timeout = 4000)
  public void test09()  throws Throwable  {
      Recipe.Size recipe_Size0 = Recipe.Size.REGULAR;
      Recipe recipe0 = new Recipe("<(l", (-1173.0), recipe_Size0, 2258);
      Water water0 = new Water(2258);
      recipe0.addIngredient(water0);
      recipe0.addIngredient(water0);
      assertEquals((-1173.0), recipe0.getPrice(), 0.01);
  }

  @Test(timeout = 4000)
  public void test10()  throws Throwable  {
      Recipe.Size recipe_Size0 = Recipe.Size.LARGE;
      Recipe recipe0 = new Recipe("", 3125.4112928631, recipe_Size0, 2840);
      double double0 = recipe0.getPrice();
      assertEquals(3125.4112928631, double0, 0.01);
  }

  @Test(timeout = 4000)
  public void test11()  throws Throwable  {
      Recipe recipe0 = new Recipe("KzT,K(-iM", 1767.869958095486);
      recipe0.hashCode();
      assertEquals(1767.869958095486, recipe0.getPrice(), 0.01);
  }

  @Test(timeout = 4000)
  public void test12()  throws Throwable  {
      Recipe.Size recipe_Size0 = Recipe.Size.SMALL;
      Recipe recipe0 = new Recipe("{<KTn/K-.NuKgM", 434.3992266, recipe_Size0, 2732);
      recipe0.getName();
      assertEquals(434.3992266, recipe0.getPrice(), 0.01);
  }
}
