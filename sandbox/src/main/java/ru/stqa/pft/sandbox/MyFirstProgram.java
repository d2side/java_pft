package ru.stqa.pft.sandbox;

public class MyFirstProgram {

  public static void main(String[] args) {
    hello("Kirill");
    hello("Alex");

    double l = eq(7);

    System.out.println(l);
    System.out.println(eq(9, 7));
  }

  static void hello(String name) {
    System.out.println("Hello, " + name);
  }

  public static double eq(double l) {
    return l * l;
  }
  public static double eq(double l, double b) {
    return l * b;
  }
}
