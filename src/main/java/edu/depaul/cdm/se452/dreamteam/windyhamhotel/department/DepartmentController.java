package edu.depaul.cdm.se452.dreamteam.windyhamhotel.department;

//import edu.depaul.cdm.se452.dreamteam.windyhamhotel.department.Department;
//import edu.depaul.cdm.se452.dreamteam.windyhamhotel.department.DepartmentRepository;
import edu.depaul.cdm.se452.dreamteam.windyhamhotel.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/department")
@CrossOrigin(origins = "http://localhost:8081")
public class DepartmentController 
{
    @Autowired
    private DepartmentRepository departmentRepository;

    @GetMapping
    public List<Department> getAllDepartments()
    {
        return this.departmentRepository.findAll();
    }

    //NOTE: may not be needed?
    @GetMapping("/{id}")
    public Department getDepartmentByID(@PathVariable(value = "id") int departmentID)
    {
        return this.departmentRepository.findById(departmentID)
                .orElseThrow(() -> new ResourceNotFoundException("Department not found with id: " + departmentID));
    }

    

    
}
