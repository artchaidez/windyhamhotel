package edu.depaul.cdm.se452.dreamteam.windyhamhotel.hotel;


import edu.depaul.cdm.se452.dreamteam.windyhamhotel.address.Address;
import edu.depaul.cdm.se452.dreamteam.windyhamhotel.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hotels")
@CrossOrigin(origins = "http://localhost:8081")
public class HotelController {
    @Autowired
    private HotelRepository hotelRepository;

    @GetMapping
    public List<Hotel> getAllHotels() {
        return this.hotelRepository.findAll();
    }

    @GetMapping("/{id}")
    public Hotel getHotelById(@PathVariable(value = "id") long hotelId) {
        return this.hotelRepository.findById(hotelId)
                .orElseThrow(() -> new ResourceNotFoundException("Room not found with id: " + hotelId));
    }

    @PostMapping
    public Hotel createHotel(@RequestBody Hotel hotel) {
        return this.hotelRepository.save(hotel);
    }

    @PutMapping("/{id}")
    public Hotel updateAddress(@RequestBody Hotel hotel, @PathVariable ("id") long hotelId){
        Hotel existingHotel = this.hotelRepository.findById(hotelId)
                .orElseThrow(() -> new ResourceNotFoundException("Hotel not found with id: " + hotelId));

        existingHotel.setName(hotel.getName());
//        existingHotel.setNumberOfRoom(hotel.getNumberOfRoom());

        Address existingAddress = existingHotel.getHotelAddress();
        Address newAddress = hotel.getHotelAddress();

        existingAddress.setZipCode(newAddress.getZipCode());
        existingAddress.setStreet(newAddress.getStreet());
        existingAddress.setCity(newAddress.getCity());
        existingAddress.setState(newAddress.getState());

        return this.hotelRepository.save(existingHotel);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Hotel> deleteHotel(@PathVariable ("id") long hotelId){
        Hotel existingHotel = this.hotelRepository.findById(hotelId)
                .orElseThrow(() -> new ResourceNotFoundException("Hotel not found with id: " + hotelId));

        this.hotelRepository.delete(existingHotel);
        return ResponseEntity.ok().build();
    }

}
