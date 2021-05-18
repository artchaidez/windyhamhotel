package edu.depaul.cdm.se452.dreamteam.windyhamhotel.guest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.depaul.cdm.se452.dreamteam.windyhamhotel.exception.ResourceNotFoundException;

@RestController
@RequestMapping("/api/guests")
public class GuestController {

    @Autowired
    private GuestRepository guestRepository;

    @GetMapping
    public List<Guest> getAllGuests() {
        return this.guestRepository.findAll();
    }

    @GetMapping("/{id}")
    public Guest getGuestById(@PathVariable(value = "id") int guestId) {
        return this.guestRepository.findById(guestId)
                .orElseThrow(() -> new ResourceNotFoundException("Guest not found with id: " + guestId));
    }

    @PostMapping
    public Guest createGuest(@RequestBody Guest guest) {
        return this.guestRepository.save(guest);
    }


    @PutMapping("/{id}")
    public Guest updateGuest(@RequestBody Guest guest, @PathVariable ("id") int guestId){
        Guest existingGuest = this.guestRepository.findById(guestId)
                .orElseThrow(() -> new ResourceNotFoundException("Guest not found with id: " + guestId));

        //System.out.println(existingGuest.getAdult());
        existingGuest.setFirst_name(guest.getFirst_name());
        existingGuest.setLast_name(guest.getLast_name());
        existingGuest.setEmail_addr(guest.getEmail_addr());
        // existingGuest.setPassword(guest.getPassword());
        existingGuest.setPhone_number(guest.getPhone_number());
        return this.guestRepository.save(existingGuest);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Guest> deleteGuest(@PathVariable ("id") int guestId){
        Guest existingGuest = this.guestRepository.findById(guestId)
                .orElseThrow(() -> new ResourceNotFoundException("Guest not found with id: " + guestId));

        this.guestRepository.delete(existingGuest);

        return ResponseEntity.ok().build();
    }
}

