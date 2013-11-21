/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.candycrushers.dto;

import java.io.Serializable;
/**
 *
 * @author Thomas
 */
public class BanktellerSummary implements Serializable {
    
    private long banktellerId;
    private String firstName;
    private String lastName;
    private String email;

    public BanktellerSummary(long banktellerId, String firstName, String lastName, String email) {
        this.banktellerId = banktellerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public long getBanktellerId() {
        return banktellerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }


    
    
    
}
