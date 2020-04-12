package ru.stqa.pft.addressbook.tests;


import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.*;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.List;

import static org.testng.Assert.fail;
import static org.testng.AssertJUnit.assertTrue;

public class ContactDeleteTest extends TestBase {
//  private WebDriver driver;
//  private String baseUrl;
//  private boolean acceptNextAlert = true;
//  private StringBuffer verificationErrors = new StringBuffer();


  @Test
  public void testContactDelete() throws Exception {
    if (! app.getContactHelper().isThereAnyContact()) {
      app.getContactHelper().createContact(new ContactData("gup1", null, "group1"));
    }
    for (int second = 0;; second++) {
      if (second >= 60) fail("timeout");
      try { if (! app.isElementPresent(By.xpath("//div[@class='msgbox']"))) break; } catch (Exception e) {}
      Thread.sleep(1000);
    }
    app.getContactHelper().returnToHomePage();
    List<ContactData> before = app.getContactHelper().getContactsList();
    app.getContactHelper().selectContact(before.size() - 1);
    app.getContactHelper().initContactDeletion();
    app.getContactHelper().acceptContactDeletion();
    for (int second = 0;; second++) {
      if (second >= 60) fail("timeout");
      try { if (! app.isElementPresent(By.xpath("//div[@class='msgbox']"))) break; } catch (Exception e) {}
      Thread.sleep(1000);
    }
    List<ContactData> after = app.getContactHelper().getContactsList();
    Assert.assertEquals(after.size(), before.size() - 1);

    before.remove(before.size() - 1);
    Assert.assertEquals(before, after);
  }

}
