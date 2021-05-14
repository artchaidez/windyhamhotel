package edu.depaul.cdm.se452.dreamteam.windyhamhotel.employee;

import edu.depaul.cdm.se452.dreamteam.windyhamhotel.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("api/employee")
@CrossOrigin(origins = "http://localhost:8081")
public class EmployeeController 
{
    @Autowired
    private EmployeeRepository employeeRepository;

    // get all employees
    @GetMapping
    public List<Employee> getAllEmployees()
    {
        return this.employeeRepository.findAll();
    }

    // get specific employee
    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable(value = "id") int employeeId)
    {
        return this.employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + employeeId));
    }

    // add employee
    @PostMapping
    public Employee createNewEmployee(@RequestBody Employee employee) 
    {
        return this.employeeRepository.save(employee);
    }
    
    @PutMapping("/{id}")
    public Employee updateEmployee(@RequestBody Employee employee, @PathVariable(value = "id") int employeeId)
    {
        Employee existingEmployee = this.employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + employeeId));

        // NOTE: Might not need all this.
        //existingEmployee.setEmployee_id(employee.getEmployee_id());
        //existingEmployee.setPassword(employee.getPassword());
        //existingEmployee.setName(employee.getName());
        //existingEmployee.setSalary(employee.getSalary());
        //existingEmployee.setPosition(employee.getPosition());
        
        //existingEmployee.setContact(employee.getContact());

        return this.employeeRepository.save(existingEmployee);
    }

    // delete employee
    @DeleteMapping("/{id}")
    public ResponseEntity<Employee> deleteEmployee(@PathVariable(value = "id") int employeeId)
    {
        Employee existEmployee = this.employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + employeeId));

        this.employeeRepository.delete(existEmployee);

        return ResponseEntity.ok().build();
    }


}
