package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactPhoneTest extends TestBase {
  @Test
  public void testContactPhones() {
    app.goTo().returnToHomePage();
    ContactData contact = app.contact().all().iterator().next();
  }
}
