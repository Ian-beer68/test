package org.ian.gohenry.domain;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "children")
public class Child {
    private Long id;
    private String firstname;
    private String secondName;
    private String lastname;
    private String emailaddress;
    private LocalDate dateofbirth;
    private String gender;
    private Parent parent;

    public Child() {
    }

    public Child(Long id, String firstname, String secondName, String lastname, String emailaddress, LocalDate dateofbirth, String gender, Parent parent) {
        this.id = id;
        this.firstname = firstname;
        this.secondName = secondName;
        this.lastname = lastname;
        this.emailaddress = emailaddress;
        this.dateofbirth = dateofbirth;
        this.gender = gender;
        this.parent = parent;
    }

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmailaddress() {
        return emailaddress;
    }

    public LocalDate getDateofbirth() {
        return dateofbirth;
    }

    public String getGender() {
        return gender;
    }

    @ManyToOne( cascade = CascadeType.ALL)
    @JoinColumn(name = "pid", referencedColumnName = "id")
    public Parent getParent() {
        return parent;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setEmailaddress(String emailaddress) {
        this.emailaddress = emailaddress;
    }

    public void setDateofbirth(LocalDate dateofbirth) {
        this.dateofbirth = dateofbirth;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setParent(Parent parent) {
        this.parent = parent;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    @Override
    public boolean equals(Object o) {
        return EqualsBuilder.reflectionEquals(this, o);
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
