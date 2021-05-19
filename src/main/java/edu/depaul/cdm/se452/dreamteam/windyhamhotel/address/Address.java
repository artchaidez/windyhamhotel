package edu.depaul.cdm.se452.dreamteam.windyhamhotel.address;

import edu.depaul.cdm.se452.dreamteam.windyhamhotel.hotel.Hotel;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String state;
    private String city;
    private String street;
    private int zipCode;

    public Address(String state, String city, String street, int zipCode) {
        this.state = state;
        this.city = city;
        this.street = street;
        this.zipCode = zipCode;
    }

    public Address() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }
}
