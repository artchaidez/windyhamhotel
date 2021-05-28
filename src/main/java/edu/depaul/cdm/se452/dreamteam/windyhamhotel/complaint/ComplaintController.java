package edu.depaul.cdm.se452.dreamteam.windyhamhotel.complaint;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import edu.depaul.cdm.se452.dreamteam.windyhamhotel.drink.Drink;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import edu.depaul.cdm.se452.dreamteam.windyhamhotel.exception.ResourceNotFoundException;
import edu.depaul.cdm.se452.dreamteam.windyhamhotel.service.SequenceGeneratorService;

@RestController
@RequestMapping("/api/v1/complaints")
@CrossOrigin(origins = "http://localhost:8081")
public class ComplaintController {
    @Autowired
    private ComplaintRepository complaintRepository;

    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

    @GetMapping
    public List<Complaint> getAllComplaints() {
        return this.complaintRepository.findAll();
    }


    @GetMapping("/{id}")
    public ResponseEntity<Complaint> getCpmlaintById(@PathVariable(value = "id") Long complaintId)
    throws ResourceNotFoundException {
        Complaint complaint = complaintRepository.findById(complaintId)
        .orElseThrow(() -> new ResourceNotFoundException("Comlaint not found with id: " + complaintId));

        return ResponseEntity.ok().body(complaint);

    }

    @PostMapping
    public Complaint createComlaint(@Valid @RequestBody Complaint complaint) {
        complaint.setId(sequenceGeneratorService.generateSequence(complaint.SEQUENCE_NAME));
        return complaintRepository.save(complaint);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Complaint> updateComplaint(@ Valid @RequestBody Complaint complaint, @PathVariable ("id") Long complaintId)
    throws ResourceNotFoundException {
        Complaint existingComplaint = complaintRepository.findById(complaintId)
        .orElseThrow(() -> new ResourceNotFoundException("Complaint not found with id: " + complaintId));

        existingComplaint.setFirstname(complaint.getFirstname());
        existingComplaint.setLastname(complaint.getLastname());
        existingComplaint.setEmail(complaint.getEmail());
        existingComplaint.setPhone(complaint.getPhone());
        existingComplaint.setReason(complaint.getReason());
        existingComplaint.setDetails(complaint.getDetails());
        final Complaint updatedComplaint = complaintRepository.save(existingComplaint);
        return ResponseEntity.ok(updatedComplaint);

    }

    @DeleteMapping("/{id}")
    public Map<String, Boolean> deleteComplaint(@PathVariable ("id") Long complaintId) 
    throws ReflectiveOperationException {

        Complaint existingDrink = complaintRepository.findById(complaintId)
                .orElseThrow(() -> new ResourceNotFoundException("Drink not found with id: " + complaintId));

        complaintRepository.delete(existingDrink);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
