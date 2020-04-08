package ru.stqa.pft.sandbox;

public class Point {

  int x;
  int y;
public Point (int x, int y) {
  this.x = x;
  this.y = y;
}


  public static double distance(Point p1, Point p2) {

    int x1 = p1.x;
    int x2 = p2.x;
    int y1 = p1.y;
    int y2 = p2.y;

    int d1 = x2 - x1;
    int d2 = y2 - y1;
    double pow = Math.pow(d1, 2) + Math.pow(d2, 2);
    return (Math.sqrt(pow));
  }
}
