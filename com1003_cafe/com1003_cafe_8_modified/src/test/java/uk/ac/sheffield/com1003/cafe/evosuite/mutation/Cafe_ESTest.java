/*
 * This file was automatically generated by EvoSuite
 * Wed Sep 27 21:37:24 GMT 2023
 */

package uk.ac.sheffield.com1003.cafe.evosuite.mutation;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.runtime.EvoAssertions.*;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.runner.RunWith;
import uk.ac.sheffield.com1003.cafe.Cafe;
import uk.ac.sheffield.com1003.cafe.Order;
import uk.ac.sheffield.com1003.cafe.Recipe;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true) 
public class Cafe_ESTest extends Cafe_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
      Cafe cafe0 = new Cafe("", 44, 44);
      Recipe recipe0 = new Recipe("", 44);
      cafe0.addRecipe(recipe0);
      boolean boolean0 = cafe0.placeOrder("", "", 44);
      assertEquals(1, cafe0.getIndexNextOrderToPlace());
      assertTrue(boolean0);
  }

  @Test(timeout = 4000)
  public void test01()  throws Throwable  {
      Cafe cafe0 = new Cafe();
      Recipe.Size recipe_Size0 = Recipe.Size.REGULAR;
      Recipe recipe0 = new Recipe("ALMOND", 0.0, recipe_Size0, 3175);
      cafe0.addRecipe(recipe0);
      cafe0.addRecipe(recipe0);
      cafe0.removeRecipe("ALMOND");
      Recipe[] recipeArray0 = cafe0.getMenu();
      assertEquals(1, recipeArray0.length);
      assertEquals(0, cafe0.getIndexNextOrderToPlace());
      assertEquals(0, cafe0.getIndexNextOrderToServe());
  }

  @Test(timeout = 4000)
  public void test02()  throws Throwable  {
      Cafe cafe0 = new Cafe();
      Recipe recipe0 = new Recipe("Cafe", 0.0);
      cafe0.addRecipe(recipe0);
      cafe0.placeOrder("Cafe", ", type=", 4.0);
      cafe0.serveOrder();
      assertEquals(1, cafe0.getIndexNextOrderToPlace());
  }

  @Test(timeout = 4000)
  public void test03()  throws Throwable  {
      Cafe cafe0 = new Cafe("Welcome to ", 0, 0);
      cafe0.serveOrder();
      assertEquals(0, cafe0.getIndexNextOrderToPlace());
      assertEquals(0, cafe0.getIndexNextOrderToServe());
  }

  @Test(timeout = 4000)
  public void test04()  throws Throwable  {
      Cafe cafe0 = new Cafe();
      cafe0.serveOrder();
      assertEquals(0, cafe0.getIndexNextOrderToServe());
      assertEquals(0, cafe0.getIndexNextOrderToPlace());
  }

  @Test(timeout = 4000)
  public void test05()  throws Throwable  {
      Cafe cafe0 = new Cafe();
      Recipe recipe0 = new Recipe("Ac)lZNowV?W@xEFPR0", (-527.29627));
      cafe0.addRecipe(recipe0);
      try { 
        cafe0.placeOrder((String) null, "Ac)lZNowV?W@xEFPR0", (-527.29627));
        fail("Expecting exception: Exception");
      
      } catch(Exception e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("uk.ac.sheffield.com1003.cafe.Cafe", e);
      }
  }

  @Test(timeout = 4000)
  public void test06()  throws Throwable  {
      Cafe cafe0 = new Cafe("Cafe");
      Recipe.Size recipe_Size0 = Recipe.Size.REGULAR;
      Recipe recipe0 = new Recipe("Cafe", 0.0, recipe_Size0, 8);
      boolean boolean0 = cafe0.addRecipe(recipe0);
      boolean boolean1 = cafe0.placeOrder("Cafe", "Cafe", (-747.2583));
      assertFalse(boolean1 == boolean0);
      assertEquals(0, cafe0.getIndexNextOrderToPlace());
      assertEquals(0, cafe0.getIndexNextOrderToServe());
      assertFalse(boolean1);
  }

  @Test(timeout = 4000)
  public void test07()  throws Throwable  {
      Cafe cafe0 = new Cafe("", 0, 0);
      try { 
        cafe0.placeOrder("", "772\"OhEA_kwtHc", 1.0);
        fail("Expecting exception: Exception");
      
      } catch(Exception e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("uk.ac.sheffield.com1003.cafe.Cafe", e);
      }
  }

  @Test(timeout = 4000)
  public void test08()  throws Throwable  {
      Cafe cafe0 = new Cafe();
      Recipe.Size recipe_Size0 = Recipe.Size.REGULAR;
      Recipe recipe0 = new Recipe("ALMOND", 0.0, recipe_Size0, 3175);
      boolean boolean0 = cafe0.addRecipe(recipe0);
      assertTrue(boolean0);
      
      cafe0.printMenu();
      assertEquals(0, cafe0.getIndexNextOrderToServe());
      assertEquals(0, cafe0.getIndexNextOrderToPlace());
  }

  @Test(timeout = 4000)
  public void test09()  throws Throwable  {
      Cafe cafe0 = new Cafe();
      Recipe.Size recipe_Size0 = Recipe.Size.REGULAR;
      Recipe recipe0 = new Recipe("ALMOND", 0.0, recipe_Size0, 3175);
      cafe0.addRecipe(recipe0);
      cafe0.placeOrder("ALMOND", "ALMOND", 2919.1925601);
      cafe0.printPendingOrders();
      assertEquals(1, cafe0.getIndexNextOrderToPlace());
  }

  @Test(timeout = 4000)
  public void test10()  throws Throwable  {
      Cafe cafe0 = new Cafe("", 0, 0);
      cafe0.printPendingOrders();
      assertEquals(0, cafe0.getIndexNextOrderToServe());
      assertEquals(0, cafe0.getIndexNextOrderToPlace());
  }

  @Test(timeout = 4000)
  public void test11()  throws Throwable  {
      Cafe cafe0 = new Cafe();
      Recipe.Size recipe_Size0 = Recipe.Size.REGULAR;
      Recipe recipe0 = new Recipe("Cafe", 0.0, recipe_Size0, 4);
      cafe0.addRecipe(recipe0);
      try { 
        cafe0.removeRecipe((String) null);
        fail("Expecting exception: Exception");
      
      } catch(Exception e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("uk.ac.sheffield.com1003.cafe.Cafe", e);
      }
  }

  @Test(timeout = 4000)
  public void test12()  throws Throwable  {
      Cafe cafe0 = new Cafe("", 0, 0);
      int int0 = cafe0.getIndexNextOrderToServe();
      assertEquals(0, int0);
      assertEquals(0, cafe0.getIndexNextOrderToPlace());
  }

  @Test(timeout = 4000)
  public void test13()  throws Throwable  {
      Cafe cafe0 = new Cafe("Welcome to ", 0, 0);
      Order[] orderArray0 = cafe0.getOrders();
      assertEquals(0, cafe0.getIndexNextOrderToPlace());
      assertEquals(0, cafe0.getIndexNextOrderToServe());
      assertEquals(0, orderArray0.length);
  }

  @Test(timeout = 4000)
  public void test14()  throws Throwable  {
      Cafe cafe0 = new Cafe("AQnb_fCO1_");
      int int0 = cafe0.getIndexNextOrderToPlace();
      assertEquals(0, cafe0.getIndexNextOrderToServe());
      assertEquals(0, int0);
  }
}
