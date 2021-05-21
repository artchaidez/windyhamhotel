package edu.depaul.cdm.se452.dreamteam.windyhamhotel.complaint;

import javax.persistence.Id;

import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "Drink")
public class Complaint {
    
    @Transient
    public static final String SEQUENCE_NAME = "complaint_sequences";

    @Id
    private Long id;
    private String date;
    private String problem;

    public Complaint() {}

    public Complaint(String date, String problem) {
        this.date = date;
        this.problem = problem;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getProblem() {
        return problem;
    }

    public void setProblem(String problem) {
        this.problem = problem;
    }
}
