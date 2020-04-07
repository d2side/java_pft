package ru.stqa.pft.addressbook;

import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
//import org.testng.annotations.Test;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GroupCreationTest {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "https://www.google.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    driver.get("http://localhost/addressbook/group.php");
    login("admin", "secret");
  }

  private void login(String admin, String secret) {
    driver.findElement(By.name("user")).clear();
    driver.findElement(By.name("user")).sendKeys(admin);
    driver.findElement(By.name("pass")).click();
    driver.findElement(By.name("pass")).clear();
    driver.findElement(By.name("pass")).sendKeys(secret);
    driver.findElement(By.xpath("//input[@value='Login']")).click();
  }

  @Test
  public void testGroupCreation() throws Exception {
    goToGroupPage("groups");
    initGroupCreation("new");
    fillGroupForm(new GroupData("group1", "group1", "group1"));
    submitGroupCreation("submit");
    returnToGroupPage();
  }

  private void returnToGroupPage() {
    driver.findElement(By.linkText("group page")).click();
  }

  private void submitGroupCreation(String submit) {
    driver.findElement(By.name(submit)).click();
  }

  private void fillGroupForm(GroupData groupData) {
    driver.findElement(By.name("group_name")).click();
    driver.findElement(By.name("group_name")).clear();
    driver.findElement(By.name("group_name")).sendKeys(groupData.getName());
    driver.findElement(By.name("group_header")).click();
    driver.findElement(By.name("group_header")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [doubleClick | name=group_header | ]]
    driver.findElement(By.name("group_header")).clear();
    driver.findElement(By.name("group_header")).sendKeys(groupData.getHeader());
    driver.findElement(By.name("group_footer")).click();
    driver.findElement(By.name("group_footer")).clear();
    driver.findElement(By.name("group_footer")).sendKeys(groupData.getFooter());
  }

  private void initGroupCreation(String s) {
    driver.findElement(By.name(s)).click();
  }

  private void goToGroupPage(String groups) {
    driver.findElement(By.linkText(groups)).click();
  }

  @AfterClass(alwaysRun = true)
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
