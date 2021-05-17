package edu.depaul.cdm.se452.dreamteam.windyhamhotel.guest;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "guests")
public class Guest
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "guest_id")
    public int      guest_id;

    @Column(name = "first_name")
    public String   first_name;

    @Column(name = "last_name")
    public String   last_name;

    @Column(name = "email")
    public String   email_addr;

    // @Column(name = "password")
    // public String   password;

    @Column(name = "phone")
    public String   phone_number;

    //All methods for Guest (that aren't the things Lombok takes care of) are encompassed in Reservation
    //since Reservation also implements from Booking and Reservation has established all the Methods laid out in Booking

    public Guest (String first_name, String last_name, String email_addr, String phone_number) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.email_addr = email_addr;
        this.phone_number = phone_number;
    }

    public Guest () {}

    public int getGuest_id() {
        return guest_id;
    }

    public void setGuest_id(int guest_id) {
        this.guest_id = guest_id;
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
