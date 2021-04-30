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


    /*
        ----  makeReservation() ----
        Makes a reservation and adds the data to the database after being passed all the data from the Front End

        TODO:: Make this send the data to the database, receive it from the Front End
     */

    public void makeReservation(int id, int adult, int child, LocalDate checkIn, LocalDate checkOut, Room room, Guest guest)
    {
        /*
            TODO:: We need to decide if we want to do data validation on the front end or at this step. If we want to do
             it here, check all the data and if it's good then add it to the DB - else just assume it's good and add to DB
         */


    }


    /*
        ---- updateReservation() ----
        Updates an existing reservation - takes in all of the data, compares it to what is currently in our database to
        figure out what needs to be changed.

        TODO:: Make this send the data to the database, receive it from the Front End
         Takes in ID# of the order so it knows what order to update
     */

    public void updateReservation(int id)
    {
        /*
            TODO:: Not sure what data exactly is going to be updated, one way we could do it is take in all of the data
             and compare it to what's in our DB currently.
         */

    }


    /*
        ---- cancelReservation() ----
        Cancels a reservation given the ID by deleting it from our database

        TODO:: Delete data from our Database given the ID# of the Order
         Takes in ID# of the order so it knows what order to cancel
     */

    public void cancelReservation(int id) //Shouldn't need anything other than the ID to cancel the order

    {

    }


    /*
        ---- signIn() ----
        Validates that the email and password given to us match what is in our DB

        TODO:: Make this send the data to the database, receive it from the Front End
         Should basically just be a verification check that the email and password match what's in our Database
     */

    public void signIn(String email, String password)
    {
        //TODO:: *NOTE* Maybe should be changed to return Boolean
    }


    //TODO:: placeholder
    //Not sure this is necessary? I think this would be just a front end thing - not something we have to handle here

    public void signOut()
    {

    }

}
