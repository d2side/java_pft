package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

public class ContactCreationTest extends TestBase {

  @Test
  public void testContactCreation() throws Exception {
    app.goTo().returnToHomePage();
    List<ContactData> before = app.contact().getContactsList();
    ContactData contact = new ContactData("Nadia6", "group3");
    app.contact().createContact(contact);
    List<ContactData> after = app.contact().getContactsList();
    Assert.assertEquals(after.size(), before.size() + 1);
    before.add(contact);
    assertEquals(before, after);
  }
}
