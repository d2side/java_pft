package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stqa.pft.addressbook.tests.TestBase;

public class ContactHelper extends HelperBase {
  WebDriver driver;

  public ContactHelper(WebDriver driver) {
    super(driver);
  }

  public void returnToHomePage() {
    click(By.linkText("home page"));
  }

  public void submitContactCreation() {
    click(By.xpath("(//input[@name='submit'])[2]"));
  }

  public void fillContactForm() {
    type(By.name("firstname"), "Kir");
    type(By.name("middlename"), "Mak");
    type(By.name("lastname"), "Lik");
    type(By.name("nickname"), "DS");
    type(By.name("title"), "QA Automation engineer");
    type(By.name("company"), "R4");
  }

  public void initialContactCreation() {
    click(By.linkText("add new"));
    click(By.xpath("//a[contains(text(),'add new')]"));
  }

  public void submitGroupModification() {
    click(By.name("update"));
  }
}
