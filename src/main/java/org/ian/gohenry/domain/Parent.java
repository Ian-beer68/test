package org.ian.gohenry.domain;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "parents")
public class Parent {
    private Long id;
    private String title;
    private String firstname;
    private String lastname;
    private String emailaddress;
    private LocalDate dateofbirth;
    private String gender;
    private Set<Child> children;

    public Parent() {
    }

    public Parent(Long id,
                  String title,
                  String firstname,
                  String lastname,
                  String emailaddress,
                  LocalDate dateofbirth,
                  String gender,
                  Set<Child> children) {
        this.id = id;
        this.title = title;
        this.firstname = firstname;
        this.lastname = lastname;
        this.emailaddress = emailaddress;
        this.dateofbirth = dateofbirth;
        this.gender = gender;
        this.children = children;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getFirstname() {
        return firstname;
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

    @OneToMany(mappedBy = "parent")
    public Set<Child> getChildren() {
        return children;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public void setChildren(Set<Child> children) {
        this.children = children;
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
