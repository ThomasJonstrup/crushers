/*
 */

package model;

/**
 * @author Thomas
 */
public class Address {
  public String street;
  public String city;
  public String zip;

  public Address(String street, String city, String zip) {
    this.street = street;
    this.city = city;
    this.zip = zip;
  }

  public String getStreet() {
    return street;
  }

  public String getCity() {
    return city;
  }

  public String getZip() {
    return zip;
  }
  
  
}
