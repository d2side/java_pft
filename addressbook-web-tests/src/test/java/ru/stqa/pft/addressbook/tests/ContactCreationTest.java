package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.*;

public class ContactCreationTest extends TestBase {

  @Test
  public void testContactCreation() throws Exception {
    applicationManager.getContactHelper().initialContactCreation();
    applicationManager.getContactHelper().fillContactForm();
    applicationManager.getContactHelper().submitContactCreation();
    applicationManager.getContactHelper().returnToHomePage();
  }

}
