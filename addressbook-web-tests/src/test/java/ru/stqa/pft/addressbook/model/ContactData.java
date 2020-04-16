package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public class ContactData {
  private String firstName;
  //  private final String middleName;
//  private final String lastName;
  //  private final String nickName;
//  private final String title;
  private String group;


  public String getFirstName() {
    return firstName;
  }

  public String getGroup() {
    return group;
  }


  public ContactData withFirstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  public ContactData withGroup(String group) {
    this.group = group;
    return this;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ContactData that = (ContactData) o;
    return Objects.equals(firstName, that.firstName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(firstName);
  }

  @Override
  public String toString() {
    return "ContactData{" +
            "firstName='" + firstName + '\'' +
            '}';
  }

//  public String getLastName() {
//    return lastName;
//  }
}
