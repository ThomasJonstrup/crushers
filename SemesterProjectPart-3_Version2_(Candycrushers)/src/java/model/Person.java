/*
 */

package model;

/**
 * @author Thomas
 */
public class Person {
  private String firstName;
  String lastName;
  Double salary;
  String email;
  Address address;

  public Person(String firstName, String lastName, Double salary, String email, Address address) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.salary = salary;
    this.email = email;
    this.address = address;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public Double getSalary() {
    return salary;
  }

  public String getEmail() {
    return email;
  }

  public Address getAddress() {
    return address;
  }
  
  
}
