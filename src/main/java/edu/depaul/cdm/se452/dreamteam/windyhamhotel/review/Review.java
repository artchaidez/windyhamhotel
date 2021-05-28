package edu.depaul.cdm.se452.dreamteam.windyhamhotel.review;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
@Data
@Document(collection = "reviews")
public class Review {

    @org.springframework.data.annotation.Transient
    public static final String SEQUENCE_NAME = "complaint_sequences";

    @Id
    private Long id;

    private String name;
    private String rating;
    private String date;
    private String comment;


    public Review(){}

    public Review(String name, String rating, String date, String comment) {
        this.name = name;
        this.rating = rating;
        this.date = date;
        this.comment = comment;
    }

    public static String getSequenceName() {
        return SEQUENCE_NAME;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
