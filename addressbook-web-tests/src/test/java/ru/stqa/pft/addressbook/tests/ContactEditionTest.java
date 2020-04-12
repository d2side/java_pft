package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;

public class ContactEditionTest extends TestBase {

  @Test
  public void testContactEdition() throws InterruptedException {
    if (! app.getContactHelper().isThereAnyContact()) {
      app.getContactHelper().createContact(new ContactData("gup1", null, "group1"));
    }
    app.getContactHelper().returnToHomePage();
    List<ContactData> before = app.getContactHelper().getContactsList();
    app.getContactHelper().selectContact();
    app.getContactHelper().initiateContactEditing();
    ContactData contact = new ContactData("Nadia6", "Hz", "group1");
    app.getContactHelper().fillContactForm(contact, false);
    app.getContactHelper().updateEditedContactForm();
    app.getContactHelper().returnToHomePage();
    app.getContactHelper().waitForTablePresent();
    List<ContactData> after = app.getContactHelper().getContactsList();
    Assert.assertEquals(after.size(), before.size());
    before.remove(before.size() - 1);
    before.add(contact);
    Comparator<? super ContactData> byName = (c1, c2) -> CharSequence.compare(c1.getFirstName(), c2.getFirstName());
    before.sort(byName);
    after.sort(byName);
    Assert.assertEquals(after, before);
  }
}
