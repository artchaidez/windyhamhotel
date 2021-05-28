package edu.depaul.cdm.se452.dreamteam.windyhamhotel.employee;

import edu.depaul.cdm.se452.dreamteam.windyhamhotel.account.Account;
import edu.depaul.cdm.se452.dreamteam.windyhamhotel.contact.Contact;
import edu.depaul.cdm.se452.dreamteam.windyhamhotel.department.Department;

import lombok.Data;
import javax.persistence.*;

import java.io.Serializable;

@Data
@Entity
@Table(name = "employees")
public class Employee implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int employee_id;

    private String name;
    private Double salary;
    private String position;

    @OneToOne(cascade = CascadeType.ALL)
    private Contact contact; 

    @OneToOne(cascade = CascadeType.ALL)
    private Department department;

    @OneToOne(cascade = CascadeType.ALL)
    private Account account;

    public Employee(String name, Double salary, String position,
    Contact contact, Department department, Account account)
    {
        this.name = name;
        this.salary = salary;
        this.position = position;
        this.contact = contact;
        this.department = department;
        this.account = account;
    }

    public Employee(){

    }

    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }

    public Double getSalary()
    {
        return salary;
    }
    public void setSalary(Double salary)
    {
        this.salary = salary;
    }

    public String getPosition()
    {
        return position;
    }
    public void setPosition(String position)
    {
        this.position = position;
    }
    
    public Contact getContact()
    {
        return contact;
    }
    public void setContact(Contact contact)
    {
        this.contact = contact;
    } 

    public Department getDepartment()
    {
        return department;
    }
    public void setDepartment(Department department)
    {
        this.department = department;
    }
    
    public Account getAccount()
    {
        return account;
    }
    public void setAccount(Account account)
    {
        this.account = account;
    }
    
}
