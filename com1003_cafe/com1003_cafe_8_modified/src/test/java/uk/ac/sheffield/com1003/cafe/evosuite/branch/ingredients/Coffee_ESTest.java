/*
 * This file was automatically generated by EvoSuite
 * Tue Sep 26 16:09:47 GMT 2023
 */

package uk.ac.sheffield.com1003.cafe.evosuite.branch.ingredients;

import org.junit.Test;
import static org.junit.Assert.*;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.runner.RunWith;
import uk.ac.sheffield.com1003.cafe.ingredients.Coffee;
import uk.ac.sheffield.com1003.cafe.ingredients.Unit;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true) 
public class Coffee_ESTest extends Coffee_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test0()  throws Throwable  {
      Coffee coffee0 = new Coffee(2);
      Coffee coffee1 = new Coffee(2, true);
      boolean boolean0 = coffee0.equals(coffee1);
      assertEquals("Coffee", coffee1.getName());
      assertEquals(2, coffee1.getAmount());
      assertFalse(boolean0);
      assertTrue(coffee1.getDecaf());
  }

  @Test(timeout = 4000)
  public void test1()  throws Throwable  {
      Coffee coffee0 = new Coffee();
      Coffee coffee1 = new Coffee();
      boolean boolean0 = coffee1.equals(coffee0);
      assertTrue(boolean0);
      assertEquals("Coffee", coffee1.getName());
      assertFalse(coffee1.getDecaf());
      assertEquals(8, coffee1.getAmount());
  }

  @Test(timeout = 4000)
  public void test2()  throws Throwable  {
      Coffee coffee0 = new Coffee(2);
      Coffee coffee1 = new Coffee((-3146));
      boolean boolean0 = coffee1.equals(coffee0);
      assertFalse(boolean0);
      assertFalse(coffee1.getDecaf());
      assertEquals("Coffee", coffee1.getName());
      assertFalse(coffee0.equals((Object)coffee1));
      assertEquals((-3146), coffee1.getAmount());
  }

  @Test(timeout = 4000)
  public void test3()  throws Throwable  {
      Coffee coffee0 = new Coffee();
      assertEquals("Coffee", coffee0.getName());
      
      Coffee coffee1 = new Coffee();
      boolean boolean0 = coffee0.equals(coffee1);
      assertTrue(boolean0);
  }

  @Test(timeout = 4000)
  public void test4()  throws Throwable  {
      Coffee coffee0 = new Coffee(2);
      boolean boolean0 = coffee0.equals(coffee0);
      assertEquals("Coffee", coffee0.getName());
      assertEquals(2, coffee0.getAmount());
      assertFalse(coffee0.getDecaf());
      assertTrue(boolean0);
  }

  @Test(timeout = 4000)
  public void test5()  throws Throwable  {
      Coffee coffee0 = new Coffee(2);
      boolean boolean0 = coffee0.equals((Object) null);
      assertFalse(coffee0.getDecaf());
      assertEquals("Coffee", coffee0.getName());
      assertFalse(boolean0);
      assertEquals(2, coffee0.getAmount());
  }

  @Test(timeout = 4000)
  public void test6()  throws Throwable  {
      Coffee coffee0 = new Coffee(2);
      String string0 = coffee0.toString();
      assertEquals("Coffee [unit=GR, amount=2, decaf=false]", string0);
      assertEquals("Coffee", coffee0.getName());
  }
}
