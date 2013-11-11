/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.candycrushers.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Thomas
 */
@Entity
@Table(name = "BANKTELLERS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bankteller.findAll", query = "SELECT b FROM Bankteller b"),
    @NamedQuery(name = "Bankteller.findByBanktellerId", query = "SELECT b FROM Bankteller b WHERE b.banktellerId = :banktellerId"),
    @NamedQuery(name = "Bankteller.findByFirstName", query = "SELECT b FROM Bankteller b WHERE b.firstName = :firstName"),
    @NamedQuery(name = "Bankteller.findByLastName", query = "SELECT b FROM Bankteller b WHERE b.lastName = :lastName"),
    @NamedQuery(name = "Bankteller.findByEmail", query = "SELECT b FROM Bankteller b WHERE b.email = :email"),
    @NamedQuery(name = "Bankteller.findByPassword", query = "SELECT b FROM Bankteller b WHERE b.password = :password"),
    @NamedQuery(name = "Bankteller.findByBanktellerRole", query = "SELECT b FROM Bankteller b WHERE b.banktellerRole = :banktellerRole")})
public class Bankteller implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "BANKTELLER_ID", nullable = false)
    private Integer banktellerId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "FIRST_NAME", nullable = false, length = 40)
    private String firstName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "LAST_NAME", nullable = false, length = 40)
    private String lastName;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "EMAIL", nullable = false, length = 40)
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "PASSWORD", nullable = false, length = 150)
    private String password;
    @Column(name = "BANKTELLER_ROLE")
    private Integer banktellerRole;

    public Bankteller() {
    }

    public Bankteller(Integer banktellerId) {
        this.banktellerId = banktellerId;
    }

    public Bankteller(Integer banktellerId, String firstName, String lastName, String email, String password) {
        this.banktellerId = banktellerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getBanktellerRole() {
        return banktellerRole;
    }

    public void setBanktellerRole(Integer banktellerRole) {
        this.banktellerRole = banktellerRole;
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
