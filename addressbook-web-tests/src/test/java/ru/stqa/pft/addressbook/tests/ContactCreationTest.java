package ru.stqa.pft.addressbook.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

public class ContactCreationTest extends TestBase {

  @Test
  public void testContactCreation() throws InterruptedException {
    app.getContactHelper().returnToHomePage();
    List<ContactData> before = app.getContactHelper().getContactsList();
    ContactData contact = new ContactData("Nadia6", "Hz", "group3");
    app.getContactHelper().createContact(contact);
    app.getContactHelper().waitForTablePresent();
    app.getContactHelper().returnToHomePage();
    List<ContactData> after = app.getContactHelper().getContactsList();
    Assert.assertEquals(after.size(), before.size() + 1);
    before.add(contact);
    Comparator<? super ContactData> byName = (c1, c2) -> CharSequence.compare(c1.getFirstName(), c2.getFirstName());
//    Assert.assertEquals(new HashSet<>(after), new HashSet<>(before));
//    before.sort(byName);
//    after.sort(byName);
    assertEquals(before, after);
  }
}
