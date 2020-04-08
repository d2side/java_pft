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

}
