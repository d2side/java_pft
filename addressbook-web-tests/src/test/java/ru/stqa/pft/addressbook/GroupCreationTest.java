package ru.stqa.pft.addressbook;

import org.testng.annotations.*;


public class GroupCreationTest extends TestBase {

  @Test
  public void testGroupCreation() throws Exception {
    goToGroupPage();
    initGroupCreation();
    fillGroupForm(new GroupData("group1", "group1", "group1"));
    submitGroupCreation();
    returnToGroupPage();
  }

}
