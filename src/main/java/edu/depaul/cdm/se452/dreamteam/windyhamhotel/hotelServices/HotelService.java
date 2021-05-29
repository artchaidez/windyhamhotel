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
@Document(collection = "hotelServices")
public class HotelService {
    @Id
    private long id;

    @NotBlank
    @Size(max=50)
    @Indexed(unique=true)
    private String name;

    private String hour;
    private String description;

    public HotelService(long id, @NotBlank @Size(max = 50) String name, String hour, String description) {
        this.id = id;
        this.name = name;
        this.hour = hour;
        this.description = description;
    }

    public HotelService() {}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
