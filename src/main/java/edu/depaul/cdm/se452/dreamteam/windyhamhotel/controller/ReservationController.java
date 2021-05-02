package edu.depaul.cdm.se452.dreamteam.windyhamhotel.controller;

import edu.depaul.cdm.se452.dreamteam.windyhamhotel.entity.Reservation;
import edu.depaul.cdm.se452.dreamteam.windyhamhotel.exception.ResourceNotFoundException;
import edu.depaul.cdm.se452.dreamteam.windyhamhotel.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController {
    @Autowired
    private ReservationRepository reservationRepository;

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
        return this.reservationRepository.save(reservation);
    }


    @PutMapping("/{id}")
    public Reservation updateReservation(@RequestBody Reservation reservation, @PathVariable ("id") long reservationId){
        Reservation existingReservation = this.reservationRepository.findById(reservationId)
                .orElseThrow(() -> new ResourceNotFoundException("Reservation not found with id: " + reservationId));

        System.out.println(existingReservation.getAdult());

        existingReservation.setAdult(reservation.getAdult());
        existingReservation.setAmount(reservation.getAmount());
        existingReservation.setChild(reservation.getChild());
        existingReservation.setCheckin(reservation.getCheckin());
        existingReservation.setCheckout(reservation.getCheckout());
        existingReservation.setDays(reservation.getDays());
        existingReservation.setGuest_id(reservation.getGuest_id());
        existingReservation.setRoom_number(reservation.getRoom_number());

        return this.reservationRepository.save(existingReservation);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Reservation> deleteReservation(@PathVariable ("id") long reservationId){
        Reservation existingReservation = this.reservationRepository.findById(reservationId)
                .orElseThrow(() -> new ResourceNotFoundException("Reservation not found with id: " + reservationId));

        this.reservationRepository.delete(existingReservation);

        return ResponseEntity.ok().build();
    }
}
