package ru.stqa.pft.addressbook.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.HashSet;
import java.util.List;

import static org.testng.Assert.fail;

public class ContactCreationTest extends TestBase {

  @Test
  public void testContactCreation() throws InterruptedException {
    app.getContactHelper().returnToHomePage();
    List<ContactData> before = app.getContactHelper().getContactsList();
    ContactData contact = new ContactData("Nadia6", "Hz", "group3");
    app.getContactHelper().createContact(contact);
    app.getContactHelper().returnToHomePage();
    for (int second = 0;; second++) {
      if (second >= 60) fail("timeout");
      try { if (! app.isElementPresent(By.xpath("//div[@class='msgbox']"))) break; } catch (Exception e) {}
      Thread.sleep(1000);
    }
    List<ContactData> after = app.getContactHelper().getContactsList();
    Assert.assertEquals(after.size(), before.size() + 1);
    before.add(contact);

//    Assert.assertEquals(new HashSet<>(after), new HashSet<>(before));
  }
}
