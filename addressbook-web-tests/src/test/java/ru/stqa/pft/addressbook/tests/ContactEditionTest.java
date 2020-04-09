package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactEditionTest extends TestBase {

  @Test
  public void testContactEdition() {
    app.getContactHelper().initiateContactEditing();
    app.getContactHelper().fillContactForm(new ContactData("group1", "group1", null));
    app.getContactHelper().updateEditedContactForm();
    app.getContactHelper().returnToHomePage();
  }
}
