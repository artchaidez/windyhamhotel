package edu.depaul.cdm.se452.dreamteam.windyhamhotel;

import java.time.LocalDate;

public interface Booking
{
    public void makeReservation(int         reservation_id,
                                int         adult,
                                int         child,
                                LocalDate   checkIn,
                                LocalDate   checkOut,
                                int         room_number,
                                int         guest_id);

    public void updateReservation(int reservation_id);
    public void cancelReservation(int reservation_id);
    public void signIn(String email, String password);
    public void signOut();
}
