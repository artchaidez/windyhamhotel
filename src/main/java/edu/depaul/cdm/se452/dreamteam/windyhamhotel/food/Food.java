package edu.depaul.cdm.se452.dreamteam.windyhamhotel.food;

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
@Document(collection = "Food")
public class Food {

//    @Transient
//    public static final String SEQUENCE_NAME = "foods_sequences";

    @Id
    private long id;

//    @OneToOne(cascade = CascadeType.ALL)
//    private Guest guest;

    @NotBlank
    @Size(max=100)
    @Indexed(unique=true)
    private String name;

    private String type;

    private double price;

    

    public Food(){}

//    public Food(Guest guest, String name, double price) {
//        this.guest = guest;
//        this.name = name;
//        this.price = price;
//    }


//    public Food(@NotBlank @Size(max = 100) String name, double price) {
//        this.name = name;
//        this.price = price;
//    }


    public Food(long id, @NotBlank @Size(max = 100) String name, String type, double price) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.price = price;
    }

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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setType(String type) {
        this.type = type;
    }


    public String getType() {
        return type;
    }
}
