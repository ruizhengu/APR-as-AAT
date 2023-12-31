/*
 * This file was automatically generated by EvoSuite
 * Tue Sep 26 17:21:34 GMT 2023
 */

package uk.ac.sheffield.com1003.cafe.evosuite.branch.ingredients;

import org.junit.Test;
import static org.junit.Assert.*;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.runner.RunWith;
import uk.ac.sheffield.com1003.cafe.ingredients.Coffee;
import uk.ac.sheffield.com1003.cafe.ingredients.Syrup;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true) 
public class Ingredient_ESTest extends Ingredient_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test0()  throws Throwable  {
      Syrup syrup0 = new Syrup();
      Coffee coffee0 = new Coffee(179);
      boolean boolean0 = syrup0.equals(coffee0);
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test1()  throws Throwable  {
      Syrup syrup0 = new Syrup("2pha;,T,utg;oL?sj");
      boolean boolean0 = syrup0.equals("2pha;,T,utg;oL?sj");
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test2()  throws Throwable  {
      Syrup syrup0 = new Syrup();
      boolean boolean0 = syrup0.equals((Object) null);
      assertFalse(boolean0);
  }
}
