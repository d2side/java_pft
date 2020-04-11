package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTest extends TestBase {

  @Test
  public void testContactCreation() throws Exception {
    int before = app.getContactHelper().countContacts();
    app.getContactHelper().returnToHomePage();
    app.getContactHelper().createContact(new ContactData("Nadia6", "Hz", "group3"));
    app.getContactHelper().returnToHomePage();
    int after = app.getContactHelper().countContacts();
    Assert.assertEquals(after, before + 1);
  }

}
