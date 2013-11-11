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
public class AccountSummary implements Serializable {
    
    private long accountId;
    private String accountType;
    private CustomerSummary owner;

    public AccountSummary(long accountId, String accountType) {
        this.accountId = accountId;
        this.accountType = accountType;
    }

    public long getAccountId() {
        return accountId;
    }

    public String getAccountType() {
        return accountType;
    }
    
    
}
