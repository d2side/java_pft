package ru.stqa.pft.addressbook.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupDeletionTest extends TestBase {

  @Test
  public void testGroupDeletion() throws Exception {
    app.getGroupHelper().goToGroupPage();
    if (! app.getGroupHelper().isThereAnyGroup()) {
      app.getGroupHelper().createGroup(new GroupData("group1", null, null));
    }
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().deleteSelectedGroup(By.xpath("(//input[@name='delete'])[2]"));
    app.getGroupHelper().returnToGroupPage();
  }

}
