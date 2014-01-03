/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.candycrushers.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity; // skal annoteres
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Thomas
 */
@Entity
@Table(name = "BANKTELLERS")
@NamedQueries({
    @NamedQuery(name = "Bankteller.findAll", query = "SELECT b FROM Bankteller b"),
    @NamedQuery(name = "Bankteller.findByEmail", query = "SELECT b FROM Bankteller b WHERE b.person.email = :email"),
            @NamedQuery(name = "Bankteller.countAll", query = "SELECT COUNT(b) FROM Bankteller b") 
})
@SequenceGenerator(name = "TELSEQ", sequenceName = "bankteller_seq")
public class Bankteller implements Serializable { // skal implementeres i en entitetsklasse og skal være enten public eller protected
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "BANKTELLER_ID")
    @GeneratedValue(generator = "TELSEQ", strategy = GenerationType.SEQUENCE)
    private Integer banktellerId;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "FIRST_NAME")
    private String firstName;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "LAST_NAME")
    private String lastName;
    
    @JoinColumn(name = "EMAIL", referencedColumnName = "EMAIL")
    @OneToOne(optional = false)
    private Person person;

    public Bankteller() { // skal have en tom kontruktør og må gerne have flere
    }

    public Bankteller(Integer banktellerId) {
        this.banktellerId = banktellerId;
    }

    public Bankteller(Integer banktellerId, String firstName, String lastName) {
        this.banktellerId = banktellerId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Integer getBanktellerId() {
        return banktellerId;
    }

    public void setBanktellerId(Integer banktellerId) {
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

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (banktellerId != null ? banktellerId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bankteller)) {
            return false;
        }
        Bankteller other = (Bankteller) object;
        if ((this.banktellerId == null && other.banktellerId != null) || (this.banktellerId != null && !this.banktellerId.equals(other.banktellerId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dk.candycrushers.model.Bankteller[ banktellerId=" + banktellerId + " ]";
    }
    
}
