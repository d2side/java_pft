package ru.stqa.pft.sandbox;

import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;


public class PointTests2 {


  @Test
  public void testSqrt() {
    Point a = new Point(5,9);
    Point b = new Point(12, 11);
    double i =  Point.distance(a, b);
    double exp = 7.280109889280518;
    assertEquals(i, exp);
  }
}
