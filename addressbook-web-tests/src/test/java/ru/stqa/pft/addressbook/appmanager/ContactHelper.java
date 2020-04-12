package ru.stqa.pft.addressbook.appmanager;
import java.util.ArrayList;
import java.util.List;
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

public class ContactHelper extends HelperBase {
  boolean acceptNextAlert = true;

  public ContactHelper(WebDriver driver) {
    super(driver);
  }


  public void returnToHomePage() {
    if (isElementPresent(By.linkText("home"))) {
      return;
    }
    click(By.linkText("home page"));
    }



  public void submitContactCreation() {
    click(By.xpath("(//input[@name='submit'])[2]"));
  }

  public void fillContactForm(ContactData contactData, boolean creation) {
    type(By.name("firstname"), contactData.getFirstName());
    type(By.name("lastname"), contactData.getLastName());

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

  public void createContact(ContactData contactData) {
   initialContactCreation();
    fillContactForm(contactData,  true);
    submitContactCreation();
  }

  public boolean isThereAnyContact() {
    return isElementPresent(By.name("selected[]"));
  }

  public void selectContact() {
    click(By.name("selected[]"));
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

  public List<ContactData> getContactsList() {
    List<ContactData> contacts = new ArrayList<ContactData>();
    List<WebElement> elements = driver.findElements(By.cssSelector("td.center input"));
    for (WebElement element : elements) {
//      String name = element.getAttribute("title").replaceAll("\\'(')'", "");
//      String lastName = element.getAttribute("title").replaceAll("\\'(')'", "");
      String b1 = "(";
      String b2 = ")";
      String name = element.getAttribute("title").replaceFirst("Select ", "").replace("(", "").replace(")", "");
      String lastName = element.getAttribute("title").replaceFirst("Select ", "").replace("(", "").replace(")", "");
      ContactData contact = new ContactData(name, lastName, null);
      contacts.add(contact);
    }
    return contacts;
  }
}
