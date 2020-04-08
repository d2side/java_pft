package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.*;
import org.testng.annotations.Test;

public class ContactCreationTest extends TestBase {

  @Test
  public void testContactCreation() throws Exception {
    app.getContactHelper().initialContactCreation();
    app.getContactHelper().fillContactForm();
    app.getContactHelper().submitContactCreation();
    app.getContactHelper().returnToHomePage();
  }

}
