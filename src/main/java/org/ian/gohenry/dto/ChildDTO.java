package org.ian.gohenry.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.time.LocalDate;
@JsonPropertyOrder({"id","title","firstName","lastName", "emailAddress", "dateOfBirth","gender", "secondName"})
public class ChildDTO {

    private Long id;
    private String firstname;
    private String secondName;
    private String lastname;
    private String emailaddress;
    private LocalDate dateofbirth;
    private String gender;

    public ChildDTO() {
    }

    @JsonCreator
    public ChildDTO(@JsonProperty("id")Long id,
                 @JsonProperty("firstName")String firstname,
                 @JsonProperty("lastName")String lastname,
                 @JsonProperty("secondName")String secondname,
                 @JsonProperty("emailAddress")String emailaddress,
                 @JsonProperty("dateOfBirth") LocalDate dateofbirth,
                 @JsonProperty("gender")String gender) {
        this.id = id;
        this.firstname = firstname;
        this.secondName = secondname;
        this.lastname = lastname;
        this.emailaddress = emailaddress;
        this.dateofbirth = dateofbirth;
        this.gender = gender;
    }
    @JsonProperty("id")
    public Long getId() {
        return id;
    }
    @JsonProperty("firstName")
    public String getFirstname() {
        return firstname;
    }
    @JsonProperty("secondName")
    public String getSecondName() {
        return secondName;
    }
    @JsonProperty("lastName")
    public String getLastname() {
        return lastname;
    }
    @JsonProperty("emailAddress")
    public String getEmailaddress() {
        return emailaddress;
    }
    @JsonProperty("dateofBirth")
    public LocalDate getDateofbirth() {
        return dateofbirth;
    }
    @JsonProperty("gender")
    public String getGender() {
        return gender;
    }



    public void setId(Long id) {
        this.id = id;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
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


}
