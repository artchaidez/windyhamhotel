package edu.depaul.cdm.se452.dreamteam.windyhamhotel.review;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document (collection = "Review")
public class Review {

    @Transient
    public static final String SEQUENCE_NAME = "reviews_sequences";

    @Id
    private long id;
    
    @NotBlank
    @Size(max=100)
    @Indexed(unique=true)
    private String name;

    @NotBlank
    @Size(max=100)
    @Indexed(unique=true)
    private String review;

    private String date;

    public Review() {}

    public Review(String name, String review,String date) {
        this.name = name;
        this.review = review;
        this.date = date;
    }    
}
