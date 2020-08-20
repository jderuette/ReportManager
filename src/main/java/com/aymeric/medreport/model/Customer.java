package com.aymeric.medreport.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * Customer entity class
 * @author Aymeric NEUMANN
 *
 */
@Entity
public class Customer {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long customerNumber;
    
    @NotNull
    @NotBlank
    private String lastName;
    
    @NotNull
    @NotBlank
    private String firstName;
    
    @NotNull
    private Date dateOfBirth;
    
    @ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH })
    private List<Address> address;
    
    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH })
    private List<Report> reports;
    
    /**
     * ToString override method
     */
    @Override
    public String toString() {
        return "Customer [customerNumber=" + customerNumber + ", lastName=" + lastName + ", firstName=" + firstName
                + ", dateOfBirth=" + dateOfBirth + ", address=" + address + ", reports=" + reports + "]";
    }
    
    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the dateOfBirth
     */
    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * @param dateOfBirth the dateOfBirth to set
     */
    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    
    /**
     * @return the address
     */
    public List<Address> getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(List<Address> address) {
        this.address = address;
    }

    /**
     * @return the reports
     */
    public List<Report> getReports() {
        return reports;
    }

    /**
     * @param reports the reports to set
     */
    public void setReports(List<Report> reports) {
        this.reports = reports;
    }
    
    /**
     * @return the customerNumber
     */
    public Long getCustomerNumber() {
        return customerNumber;
    }
    
}
