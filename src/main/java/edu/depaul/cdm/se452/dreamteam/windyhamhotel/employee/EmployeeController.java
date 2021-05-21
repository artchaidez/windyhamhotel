package edu.depaul.cdm.se452.dreamteam.windyhamhotel.employee;

import edu.depaul.cdm.se452.dreamteam.windyhamhotel.account.Account;
import edu.depaul.cdm.se452.dreamteam.windyhamhotel.address.Address;
import edu.depaul.cdm.se452.dreamteam.windyhamhotel.contact.Contact;
import edu.depaul.cdm.se452.dreamteam.windyhamhotel.department.Department;
import edu.depaul.cdm.se452.dreamteam.windyhamhotel.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("api/employees")
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

        existingEmployee.setName(employee.getName());
        existingEmployee.setPosition(employee.getPosition());
        existingEmployee.setSalary(employee.getSalary());

        Account existingAccount = existingEmployee.getAccount();
        existingAccount.setAccountName(employee.getAccount().getAccountName());
        existingAccount.setAccountNumber(employee.getAccount().getAccountNumber());

        Contact existingContact = existingEmployee.getContact();
        existingContact.setBirth(employee.getContact().getBirth());
        existingContact.setEmail(employee.getContact().getEmail());
        existingContact.setGender(employee.getContact().getGender());
        existingContact.setName(employee.getContact().getName());
        existingContact.setPhone(employee.getContact().getPhone());

        Address existingAddress = existingEmployee.getContact().getAddress();
        existingAddress.setState(employee.getContact().getAddress().getState());
        existingAddress.setCity(employee.getContact().getAddress().getCity());
        existingAddress.setStreet(employee.getContact().getAddress().getStreet());
        existingAddress.setZipCode(employee.getContact().getAddress().getZipCode());

        Department existingDepartment = existingEmployee.getDepartment();
        existingDepartment.setDepartmentName(employee.getDepartment().getDepartmentName());

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
