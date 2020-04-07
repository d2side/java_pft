package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupHelper {


  public WebDriver driver;

  public GroupHelper(WebDriver driver) {
    this.driver = driver;
  }

  public void returnToGroupPage() {
    driver.findElement(By.linkText("group page")).click();
  }

  public void submitGroupCreation() {
    driver.findElement(By.name("submit")).click();
  }

  public void fillGroupForm(GroupData groupData) {
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

  public void initGroupCreation() {
    driver.findElement(By.name("new")).click();
  }

  public void goToGroupPage() {
    driver.findElement(By.linkText("groups")).click();
  }

  public void deleteSelectedGroup(By xpath) {
    driver.findElement(xpath).click();
  }

  public void selectGroup(By name) {
    driver.findElement(name).click();
  }
}
