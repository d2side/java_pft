package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public class ContactData {
  private final String firstName;
  //  private final String middleName;
  private final String lastName;
  //  private final String nickName;
//  private final String title;
  private final String group;

  public ContactData(String firstName, String lastName, String group) {
    this.firstName = firstName;
//    this.middleName = middleName;
    this.lastName = lastName;
//    this.nickName = nickName;
//    this.title = title;
    this.group = group;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getGroup() {
    return group;
  }

//  public String getMiddleName() {
//    return middleName;
//  }

  public String getLastName() {
    return lastName;
  }

//
//  public String getNickName() {
//    return nickName;
//  }
//
//  public String getTitle() {
//    return title;
//  }
//
//  public String getCompany() {
//    return company;
//  }

  @Override
  public String toString() {
    return "ContactData{" +
            "firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            ", group='" + group + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ContactData that = (ContactData) o;
    return Objects.equals(firstName, that.firstName) &&
            Objects.equals(lastName, that.lastName) &&
            Objects.equals(group, that.group);
  }

  @Override
  public int hashCode() {
    return Objects.hash(firstName, lastName, group);
  }
}
