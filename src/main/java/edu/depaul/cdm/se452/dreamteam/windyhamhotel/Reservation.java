package edu.depaul.cdm.se452.dreamteam.windyhamhotel;

import java.time.LocalDate;
import lombok.Data;

@Data
public class Reservation implements Booking
{
    public int          id;
    public int          adult;
    public int          child;
    public LocalDate    checkIn;
    public LocalDate    checkOut;
    public Room         room;
    public Guest        guest;

    public void makeReservation()
    {

    }

    public void updateReservation()
    {

    }

    public void cancelReservation()
    {

    }

    public void signIn(String email, String password)
    {

    }

    public void signOut()
    {

    }

}
