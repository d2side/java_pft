package ru.stqa.pft.addressbook.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class GroupDeletionTest extends TestBase {

  @Test
  public void testGroupDeletion() throws Exception {
    app.getGroupHelper().goToGroupPage();
    app.getGroupHelper().selectGroup(By.name("selected[]"));
    app.getGroupHelper().deleteSelectedGroup(By.xpath("(//input[@name='delete'])[2]"));
    app.getGroupHelper().returnToGroupPage();
  }

}
