package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SessionHelper {
  private WebDriver driver;

  public SessionHelper(WebDriver driver) {
    this.driver = driver;
  }

  public void login(String admin, String secret) {
    driver.findElement(By.name("user")).clear();
    driver.findElement(By.name("user")).sendKeys(admin);
    driver.findElement(By.name("pass")).click();
    driver.findElement(By.name("pass")).clear();
    driver.findElement(By.name("pass")).sendKeys(secret);
    driver.findElement(By.xpath("//input[@value='Login']")).click();
  }
}
