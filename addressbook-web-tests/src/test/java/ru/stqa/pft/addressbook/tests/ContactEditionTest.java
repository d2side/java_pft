package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;

public class ContactEditionTest extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() throws Exception {
    if (app.contact().list().size() == 0) {
      app.contact().create(new ContactData("gup1", "group1"));
    }
    app.goTo().homePage();
  }

  @Test
  public void testContactEdition() throws InterruptedException {
    List<ContactData> before = app.contact().list();
    int index = before.size() - 1;
    ContactData contact = new ContactData("Nadia6", "group1");
    app.contact().modify(index, contact);
    List<ContactData> after = app.contact().list();
    Assert.assertEquals(after.size(), before.size());
    before.remove(index);
    before.add(contact);
    Assert.assertEquals(after, before);
  }


}
