/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.candycrushers.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author Thomas
 */
public class CustomerDetail implements Serializable {
    
    private long customerId;
    private String firstName;
    private String lastName;
    private String email;

    private Collection<AccountDetail> accounts = new ArrayList();
    
    public CustomerDetail(long customerId, String firstName, String lastName, String email) {
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public long getCustomerId() {
        return customerId;
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

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }    
    

  public Collection<AccountDetail> getAccounts() {
    return accounts;
  }

  public void setAccounts(Collection<AccountDetail> accounts) {
    this.accounts = accounts;
  }

}
