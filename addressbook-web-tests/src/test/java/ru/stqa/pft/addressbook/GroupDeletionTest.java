package ru.stqa.pft.addressbook;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class GroupDeletionTest extends TestBase {

  @Test
  public void testGroupDeletion() throws Exception {
    goToGroupPage();
    selectGroup(By.name("selected[]"));
    deleteSelectedGroup(By.xpath("(//input[@name='delete'])[2]"));
    returnToGroupPage();
  }

}
