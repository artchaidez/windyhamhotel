package edu.depaul.cdm.se452.dreamteam.windyhamhotel.contact;

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
    //TODO: Needs to be EmployeeRepository 
    @Autowired
    private ContactRepository contactRepository;
    
    // TODO: need to update Employee first
    @GetMapping
    public List<Contact> getAllContacts()
    {
        return this.contactRepository.findAll();
    }
}
