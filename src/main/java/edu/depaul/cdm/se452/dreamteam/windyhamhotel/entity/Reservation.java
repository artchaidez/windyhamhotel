package edu.depaul.cdm.se452.dreamteam.windyhamhotel.entity;

import java.io.Serializable;
import lombok.Data;
import javax.persistence.*;

@Data
@Entity
public class Reservation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long reservation_id;

    private int adult;
    private int child;
    private int days;
    private String checkin;
    private String checkout;

    // should be an object (Room room)
    private int room_number;

    // should be an object (Guest guest)
    private int guest_id;

    private double amount;


    public Reservation(int adult, int child, int days, String checkin, String checkout, int room_number, int guest_id, double amount) {
        this.adult = adult;
        this.child = child;
        this.days = days;
        this.checkin = checkin;
        this.checkout = checkout;
        this.room_number = room_number;
        this.guest_id = guest_id;
        this.amount = amount;
    }

    public Reservation() { }


    public long getReservation_id() {
        return reservation_id;
    }

    public void setReservation_id(long reservation_id) {
        this.reservation_id = reservation_id;
    }

    public int getAdult() {
        return adult;
    }

    public void setAdult(int adult) {
        this.adult = adult;
    }

    public int getChild() {
        return child;
    }

    public void setChild(int child) {
        this.child = child;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public String getCheckin() {
        return checkin;
    }

    public void setCheckin(String checkin) {
        this.checkin = checkin;
    }

    public String getCheckout() {
        return checkout;
    }

    public void setCheckout(String checkout) {
        this.checkout = checkout;
    }

    public int getRoom_number() {
        return room_number;
    }

    public void setRoom_number(int room_number) {
        this.room_number = room_number;
    }

    public int getGuest_id() {
        return guest_id;
    }

    public void setGuest_id(int guest_id) {
        this.guest_id = guest_id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
