package edu.depaul.cdm.se452.dreamteam.windyhamhotel.Reservation;

import edu.depaul.cdm.se452.dreamteam.windyhamhotel.bill.Bill;
import edu.depaul.cdm.se452.dreamteam.windyhamhotel.exception.ResourceNotFoundException;
import edu.depaul.cdm.se452.dreamteam.windyhamhotel.guest.Guest;
import edu.depaul.cdm.se452.dreamteam.windyhamhotel.room.Room;
import edu.depaul.cdm.se452.dreamteam.windyhamhotel.room.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservations")
@CrossOrigin(origins = "http://localhost:8081")
public class ReservationController {
    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private RoomRepository roomRepository;

    @GetMapping
    public List<Reservation> getAllReservations() {
        return this.reservationRepository.findAll();
    }

    @GetMapping("/{id}")
    public Reservation getReservationById(@PathVariable(value = "id") long reservationId) {
        return this.reservationRepository.findById(reservationId)
                .orElseThrow(() -> new ResourceNotFoundException("Reservation not found with id: " + reservationId));
    }

    @PostMapping
    public Reservation createReservation(@RequestBody Reservation reservation) {
        int roomNumber = reservation.getRoom_id();
        Room existingRoom = this.roomRepository.findById(roomNumber)
                .orElseThrow(() -> new ResourceNotFoundException("Room not found with id: " + roomNumber));
        existingRoom.setRoom_status("Occupied");

        return this.reservationRepository.save(reservation);
    }


    @PutMapping("/{id}")
    public Reservation updateReservation(@RequestBody Reservation reservation, @PathVariable ("id") long reservationId){
        Reservation existingReservation = this.reservationRepository.findById(reservationId)
                .orElseThrow(() -> new ResourceNotFoundException("Reservation not found with id: " + reservationId));

        existingReservation.setAdult(reservation.getAdult());

        existingReservation.setCheckin(reservation.getCheckin());
        existingReservation.setCheckout(reservation.getCheckout());
        existingReservation.setChild(reservation.getChild());
        existingReservation.setDays(reservation.getDays());
        existingReservation.setHotel_id(reservation.getHotel_id());


        Bill bill = reservation.getBill();
        Bill existingBill = existingReservation.getBill();

        existingBill.setAmount(bill.getAmount());
        existingBill.setDate(bill.getDate());
        existingBill.setRoomTotalPrice(bill.getRoomTotalPrice());
        existingBill.setTax(bill.getTax());

        Guest guest = reservation.getGuest();
        Guest existingGuest = existingReservation.getGuest();

        existingGuest.setPhone_number(guest.getPhone_number());
        existingGuest.setLast_name(guest.getLast_name());
        existingGuest.setFirst_name(guest.getFirst_name());
        existingGuest.setEmail_addr(guest.getEmail_addr());

        Room existingRoom = this.roomRepository.findById(existingReservation.getRoom_id())
                .orElseThrow(() -> new ResourceNotFoundException("Room not found with id: " + existingReservation.getRoom_id()));
        existingRoom.setRoom_status("Vacant");

        existingReservation.setRoom_id(reservation.getRoom_id());
        Room updatedRoom = this.roomRepository.findById(reservation.getRoom_id())
                .orElseThrow(() -> new ResourceNotFoundException("Room not found with id: " + reservation.getRoom_id()));
        updatedRoom.setRoom_status("Occupied");

        return this.reservationRepository.save(existingReservation);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Reservation> deleteReservation(@PathVariable ("id") long reservationId){
        Reservation existingReservation = this.reservationRepository.findById(reservationId)
                .orElseThrow(() -> new ResourceNotFoundException("Reservation not found with id: " + reservationId));

        Room existingRoom = this.roomRepository.findById(existingReservation.getRoom_id())
                .orElseThrow(() -> new ResourceNotFoundException("Room not found with id: " + existingReservation.getRoom_id()));
        existingRoom.setRoom_status("Vacant");
        
        this.reservationRepository.delete(existingReservation);

        return ResponseEntity.ok().build();
    }
}
