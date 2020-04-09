package ru.stqa.pft.addressbook.tests;


import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import ru.stqa.pft.addressbook.appmanager.ContactHelper;
import ru.stqa.pft.addressbook.appmanager.GroupHelper;
import ru.stqa.pft.addressbook.appmanager.NavigationHelper;
import ru.stqa.pft.addressbook.appmanager.SessionHelper;

public class ContactDeleteTest {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Test
  public void testContactDelete() throws Exception {
    driver.get("http://localhost/addressbook/");
    driver.findElement(By.name("selected[]")).click();
    initContactDeletion();
    acceptContactDeletion();
  }

  private void acceptContactDeletion() {
    driver.switchTo().alert().accept();
  }

  private void initContactDeletion() {
    acceptNextAlert = true;
    driver.findElement(By.xpath("//input[@value='Delete']")).click();
  }

  private String closeAlertAndGetItsText() {
    return null;
  }


  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }
  @AfterClass(alwaysRun = true)
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

}
