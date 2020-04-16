package ru.stqa.pft.addressbook.tests;


import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

import static org.testng.Assert.fail;
import static org.testng.AssertJUnit.assertTrue;

public class ContactDeleteTest extends TestBase {
//  private WebDriver driver;
//  private String baseUrl;
//  private boolean acceptNextAlert = true;
//  private StringBuffer verificationErrors = new StringBuffer();


  @Test(enabled = false)
  public void testContactDelete() throws Exception {
    if (! app.contact().isThereAnyContact()) {
      app.contact().createContact(new ContactData("gup1", null, "group1"));
    }
    app.contact().waitForTablePresent();
    app.goTo().returnToHomePage();
    List<ContactData> before = app.contact().all();
    app.contact().selectContact();
    app.contact().initContactDeletion();
    app.contact().acceptContactDeletion();
    app.contact().waitForTablePresent();
    List<ContactData> after = app.contact().all();
    Assert.assertEquals(after.size(), before.size() - 1);
    before.remove(before.size() - 1);
    Assert.assertEquals(before, after);
  }

}
