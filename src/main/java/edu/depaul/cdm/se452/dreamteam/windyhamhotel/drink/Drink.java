package edu.depaul.cdm.se452.dreamteam.windyhamhotel.drink;

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
@Document(collection = "Drink")
public class Drink {

    @Transient
    public static final String SEQUENCE_NAME = "drinks_sequences";

    @Id
    private long id;

    @OneToOne(cascade = CascadeType.ALL)
    private Guest guest;

    @NotBlank
    @Size(max=100)
    @Indexed(unique=true)
    private String name;

    private double price;

    

    public Drink(){}

    public Drink(Guest guest, String name, double price) {
        this.guest = guest;
        this.name = name;
        this.price = price;
    }


    
}
