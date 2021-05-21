package edu.depaul.cdm.se452.dreamteam.windyhamhotel.hotel;

import edu.depaul.cdm.se452.dreamteam.windyhamhotel.address.Address;
import edu.depaul.cdm.se452.dreamteam.windyhamhotel.room.Room;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "hotels")
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    private Address address;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "hotel")
    private List<Room> rooms;

    public Hotel(String name, Address address) {
        this.name = name;
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

    public Address getHotelAddress() {
        return address;
    }

    public void setHotelAddress(Address address) {
        this.address = address;
    }
}
