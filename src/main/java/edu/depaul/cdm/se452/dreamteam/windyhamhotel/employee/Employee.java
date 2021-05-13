package edu.depaul.cdm.se452.dreamteam.windyhamhotel.employee;

import edu.depaul.cdm.se452.dreamteam.windyhamhotel.contact.Contact;
import edu.depaul.cdm.se452.dreamteam.windyhamhotel.guest.Guest;
import edu.depaul.cdm.se452.dreamteam.windyhamhotel.room.Room;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "Employee")
public class Employee {
    @Id
    public int employee_id;

    private String password;
    private String name;
    private Double salary;
    private String position;
    //private Department department;
    //private Account Account;

    /*
    @OneToOne(cascade = CascadeType.ALL)
    private Guest guest_id; */

    // Contact needs to work as shown above
    //private Contact contact;

    // TODO: add contact after employee works
    public Employee(int employee_id, String password, String name, Double salary, String position) 
    {
        this.employee_id = employee_id;
        this.password = password;
        this.name = name;
        this.salary = salary;
        this.position = position;
        //this.contact = contact;
    }

    public Employee(){

    }

    //public int employee_id;
    public int getEmployee_id()
    {
        return employee_id;
    }
    public void setEmployee_id(int employee_id)
    {
        this.employee_id = employee_id;
    }
    //private String password;
    public String getPassword()
    {
        return password;
    }
    public void setPassword(String password)
    {
        this.password = password;
    }
    //private String name;
    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    //private Double salary;
    public Double getSalary()
    {
        return salary;
    }
    public void setSalary(Double salary)
    {
        this.salary = salary;
    }
    //private String position;
    public String getPosition()
    {
        return position;
    }
    public void setPosition(String position)
    {
        this.position = position;
    }
    //private Contact contact;
    /*
    public Contact getContact()
    {
        return contact;
    }
    public void setContact(Contact contact)
    {
        this.contact = contact;
    }
    */
    
}
