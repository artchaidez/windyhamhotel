package edu.depaul.cdm.se452.dreamteam.windyhamhotel.room;


import edu.depaul.cdm.se452.dreamteam.windyhamhotel.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/rooms")
@CrossOrigin(origins = "http://localhost:8081")
public class RoomController {

    @Autowired
    private RoomRepository roomRepository;


    @GetMapping("hotel/{id}/available")
    public List<Room> getAvaiableRoomAndTypeByHotel(@PathVariable(value = "id") int hotelId) {
        List<Room> rooms = this.roomRepository.findRoomByHotelId(hotelId);
        Map<String, Room> availableRooms = new HashMap<>();

        for (Room room : rooms) {
            if (!availableRooms.containsKey(room.getRoom_type()) && room.getRoom_status() == "Vacant") {
                availableRooms.put(room.getRoom_type(), room);
            }
        }
        return new ArrayList<>(availableRooms.values());
    }

    // get all rooms
    @GetMapping
    public List<Room> getAllRooms() {
        return this.roomRepository.findAll();
    }

    // get a single room
    @GetMapping("/{id}")
    public Room getRoomById(@PathVariable(value = "id") int roomId) {
//        System.out.println("getRoomById");
        return this.roomRepository.findById(roomId)
                .orElseThrow(() -> new ResourceNotFoundException("Room not found with id: " + roomId));
    }

    // add a room
    @PostMapping
    public Room createRoom(@RequestBody Room room) {
        return this.roomRepository.save(room);
    }

    // update a room
    @PutMapping("/{id}")
    public Room updateRoom(@RequestBody Room room, @PathVariable(value = "id") int roomId) {
        Room existingRoom = this.roomRepository.findById(roomId)
                .orElseThrow(() -> new ResourceNotFoundException("Room not found with id: " + roomId));

        existingRoom.setRoom_description(room.getRoom_description());
        existingRoom.setRoom_number(room.getRoom_number());
        existingRoom.setRoom_price(room.getRoom_price());
        existingRoom.setRoom_status(room.getRoom_status());
        existingRoom.setRoom_type(room.getRoom_type());

        return this.roomRepository.save(existingRoom);
    }

    // delete a room
    @DeleteMapping("/{id}")
    public ResponseEntity<Room> deleteRoom(@PathVariable(value = "id") int roomId) {
        Room existingRoom = this.roomRepository.findById(roomId)
                .orElseThrow(() -> new ResourceNotFoundException("Room not found with id: " + roomId));

        this.roomRepository.delete(existingRoom);

        return ResponseEntity.ok().build();

    }
}