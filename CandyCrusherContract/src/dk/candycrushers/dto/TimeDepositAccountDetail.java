/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.candycrushers.dto;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Thomas
 */
public class TimeDepositAccountDetail extends AccountDetail implements Serializable {
    private Date startDate;
    private Date endDate;

    public TimeDepositAccountDetail(long accountId, String accountType, double balance, String owner, Date startDate, Date endDate) {
        super(accountId, accountType, balance, owner);
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Date getStartDate() {
        return startDate;
    }
    
    

    
}
