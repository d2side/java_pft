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
  if (app.contact().list().size() == 0) {
    app.contact().create(new ContactData("gup1", "group1"));
  }
  app.goTo().homePage();
}

  @Test
  public void testContactDelete() throws Exception {
    app.contact().waitForTablePresent();
    app.goTo().homePage();
    List<ContactData> before = app.contact().list();
    int index = before.size() - 1;
    app.contact().delete(index);
    List<ContactData> after = app.contact().list();
    Assert.assertEquals(after.size(), before.size() - 1);
    before.remove(index);
    Assert.assertEquals(before, after);
  }



}
