package edu.depaul.cdm.se452.dreamteam.windyhamhotel;

import lombok.Data;

@Data
public class Guest extends Reservation implements Booking
{
    public int      id;
    public String   first_name;
    public String   last_name;
    public String   email_addr;
    public String   password;
    public String   phone_number;

    //All methods for Guest (that aren't the things Lombok takes care of) are encompassed in Reservation
    //since Reservation also implements from Booking and Reservation has established all the Methods laid out in Booking

}
