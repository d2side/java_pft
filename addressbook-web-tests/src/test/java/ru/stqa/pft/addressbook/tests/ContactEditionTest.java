package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.List;

public class ContactEditionTest extends TestBase {

  @Test
  public void testContactEdition() {
    if (! app.getContactHelper().isThereAnyContact()) {
      app.getContactHelper().createContact(new ContactData("gup1", null, "group1"));
    }
    app.getContactHelper().returnToHomePage();
    List<GroupData> before = app.getGroupHelper().getGroupList();
    app.getContactHelper().selectContact();
    app.getContactHelper().initiateContactEditing();
    app.getContactHelper().fillContactForm(new ContactData("group8", "group2", null), false);
    app.getContactHelper().updateEditedContactForm();
    app.getContactHelper().returnToHomePage();
    List<GroupData> after = app.getGroupHelper().getGroupList();
    Assert.assertEquals(after.size(), before.size());
  }
}
