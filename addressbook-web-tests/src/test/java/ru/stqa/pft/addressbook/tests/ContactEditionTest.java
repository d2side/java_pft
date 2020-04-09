package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

public class ContactEditionTest extends TestBase {

  @Test
  public void testContactEdition() {
    if (! app.getContactHelper().isThereAnyContact()) {
      app.getContactHelper().createContact(new ContactData("group1", null, "group1"));
    }
    app.getContactHelper().initiateContactEditing();
    app.getContactHelper().fillContactForm(new ContactData("group7", "group1", "group1"), false);
    app.getContactHelper().updateEditedContactForm();
    app.getContactHelper().returnToHomePage();
  }
}
