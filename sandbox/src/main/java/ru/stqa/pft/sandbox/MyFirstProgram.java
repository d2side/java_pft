package ru.stqa.pft.sandbox;

public class MyFirstProgram {

  public static void main(String[] args) {
//    hello("Kirill");
//    hello("Alex");

    Square s = new Square(5);

    Rectangle r = new Rectangle(4, 8);

    System.out.println(s.area());
    System.out.println(r.area());
  }

//  static void hello(String name) {
//    System.out.println("Hello, " + name);
//  }


}
