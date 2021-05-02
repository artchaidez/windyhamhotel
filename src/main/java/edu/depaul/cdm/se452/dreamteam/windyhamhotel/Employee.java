package edu.depaul.cdm.se452.dreamteam.windyhamhotel;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "Employee")
public class Employee implements Booking
{
    @Id
    @GeneratedValue
    @Column(name = "employee_id")
    public int employee_id;

    @Column(name = "password")
    private String password;


    /*
        ----  makeReservation() ----
        Makes a reservation and adds the data to the database after being passed all the data from the Front End

        TODO:: Make this send the data to the database, receive it from the Front End
     */

    public void makeReservation(int id, int adult, int child, LocalDate checkIn, LocalDate checkOut, Room room, Guest guest)
    {
        //This can be implemented the same way that we implement it in Reservation


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

    }


    /*
        ---- cancelReservation() ----
        Cancels a reservation given the ID by deleting it from our database

        TODO:: Delete data from our Database given the ID# of the Order
         Takes in ID# of the order so it knows what order to cancel
     */

    public void cancelReservation(int id)
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

    }


    //TODO:: placeholder
    //As said in Reservation.java, this seems unnecessary (and wrong?) to handle on the back end

    public void signOut()
    {

    }


}
