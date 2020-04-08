package ru.stqa.pft.addressbook.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupModificationTest extends TestBase {

  @Test
  public void testGroupModification () {
    app.getGroupHelper().goToGroupPage();
    app.getGroupHelper().selectGroup(By.name("selected[]"));
    app.getGroupHelper().initGroupModification();
    app.getGroupHelper().fillGroupForm(new GroupData("group3", "group2", "group2"));
    app.getContactHelper().submitGroupModification();
    app.getGroupHelper().returnToGroupPage();
  }
}
