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

    public long getBill_id() {
        return bill_id;
    }

    public void setBill_id(long bill_id) {
        this.bill_id = bill_id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTax() {
        return tax;
    }

    public void setTax(String tax) {
        this.tax = tax;
    }

    public String getRoomTotalPrice() {
        return roomTotalPrice;
    }

    public void setRoomTotalPrice(String roomTotalPrice) {
        this.roomTotalPrice = roomTotalPrice;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
