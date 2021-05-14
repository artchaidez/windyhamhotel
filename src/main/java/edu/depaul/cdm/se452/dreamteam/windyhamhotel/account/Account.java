package edu.depaul.cdm.se452.dreamteam.windyhamhotel.account;

import lombok.Data;
import java.io.Serializable;
import javax.persistence.*;


@Entity
@Data
@Table(name = "account")
public class Account implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long accountNumber; // told to make this long

    private String accountName;

    public Account (long accountNumber, String accountName)
    {
        this.accountNumber = accountNumber;
        this.accountName = accountName;
    }

    public Account() {

    }

    public long getAccountNumber()
    {
        return accountNumber;
    }
    public void setAccountNumber(long accountNumber)
    {
        this.accountNumber = accountNumber;
    }

    public String getAccountName()
    {
        return accountName;
    }
    public void setAccountName(String accountName)
    {
        this.accountName = accountName;
    }
}
