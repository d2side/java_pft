package ru.stqa.pft.addressbook.tests;


import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.*;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;

import static org.testng.Assert.fail;
import static org.testng.AssertJUnit.assertTrue;

public class ContactDeleteTest extends TestBase {
//  private WebDriver driver;
//  private String baseUrl;
//  private boolean acceptNextAlert = true;
//  private StringBuffer verificationErrors = new StringBuffer();


  @Test(enabled = false)
  public void testContactDelete() throws Exception {
    if (! app.getContactHelper().isThereAnyContact()) {
      app.getContactHelper().createContact(new ContactData("gup1", null, "group1"));
    }
    app.getContactHelper().waitForTablePresent();
    app.getContactHelper().returnToHomePage();
    List<ContactData> before = app.getContactHelper().getContactsList();
    app.getContactHelper().selectContact();
    app.getContactHelper().initContactDeletion();
    app.getContactHelper().acceptContactDeletion();
    app.getContactHelper().waitForTablePresent();
    List<ContactData> after = app.getContactHelper().getContactsList();
    Assert.assertEquals(after.size(), before.size() - 1);
    before.remove(before.size() - 1);
    Comparator<? super ContactData> byName = (c1, c2) -> CharSequence.compare(c1.getFirstName(), c2.getFirstName());
    before.sort(byName);
    after.sort(byName);
    Assert.assertEquals(before, after);
  }

}
