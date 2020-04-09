package ru.stqa.pft.addressbook.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupModificationTest extends TestBase {

  @Test
  public void testGroupModification () {
    app.getGroupHelper().goToGroupPage();
    if (! app.getGroupHelper().isThereAnyGroup()) {
      app.getGroupHelper().createGroup(new GroupData("groupNew", null, null));
    }
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().initGroupModification();
    app.getGroupHelper().fillGroupForm(new GroupData("group3", null, null));
    app.getContactHelper().submitGroupModification();
    app.getGroupHelper().returnToGroupPage();
  }
}
