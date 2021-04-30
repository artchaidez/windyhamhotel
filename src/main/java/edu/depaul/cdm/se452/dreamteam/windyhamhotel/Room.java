package edu.depaul.cdm.se452.dreamteam.windyhamhotel;

import lombok.Data;

@Data
public class Room extends Reservation
{
    public int      id;
    public Double   price;
    public int      room_number;
    public String   room_type;
    public String   room_description;
    public Boolean  room_status;
}
