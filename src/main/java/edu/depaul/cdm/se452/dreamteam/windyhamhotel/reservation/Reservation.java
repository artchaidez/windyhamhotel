package edu.depaul.cdm.se452.dreamteam.windyhamhotel.reservation;

import java.io.Serializable;

import edu.depaul.cdm.se452.dreamteam.windyhamhotel.bill.Bill;
import edu.depaul.cdm.se452.dreamteam.windyhamhotel.guest.Guest;
import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name = "reservations")
public class Reservation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long reservation_id;

    private int adult;
    private int child;
    private int days;
    private String checkin;
    private String checkout;

    private int room_id;

    private int hotel_id;

    @OneToOne(cascade = CascadeType.ALL)
    private Guest guest;

    @OneToOne(cascade = CascadeType.ALL)
    private Bill bill;


    public Reservation(int adult, int child, int days, String checkin, String checkout, int room_id, int hotel_id, Guest guest, Bill bill) {
        this.adult = adult;
        this.child = child;
        this.days = days;
        this.checkin = checkin;
        this.checkout = checkout;
        this.room_id = room_id;
        this.hotel_id = hotel_id;
        this.guest = guest;
        this.bill = bill;
    }

    public Reservation() {

    }

    public int getHotel_id() {
        return hotel_id;
    }

    public void setHotel_id(int hotel_id) {
        this.hotel_id = hotel_id;
    }

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

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

    public int getRoom_id() {
        return room_id;
    }

    public void setRoom_id(int room_id) {
        this.room_id = room_id;
    }

    public Guest getGuest_id() {
        return guest;
    }

    public void setGuest_id(Guest guest_id) {
        this.guest = guest_id;
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }
}
