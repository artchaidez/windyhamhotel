package edu.depaul.cdm.se452.dreamteam.windyhamhotel.room;



import edu.depaul.cdm.se452.dreamteam.windyhamhotel.hotel.Hotel;
import edu.depaul.cdm.se452.dreamteam.windyhamhotel.room.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room, Integer> {
    List<Room> findRoomByHotelId(long hotel_id);
}