package ru.stqa.pft.sandbox;

import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;


public class PointTests1 {

  @Test
  public void testSqrt() {
    Point a = new Point(2,8);
    Point b = new Point(3, 13);
    double i =  Point.distance(a, b);
    double exp = 5.0990195135927845;
    assertEquals(i, exp);
  }

  @Test
  public void testSqrt1() {
    Point a = new Point(5,9);
    Point b = new Point(12, 11);
    double i =  Point.distance(a, b);
    double exp = 7.280109889280518;
    assertEquals(i, exp);
  }

  @Test
  public void testLinear() {
    Equation e = new Equation(0, 1, 1);
    assertEquals(e.rootNumber(), 1);
  }

  @Test
  public void testConstant() {
    Equation e = new Equation(0, 0, 1);
    assertEquals(e.rootNumber(), 0);
  }

  @Test
  public void testZero() {
    Equation e = new Equation(0, 0, 0);
    assertEquals(e.rootNumber(), -1);
  }


}
