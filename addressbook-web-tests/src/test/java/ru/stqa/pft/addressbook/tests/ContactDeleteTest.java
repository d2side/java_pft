package ru.stqa.pft.addressbook.tests;


import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;

import static org.testng.Assert.fail;
import static org.testng.AssertJUnit.assertTrue;

public class ContactDeleteTest extends TestBase {
//  private WebDriver driver;
//  private String baseUrl;
//  private boolean acceptNextAlert = true;
//  private StringBuffer verificationErrors = new StringBuffer();
@BeforeMethod
public void ensurePreconditions() throws Exception {
  if (! app.contact().isThereAnyContact()) {
    app.contact().createContact(new ContactData("gup1", "group1"));
  }
  app.goTo().returnToHomePage();
}

  @Test
  public void testContactDelete() throws Exception {
    app.contact().waitForTablePresent();
    app.goTo().returnToHomePage();
    List<ContactData> before = app.contact().getContactsList();
    int index = before.size() - 1;
    app.contact().deleteSelectedContact(index);
    List<ContactData> after = app.contact().getContactsList();
    Assert.assertEquals(after.size(), before.size() - 1);
    before.remove(index);
    Assert.assertEquals(before, after);
  }



}
