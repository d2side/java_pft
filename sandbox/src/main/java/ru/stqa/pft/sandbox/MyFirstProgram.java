package ru.stqa.pft.sandbox;

public class MyFirstProgram {


  public static void main(String[] args) {
    Point a = new Point(7, 9);
    Point b = new Point(21, 17);
    double i =  Point.distance(a, b);
    System.out.println(i);

  }

}
