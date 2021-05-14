package edu.depaul.cdm.se452.dreamteam.windyhamhotel.contact;

import edu.depaul.cdm.se452.dreamteam.windyhamhotel.employee.Employee;
import edu.depaul.cdm.se452.dreamteam.windyhamhotel.employee.EmployeeRepository;
import edu.depaul.cdm.se452.dreamteam.windyhamhotel.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contact")
@CrossOrigin(origins = "http://localhost:8081")
public class ContactController 
{
    @Autowired
    private ContactRepository contactRepository;
    
    @GetMapping
    public List<Contact> getAllContacts()
    {
        return this.contactRepository.findAll();
    }

    //NOTE: may not be needed?
    @GetMapping("/{id}")
    public Contact getContactByID(@PathVariable(value = "id") String name)
    {
        return this.contactRepository.findById(name)
                .orElseThrow(() -> new ResourceNotFoundException("Contact not found with id: " + name));
    }

    // NOTE: Contact only made when employee made?
}
