/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.candycrushers.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Thomas
 */
@Entity
@Table(name = "ACCOUNTS")
@NamedQueries({
    @NamedQuery(name = "Account.findAll", query = "SELECT a FROM Account a")})
@SequenceGenerator(name = "ACCSEQ", sequenceName = "ACCOUNT_SEQ")
@Inheritance(strategy = InheritanceType.JOINED)
public class Account implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ACCOUNT_ID")
    @GeneratedValue(generator = "ACCSEQ", strategy = GenerationType.SEQUENCE)
    private Integer accountId;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "ACCOUNT_TYPE")
    private String accountType;
    
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "BALANCE")
    private Double balance;
    
    @JoinColumn(name = "OWNER", referencedColumnName = "CUSTOMER_ID")
    @ManyToOne(optional = false)
    private Customer owner;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sourceAccount")
    private Collection<Transaction> outgoingTransactions;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "targetAccount")
    private Collection<Transaction> incomingTransactions;

    public Account() {
    }

    public Account(Integer accountId) {
        this.accountId = accountId;
    }

    public Account(Integer accountId, String accountType) {
        this.accountId = accountId;
        this.accountType = accountType;
    }

    public Account(String accountType) {
        this.accountType = accountType;
    }

     public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Customer getOwner() {
        return owner;
    }

    public void setOwner(Customer owner) {
        this.owner = owner;
    }

    public Collection<Transaction> getOutgoingTransactions() {
        return outgoingTransactions;
    }

    public void setOutgoingTransactions(Collection<Transaction> outgoingTransactions) {
        this.outgoingTransactions = outgoingTransactions;
    }

    public Collection<Transaction> getIncomingTransactions() {
        return incomingTransactions;
    }

    public void setIncomingTransactions(Collection<Transaction> incomingTransactions) {
        this.incomingTransactions = incomingTransactions;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (accountId != null ? accountId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Account)) {
            return false;
        }
        Account other = (Account) object;
        if ((this.accountId == null && other.accountId != null) || (this.accountId != null && !this.accountId.equals(other.accountId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dk.candycrushers.model.Account[ accountId=" + accountId + " ]";
    }
    
}
