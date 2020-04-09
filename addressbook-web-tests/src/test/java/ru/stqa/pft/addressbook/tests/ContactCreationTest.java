package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.*;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTest extends TestBase {

  @Test
  public void testContactCreation() throws Exception {
    app.getContactHelper().createContact(new ContactData("Nadia", "Hz", "group1"));
  }

}
