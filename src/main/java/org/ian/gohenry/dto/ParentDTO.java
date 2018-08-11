package org.ian.gohenry.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.util.Set;

@JsonPropertyOrder({"id", "title", "firstName", "lastName", "emailAddress", "dateOfBirth", "gender", "secondName", "children"})
public class ParentDTO {
    private Long id;
    @NotNull(message = "must not be null")
    @NotEmpty(message = "must not be empty")
    private String title;
    @NotNull(message = "must not be null")
    @NotEmpty(message = "must not be empty")
    private String firstname;
    @NotNull(message = "must not be null")
    @NotEmpty(message = "must not be empty")
    private String lastname;
    private String secondname;
    @Email(message = "must be an email address")
    private String emailaddress;
    @Email(message = "must be an email address")
    private LocalDate dateofbirth;
    @NotNull(message = "must not be null")
    @Pattern(message = "must be male or female", regexp = "^(male|female)$")
    private String gender;
    private Set<ChildDTO> children;

    public ParentDTO() {
    }

    @JsonCreator
    public ParentDTO(@JsonProperty("id") Long id,
                     @JsonProperty("title") String title,
                     @JsonProperty("firstName") String firstname,
                     @JsonProperty("secondName") String secondname,
                     @JsonProperty("lastName") String lastname,
                     @JsonProperty("emailAddress") String emailaddress,
                     @JsonProperty("dateOfBirth") LocalDate dateofbirth,
                     @JsonProperty("gender") String gender,
                     @JsonProperty("children") Set<ChildDTO> children) {
        this.id = id;
        this.title = title;
        this.firstname = firstname;
        this.lastname = lastname;
        this.secondname = secondname;
        this.emailaddress = emailaddress;
        this.dateofbirth = dateofbirth;
        this.gender = gender;
        this.children = children;
    }

    @JsonProperty("id")
    public Long getId() {
        return id;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("firstName")
    public String getFirstname() {
        return firstname;
    }

    @JsonProperty("lastName")
    public String getLastname() {
        return lastname;
    }

    @JsonProperty("secondName")
    public String getSecondname() {
        return secondname;
    }

    @JsonProperty("emailAddress")
    public String getEmailaddress() {
        return emailaddress;
    }

    @JsonProperty("dateOfBirth")
    public LocalDate getDateofbirth() {
        return dateofbirth;
    }

    @JsonProperty("gender")
    public String getGender() {
        return gender;
    }

    @JsonProperty("children")
    public Set<ChildDTO> getChildren() {
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

    public void setSecondname(String secondname) {
        this.secondname = secondname;
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

    public void setChildren(Set<ChildDTO> children) {
        this.children = children;
    }
}
