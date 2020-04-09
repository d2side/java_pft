package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.GroupData;


public class GroupCreationTest extends TestBase {

  @Test
  public void testGroupCreation() throws Exception {
    app.getGroupHelper().goToGroupPage();
    app.getGroupHelper().createGroup(new GroupData("group1", null, null));
  }

}
