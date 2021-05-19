package edu.depaul.cdm.se452.dreamteam.windyhamhotel.review;

import edu.depaul.cdm.se452.dreamteam.windyhamhotel.room.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {

}
