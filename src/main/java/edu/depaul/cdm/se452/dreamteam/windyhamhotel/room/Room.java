package edu.depaul.cdm.se452.dreamteam.windyhamhotel.room;

import edu.depaul.cdm.se452.dreamteam.windyhamhotel.hotel.Hotel;
import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name = "rooms")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private int room_number;

    private double room_price;
    private String room_type;
    private String room_description;
    private String room_status;

    @ManyToOne
    @JoinColumn(name="hotel_id", nullable=false)
    private Hotel hotel;

    public Room(int room_number, double room_price, String room_type, String room_description, String room_status, Hotel hotel) {
        this.room_number = room_number;
        this.room_price = room_price;
        this.room_type = room_type;
        this.room_description = room_description;
        this.room_status = room_status;
        this.hotel = hotel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRoom_number() {
        return room_number;
    }

    public void setRoom_number(int room_number) {
        this.room_number = room_number;
    }

    public double getRoom_price() {
        return room_price;
    }

    public void setRoom_price(double room_price) {
        this.room_price = room_price;
    }

    public String getRoom_type() {
        return room_type;
    }

    public void setRoom_type(String room_type) {
        this.room_type = room_type;
    }

    public String getRoom_description() {
        return room_description;
    }

    public void setRoom_description(String room_description) {
        this.room_description = room_description;
    }

    public String getRoom_status() {
        return room_status;
    }

    public void setRoom_status(String room_status) {
        this.room_status = room_status;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public Room() {

    }


}
