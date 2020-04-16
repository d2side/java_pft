package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class ContactEditionTest extends TestBase {

  @Test(enabled = false)
  public void testContactEdition() throws InterruptedException {
    if (! app.contact().isThereAnyContact()) {
      app.contact().createContact(new ContactData("gup1", null, "group1"));
    }
    app.goTo().returnToHomePage();
    List<ContactData> before = app.contact().all();
    app.contact().selectContact();
    app.contact().initiateContactEditing();
    ContactData contact = new ContactData("Nadia6", "Hz", "group1");
    app.contact().fillContactForm(contact, false);
    app.contact().updateEditedContactForm();
    app.goTo().returnToHomePage();
    app.contact().waitForTablePresent();
    List<ContactData> after = app.contact().all();
    Assert.assertEquals(after.size(), before.size());
    before.remove(before.size() - 1);
    before.add(contact);
    Assert.assertEquals(after, before);
  }
}
