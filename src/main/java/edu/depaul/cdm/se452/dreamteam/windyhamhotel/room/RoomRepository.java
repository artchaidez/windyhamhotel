package edu.depaul.cdm.se452.dreamteam.windyhamhotel.room;



import edu.depaul.cdm.se452.dreamteam.windyhamhotel.room.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<Room, Integer> {

}