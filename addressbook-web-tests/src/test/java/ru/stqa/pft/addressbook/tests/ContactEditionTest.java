package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactEditionTest extends TestBase {

  @Test
  public void testContactEdition() {
    if (! app.getContactHelper().isThereAnyContact()) {
      app.getContactHelper().createContact(new ContactData("gup1", null, "group1"));
    }
    app.getContactHelper().returnToHomePage();
    int before = app.getContactHelper().getContactsCount();
    app.getContactHelper().selectContact();
    app.getContactHelper().initiateContactEditing();
    app.getContactHelper().fillContactForm(new ContactData("group8", "group2", null), false);
    app.getContactHelper().updateEditedContactForm();
    app.getContactHelper().returnToHomePage();
    int after = app.getContactHelper().getContactsCount();
    Assert.assertEquals(after, before);
  }
}
