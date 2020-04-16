package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactPhoneTest extends TestBase {

  @Test(enabled = false)
  public void testContactPhones() {
    app.goTo().returnToHomePage();
    ContactData contact = app.contact().getContactsList().iterator().next();
//    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
  }
}
