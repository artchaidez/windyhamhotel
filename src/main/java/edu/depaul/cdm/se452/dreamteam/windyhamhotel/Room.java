package edu.depaul.cdm.se452.dreamteam.windyhamhotel;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name = "Room")
public class Room extends Reservation
{
    @Column(name = "room_number")
    public int      room_number;

    @Column(name = "price")
    public Double   room_price;

    @Column(name = "type")
    public String   room_type;

    @Column(name = "description")
    public String   room_description;

    @Column(name = "status")
    public Boolean  room_status;
}
