package edu.depaul.cdm.se452.dreamteam.windyhamhotel.complaint;

import javax.persistence.Id;

import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "complaints")
public class Complaint {
    
    @Transient
    public static final String SEQUENCE_NAME = "complaint_sequences";

    @Id
    private Long id;

    private String firstname;
    private String lastname;
    private String email;
    private String phone;
    private String reason;
    private String details;


    public Complaint() {}

    public Complaint(String firstname, String lastname, String email, String phone, String reason, String details) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.phone = phone;
        this.reason = reason;
        this.details = details;
    }

    public static String getSequenceName() {
        return SEQUENCE_NAME;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
