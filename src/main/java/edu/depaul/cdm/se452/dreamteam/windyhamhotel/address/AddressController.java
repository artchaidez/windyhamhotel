package edu.depaul.cdm.se452.dreamteam.windyhamhotel.address;

import edu.depaul.cdm.se452.dreamteam.windyhamhotel.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/addresses")
public class AddressController {
    @Autowired
    private AddressRepository addressRepository;

    @GetMapping
    public List<Address> getAllHotelAddresses() {
        return this.addressRepository.findAll();
    }

    @GetMapping("/{id}")
    public Address getHotelById(@PathVariable(value = "id") long addressId) {
        return this.addressRepository.findById(addressId)
                .orElseThrow(() -> new ResourceNotFoundException("Room not found with id: " + addressId));
    }

    @PostMapping
    public Address createHotel(@RequestBody Address address) {
        return this.addressRepository.save(address);
    }

    @PutMapping("/{id}")
    public Address updateAddress(@RequestBody Address address, @PathVariable ("id") long addressId){
        Address existingAddress = this.addressRepository.findById(addressId)
                .orElseThrow(() -> new ResourceNotFoundException("Address not found with id: " + addressId));

        existingAddress.setCity(address.getCity());
        existingAddress.setState(address.getState());
        existingAddress.setStreet(address.getStreet());
        existingAddress.setZipCode(address.getZipCode());

        return this.addressRepository.save(existingAddress);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Address> deleteAddress(@PathVariable ("id") long addressId){
        Address existingAddress = this.addressRepository.findById(addressId)
                .orElseThrow(() -> new ResourceNotFoundException("Address not found with id: " + addressId));

        this.addressRepository.delete(existingAddress);

        return ResponseEntity.ok().build();
    }
}
