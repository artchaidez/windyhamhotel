package edu.depaul.cdm.se452.dreamteam.windyhamhotel.hotelServices;

import javax.persistence.CascadeType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import edu.depaul.cdm.se452.dreamteam.windyhamhotel.guest.Guest;
import lombok.Data;

@Data
@Document(collection = "HotelServices")
public class HotelService {

    @Transient
    public static final String SEQUENCE_NAME = "services_sequences";

    @Id
    private long id;

    @OneToOne(cascade = CascadeType.ALL)
    private Guest guest;

    @NotBlank
    @Size(max=50)
    @Indexed(unique=true)
    private String name;

    private String date;
    private String duration;

    public HotelService() {}

    public HotelService(Guest guest, String name, String date, String duration) {
        this.guest = guest;
        this.name = name;
        this.date = date;
        this.duration = duration;
    }

    
}
