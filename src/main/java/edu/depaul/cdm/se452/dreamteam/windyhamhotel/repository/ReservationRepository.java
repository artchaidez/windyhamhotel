package edu.depaul.cdm.se452.dreamteam.windyhamhotel.repository;

import edu.depaul.cdm.se452.dreamteam.windyhamhotel.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}
