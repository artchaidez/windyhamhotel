package edu.depaul.cdm.se452.dreamteam.windyhamhotel;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Guest")
public class Guest extends Reservation implements Booking
{
    @Id
    @GeneratedValue
    @Column(name = "guest_id")
    public int      guest_id;

    @Column(name = "first_name")
    public String   first_name;

    @Column(name = "last_name")
    public String   last_name;

    @Column(name = "email")
    public String   email_addr;

    @Column(name = "password")
    public String   password;

    @Column(name = "phone")
    public String   phone_number;

    //All methods for Guest (that aren't the things Lombok takes care of) are encompassed in Reservation
    //since Reservation also implements from Booking and Reservation has established all the Methods laid out in Booking

}
