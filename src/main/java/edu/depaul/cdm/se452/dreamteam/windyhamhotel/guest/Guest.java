package edu.depaul.cdm.se452.dreamteam.windyhamhotel.guest;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "guests")
public class Guest{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long guest_id;
    public String   first_name;
    public String   last_name;
    public String   email_addr;
    public String   phone_number;

    public Guest(String first_name, String last_name, String email_addr, String phone_number) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.email_addr = email_addr;
        this.phone_number = phone_number;
    }

    public Guest() {

    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail_addr() {
        return email_addr;
    }

    public void setEmail_addr(String email_addr) {
        this.email_addr = email_addr;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }
}
