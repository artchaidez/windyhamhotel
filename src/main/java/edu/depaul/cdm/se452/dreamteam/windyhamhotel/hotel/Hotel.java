package edu.depaul.cdm.se452.dreamteam.windyhamhotel.hotel;

import edu.depaul.cdm.se452.dreamteam.windyhamhotel.address.Address;

import javax.persistence.*;

@Entity
@Table(name = "hotels")
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private int numberOfRoom;

    @OneToOne(cascade = CascadeType.ALL)
    private Address address;

    public Hotel(String name, int numberOfRoom, Address address) {
        this.name = name;
        this.numberOfRoom = numberOfRoom;
        this.address = address;
    }

    public Hotel() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfRoom() {
        return numberOfRoom;
    }

    public void setNumberOfRoom(int numberOfRoom) {
        this.numberOfRoom = numberOfRoom;
    }

    public Address getHotelAddress() {
        return address;
    }

    public void setHotelAddress(Address address) {
        this.address = address;
    }
}
