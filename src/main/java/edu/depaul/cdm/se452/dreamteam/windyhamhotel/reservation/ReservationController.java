package edu.depaul.cdm.se452.dreamteam.windyhamhotel.reservation;

import edu.depaul.cdm.se452.dreamteam.windyhamhotel.bill.Bill;
import edu.depaul.cdm.se452.dreamteam.windyhamhotel.bill.BillRepository;
import edu.depaul.cdm.se452.dreamteam.windyhamhotel.exception.ResourceNotFoundException;
import edu.depaul.cdm.se452.dreamteam.windyhamhotel.guest.Guest;
import edu.depaul.cdm.se452.dreamteam.windyhamhotel.guest.GuestRepository;
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
    private GuestRepository guestRepository;
    private BillRepository billRepository;

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
        int roomId = reservation.getRoom_id();
        Room existingRoom = this.roomRepository.findById(roomId)
                .orElseThrow(() -> new ResourceNotFoundException("Room not found with id: " + roomId));
        existingRoom.setRoom_status("Occupied");

        return this.reservationRepository.save(reservation);
    }


    @PutMapping("/{id}")
    public Reservation updateReservation(@RequestBody Reservation reservation, @PathVariable ("id") long reservationId){
        Reservation existingReservation = this.reservationRepository.findById(reservationId)
                .orElseThrow(() -> new ResourceNotFoundException("Reservation not found with id: " + reservationId));


        existingReservation.setHotel_id(reservation.getHotel_id());
        existingReservation.setDays(reservation.getDays());
        existingReservation.setChild(reservation.getChild());
        existingReservation.setCheckout(reservation.getCheckout());
        existingReservation.setCheckin(reservation.getCheckin());
        existingReservation.setAdult(reservation.getAdult());

        Room existingRoom = this.roomRepository.findById(existingReservation.getRoom_id()).orElseThrow(() -> new ResourceNotFoundException("Room not found with id: " + existingReservation.getRoom_id()));
        existingRoom.setRoom_status("Vacant");

        existingReservation.setRoom_id(reservation.getRoom_id());
        Room room = this.roomRepository.findById(reservation.getRoom_id()).orElseThrow(() -> new ResourceNotFoundException("Room not found with id: " + reservation.getRoom_id()));
        room.setRoom_status("Occupied");

        Guest existingGuest = existingReservation.getGuest();
        existingGuest.setEmail_addr(reservation.getGuest().getEmail_addr());
        existingGuest.setFirst_name(reservation.getGuest().getFirst_name());
        existingGuest.setLast_name(reservation.getGuest().getLast_name());
        existingGuest.setPhone_number(reservation.getGuest().getPhone_number());

        Bill existingBill = existingReservation.getBill();
        existingBill.setTax(reservation.getBill().getTax());
        existingBill.setRoomTotalPrice(reservation.getBill().getRoomTotalPrice());
        existingBill.setDate(reservation.getBill().getDate());
        existingBill.setAmount(reservation.getBill().getAmount());

        return this.reservationRepository.save(existingReservation);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Reservation> deleteReservation(@PathVariable ("id") long reservationId){
        Reservation existingReservation = this.reservationRepository.findById(reservationId)
                .orElseThrow(() -> new ResourceNotFoundException("Reservation not found with id: " + reservationId));

        Room existingRoom = this.roomRepository.findById(existingReservation.getRoom_id()).orElseThrow(() -> new ResourceNotFoundException("Room not found with id: " + existingReservation.getRoom_id()));
        existingRoom.setRoom_status("Vacant");

        this.reservationRepository.delete(existingReservation);

        return ResponseEntity.ok().build();
    }
}
