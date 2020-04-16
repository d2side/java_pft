package ru.stqa.pft.addressbook.appmanager;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

public class ContactHelper extends HelperBase {
  boolean acceptNextAlert = true;

  public ContactHelper(WebDriver driver) {
    super(driver);
  }





  public void submitContactCreation() {
    click(By.xpath("(//input[@name='submit'])[2]"));
  }

  public void fillContactForm(ContactData contactData, boolean creation) {
    type(By.name("firstname"), contactData.getFirstName());
//    type(By.name("lastname"), contactData.getLastName());

//    if (creation && contactData.getGroup() == null) {
//      new Select(driver.findElement(By.name("new_group"))).selectByVisibleText("[none]");
//    } else if (creation) {
//      new Select(driver.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
//    } else {
//      Assert.assertFalse(isElementPresent(By.name("new_group")));
//    }

  }

  public void initialContactCreation() {
    click(By.linkText("add new"));
  }

  public void submitGroupModification() {
    click(By.name("update"));
  }

  public void initiateContactEditing() {
    click(By.xpath("//img[@alt='Edit']"));
  }

  public void fillContactFormForEditing() {
    type(By.name("firstname"), "Alex");
    type(By.name("middlename"), "Valeryevich");
    type(By.name("lastname"), "Listec");
    type(By.name("nickname"), "Kirez");
    type(By.name("title"), "Chelik");
    type(By.name("company"), "Filmar");
  }

  public void updateEditedContactForm() {
    click(By.xpath("//input[@name='update'][2]"));
  }

  public void create(ContactData contactData) throws InterruptedException {
    initialContactCreation();
    fillContactForm(contactData, true);
    submitContactCreation();
    waitForTablePresent();
    returnToHomePage();
  }

  public boolean isThereAnyContact() {
    return isElementPresent(By.name("selected[]"));
  }

  public void selectContact(int index) {
    driver.findElements(By.name("selected[]")).get(index).click();
  }

  public void acceptContactDeletion() throws InterruptedException {
//    acceptNextAlert = true;
    isAlertPresent();
  }

  public void initContactDeletion() {
    click(By.xpath("//input[@value='Delete']"));
  }

  public int getContactsCount() {
    return driver.findElements(By.name("selected[]")).size();
  }

  public void modify(int index, ContactData contactData) throws InterruptedException {
    selectContact(index);
    initiateContactEditing();
    fillContactForm(contactData, false);
    updateEditedContactForm();
    returnToHomePage();
    waitForTablePresent();
  }
  public void delete(int index) throws InterruptedException {
    selectContact(index);
    initContactDeletion();
    acceptContactDeletion();
    waitForTablePresent();
  }

  public void returnToHomePage() {
    if (isElementPresent(By.linkText("home"))) {
      return;
    }
    click(By.linkText("home page"));
  }

  public List<ContactData> list() {
    List<ContactData> contacts = new ArrayList<ContactData>();
    List<WebElement> elements = driver.findElements(By.cssSelector("td.center input"));
    for (WebElement element : elements) {
//      String name = element.getAttribute("title").replaceAll("\\'(')'", "");
//      String lastName = element.getAttribute("title").replaceAll("\\'(')'", "");
      String b1 = "(";
      String b2 = ")";
      String name = element.getAttribute("title").replaceFirst("Select ", "").replace("(", "").replace(")", "");
//      String lastName = element.getAttribute("title").replaceFirst("Select ", "").replace("(", "").replace(")", "");
      String[] nameSplit = name.split(" ");
//      String[] lastnameSplit = name.split(" ");
      name = nameSplit[0];
//      lastName = lastnameSplit[1];
      ContactData contact = new ContactData(name, null);
      contacts.add(contact);
    }
    return contacts;
  }

  public void waitForTablePresent() throws InterruptedException {
    for (int second = 0; ; second++) {
      if (second >= 60) fail("timeout");
      try {
        if (isElementPresent(By.xpath("//table[@id='maintable']"))) break;
      } catch (Exception e) {
      }
      Thread.sleep(1000);
    }
  }
  }

