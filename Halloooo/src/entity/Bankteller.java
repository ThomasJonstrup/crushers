/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author Thomas
 */
public class Bankteller {
    
    private int banktellerId;
    private String firstName;
    private String lastName;
    private Person email;

    public Bankteller(int banktellerId, String firstName, String lastName, Person email) {
        this.banktellerId = banktellerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public int getBanktellerId() {
        return banktellerId;
    }

    public void setBanktellerId(int banktellerId) {
        this.banktellerId = banktellerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Person getEmail() {
        return email;
    }

    public void setEmail(Person email) {
        this.email = email;
    }   
}
