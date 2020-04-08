package ru.stqa.pft.sandbox;

import static org.testng.AssertJUnit.assertEquals;
import org.testng.annotations.Test;

public class EquationTest {

  @Test
    public void test0() {
    Equation e = new Equation(1, 2, 1) ;
    assertEquals(e.rootNumber(), 1);
  }

  @Test
  public void test1() {
    Equation e = new Equation(1, 5, 6) ;
    assertEquals(e.rootNumber(), 2);
  }

}
