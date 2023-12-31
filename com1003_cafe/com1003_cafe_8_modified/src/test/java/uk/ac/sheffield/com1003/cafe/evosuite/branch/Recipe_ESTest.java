/*
 * This file was automatically generated by EvoSuite
 * Tue Sep 26 15:57:04 GMT 2023
 */

package uk.ac.sheffield.com1003.cafe.evosuite.branch;

import org.junit.Test;
import static org.junit.Assert.*;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.runner.RunWith;
import uk.ac.sheffield.com1003.cafe.Recipe;
import uk.ac.sheffield.com1003.cafe.ingredients.Coffee;
import uk.ac.sheffield.com1003.cafe.ingredients.Syrup;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true) 
public class Recipe_ESTest extends Recipe_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
      Recipe.Size recipe_Size0 = Recipe.Size.LARGE;
      Recipe recipe0 = new Recipe("", 0, recipe_Size0, 0);
      Recipe recipe1 = new Recipe("", 0, recipe_Size0, 0);
      boolean boolean0 = recipe0.equals(recipe1);
      assertTrue(boolean0);
      assertEquals(0.0, recipe1.getPrice(), 0.01);
  }

  @Test(timeout = 4000)
  public void test01()  throws Throwable  {
      Recipe.Size recipe_Size0 = Recipe.Size.REGULAR;
      Recipe recipe0 = new Recipe((String) null, 0, recipe_Size0, 0);
      Recipe recipe1 = new Recipe((String) null, 0);
      boolean boolean0 = recipe0.equals(recipe1);
      assertTrue(recipe0.isReady());
      assertEquals(0.0, recipe1.getPrice(), 0.01);
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test02()  throws Throwable  {
      Recipe.Size recipe_Size0 = Recipe.Size.SMALL;
      Recipe recipe0 = new Recipe("[", 0, recipe_Size0, 0);
      Recipe recipe1 = new Recipe("[", 0);
      boolean boolean0 = recipe0.equals(recipe1);
      assertFalse(boolean0);
      assertTrue(recipe0.isReady());
      assertEquals(0.0, recipe1.getPrice(), 0.01);
  }

  @Test(timeout = 4000)
  public void test03()  throws Throwable  {
      Recipe recipe0 = new Recipe("hGK1Y,5(2t}*$X]X\"p", (-3407.419816967975));
      Recipe recipe1 = new Recipe("hGK1Y,5(2t}*$X]X\"p", (-1.0));
      boolean boolean0 = recipe0.equals(recipe1);
      assertFalse(boolean0);
      assertEquals((-1.0), recipe1.getPrice(), 0.01);
  }

  @Test(timeout = 4000)
  public void test04()  throws Throwable  {
      Recipe.Size recipe_Size0 = Recipe.Size.REGULAR;
      Recipe recipe0 = new Recipe(">H$qb=B)", 0, recipe_Size0, 1);
      Object object0 = new Object();
      boolean boolean0 = recipe0.equals(object0);
      assertFalse(boolean0);
      assertEquals(0.0, recipe0.getPrice(), 0.01);
  }

  @Test(timeout = 4000)
  public void test05()  throws Throwable  {
      Recipe recipe0 = new Recipe("REGUAR", 224.5);
      boolean boolean0 = recipe0.equals(recipe0);
      assertEquals(224.5, recipe0.getPrice(), 0.01);
      assertTrue(boolean0);
  }

  @Test(timeout = 4000)
  public void test06()  throws Throwable  {
      Recipe.Size recipe_Size0 = Recipe.Size.REGULAR;
      Recipe recipe0 = new Recipe(">H$qb=B)", 0, recipe_Size0, 1);
      assertFalse(recipe0.isReady());
      
      Recipe recipe1 = new Recipe(">H$qb=B)", 0, recipe_Size0, 0);
      Coffee coffee0 = new Coffee();
      recipe0.addIngredient(coffee0);
      boolean boolean0 = recipe0.equals(recipe1);
      assertTrue(recipe0.isReady());
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test07()  throws Throwable  {
      Recipe recipe0 = new Recipe("", 0.0);
      Syrup syrup0 = new Syrup("");
      recipe0.addIngredient(syrup0);
      recipe0.addIngredient(syrup0);
      assertEquals(0.0, recipe0.getPrice(), 0.01);
  }

  @Test(timeout = 4000)
  public void test08()  throws Throwable  {
      Recipe recipe0 = new Recipe("E:j", (-1.0));
      double double0 = recipe0.getPrice();
      assertEquals((-1.0), double0, 0.01);
  }

  @Test(timeout = 4000)
  public void test09()  throws Throwable  {
      Recipe.Size recipe_Size0 = Recipe.Size.REGULAR;
      Recipe recipe0 = new Recipe(">H$qb=B)", 0, recipe_Size0, 1);
      recipe0.hashCode();
      assertEquals(0.0, recipe0.getPrice(), 0.01);
  }

  @Test(timeout = 4000)
  public void test10()  throws Throwable  {
      Recipe recipe0 = new Recipe("REGULAR", 233.88846185989138);
      Recipe recipe1 = new Recipe("REGULAR", 233.88846185989138);
      assertFalse(recipe1.isReady());
      
      boolean boolean0 = recipe1.equals(recipe0);
      assertFalse(boolean0);
      assertEquals(233.88846185989138, recipe1.getPrice(), 0.01);
  }

  @Test(timeout = 4000)
  public void test11()  throws Throwable  {
      Recipe.Size recipe_Size0 = Recipe.Size.LARGE;
      Recipe recipe0 = new Recipe("(M+", 1101.938457543503, recipe_Size0, 0);
      recipe0.getName();
      assertEquals(1101.938457543503, recipe0.getPrice(), 0.01);
      assertTrue(recipe0.isReady());
  }
}
