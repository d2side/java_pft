package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTest extends TestBase {

  @Test
  public void testContactCreation() {
    int before = app.getContactHelper().getContactsCount();
    app.getContactHelper().returnToHomePage();
    app.getContactHelper().createContact(new ContactData("Nadia6", "Hz", "group3"));
    app.getContactHelper().returnToHomePage();
    int after = app.getContactHelper().getContactsCount();
    Assert.assertEquals(after, before + 1);
  }

}
