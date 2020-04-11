package ru.stqa.pft.sandbox;

import java.sql.Struct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Collections {
  public static void main(String[] args) {
    String[] langs = {"Java", "C#", "Python", "PHP"};
//    for (int i = 0; i < langs.length; i++) {
//////      System.out.println("Пук, " + langs[i]);
////// }
//    List<String> languages = new ArrayList<String>();
//    languages.add("Java");
//    languages.add("C#");
//    languages.add("SQL");
    List<String> languages = Arrays.asList("Puk", "Пукк", "Бабадук");

//    for (String l : languages) {
//    System.out.println("Пук, " + l);
//    }
    for (int i = 0; i < languages.size(); i++) {
      System.out.println("Пук, " + languages.get(i));
    }
  }
}
