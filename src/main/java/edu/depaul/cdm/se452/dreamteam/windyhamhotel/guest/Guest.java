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
        //this.password = password;
        this.phone_number = phone_number;
    }

    public Guest () {}

}
