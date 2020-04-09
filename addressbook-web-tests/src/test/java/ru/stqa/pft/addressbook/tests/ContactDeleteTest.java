package ru.stqa.pft.addressbook.tests;


import org.testng.annotations.*;
import org.openqa.selenium.*;

public class ContactDeleteTest extends TestBase {
//  private WebDriver driver;
//  private String baseUrl;
//  private boolean acceptNextAlert = true;
//  private StringBuffer verificationErrors = new StringBuffer();


  @Test
  public void testContactDelete() throws Exception {
    app.getContactHelper().selectContact();
    app.getContactHelper().initContactDeletion();
    app.getContactHelper().acceptContactDeletion();
//    app.getContactHelper().returnToHomePage();
  }

}
