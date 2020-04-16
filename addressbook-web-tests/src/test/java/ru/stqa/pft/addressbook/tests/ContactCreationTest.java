package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

public class ContactCreationTest extends TestBase {

  @Test(enabled = false)
  public void testContactCreation() throws InterruptedException {
    app.goTo().returnToHomePage();
    List<ContactData> before = app.contact().all();
    ContactData contact = new ContactData("Nadia6", "Hz", "group3");
    app.contact().createContact(contact);
    app.contact().waitForTablePresent();
    app.goTo().returnToHomePage();
    List<ContactData> after = app.contact().all();
    Assert.assertEquals(after.size(), before.size() + 1);
    before.add(contact);
    assertEquals(before, after);
  }
}
