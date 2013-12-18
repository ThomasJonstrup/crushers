/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.candycrushers.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Thomas
 */
@Entity
@Table(name = "TIME_DEPOSIT_ACCOUNTS")
@NamedQueries({
    @NamedQuery(name = "TimeDepositAccount.findAll", query = "SELECT t FROM TimeDepositAccount t")})
public class TimeDepositAccount extends Account implements Serializable {
    private static final long serialVersionUID = 1L;
//    @Id
//    @Basic(optional = false)
//    @NotNull
//    @Column(name = "ACCOUNT_ID")
//    private Integer accountId;
    @Column(name = "START_DATE")
    @Temporal(TemporalType.DATE)
    private Date startDate;
    @Column(name = "END_DATE")
    @Temporal(TemporalType.DATE)
    private Date endDate;

    public TimeDepositAccount() {
    }

    public TimeDepositAccount(Date startDate, Date endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }



    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "Time Deposit Account "+getAccountId();
    }
    
}
