package edu.depaul.cdm.se452.dreamteam.windyhamhotel.department;

import lombok.Data;
import java.io.Serializable;
import javax.persistence.*;

@Entity
@Data
@Table(name = "departments")
public class Department implements Serializable 
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int departmentID;
    private String departmentName;

    public Department(String departmentName)
    {
        this.departmentName = departmentName;
    }

    public Department() {

    }

    public int getDepartmentID()
    {
        return departmentID;
    }
    public void setDepartmentID(int departmentID)
    {
        this.departmentID = departmentID;
    }

    public String getDepartmentName()
    {
        return departmentName;
    }
    public void setDepartmentName(String departmentName)
    {
        this.departmentName = departmentName;
    }


}
