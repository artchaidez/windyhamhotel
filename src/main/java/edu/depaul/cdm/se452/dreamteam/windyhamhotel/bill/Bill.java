package edu.depaul.cdm.se452.dreamteam.windyhamhotel.bill;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
public class Bill implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long bill_id;
    private String date;
    private String tax;
    private String roomTotalPrice;
    private String amount;

    public Bill(String date, String tax, String roomTotalPrice, String amount) {
        this.date = date;
        this.tax = tax;
        this.roomTotalPrice = roomTotalPrice;
        this.amount = amount;
    }

    //    public Bill(String date, Strubg amount) {
//        this.date = date;
//        this.amount = amount;
//    }

    public Bill() {

    }

}
