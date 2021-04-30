package edu.depaul.cdm.se452.dreamteam.windyhamhotel;

public interface Booking
{
    public void makeReservation();
    public void updateReservation();
    public void cancelReservation();
    public void signIn(String email, String password);
    public void signOut();
}
