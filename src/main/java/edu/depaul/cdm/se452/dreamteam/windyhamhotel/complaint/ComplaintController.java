package edu.depaul.cdm.se452.dreamteam.windyhamhotel.complaint;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.depaul.cdm.se452.dreamteam.windyhamhotel.exception.ResourceNotFoundException;
import edu.depaul.cdm.se452.dreamteam.windyhamhotel.service.SequenceGeneratorService;

@RestController
@RequestMapping("/api/v1")
public class ComplaintController {
    @Autowired
    private ComplaintRepository complaintRepository;

    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

    @GetMapping("/complaints")
    public List<Complaint> getAllComplaints() {
        return this.complaintRepository.findAll();
    }

    @GetMapping("/complaints/{id}")
    public ResponseEntity<Complaint> getCpmlaintById(@PathVariable(value = "id") Long complaintId) 
    throws ResourceNotFoundException {
        Complaint complaint = complaintRepository.findById(complaintId)
        .orElseThrow(() -> new ResourceNotFoundException("Comlaint not found with id: " + complaintId));

        return ResponseEntity.ok().body(complaint);

    }

    @PostMapping("/complaints")
    public Complaint createComlaint(@Valid @RequestBody Complaint complaint) {
        complaint.setId(sequenceGeneratorService.generateSequence(complaint.SEQUENCE_NAME));
        return complaintRepository.save(complaint);
    }


    @PutMapping("/complaints/{id}")
    public ResponseEntity<Complaint> updateComplaint(@ Valid @RequestBody Complaint complaint, @PathVariable ("id") Long complaintId)
    throws ResourceNotFoundException {
        Complaint existingComplaint = complaintRepository.findById(complaintId)
        .orElseThrow(() -> new ResourceNotFoundException("Complaint not found with id: " + complaintId));

        existingComplaint.setDate(complaint.getDate());
        existingComplaint.setProblem(complaint.getProblem());
        final Complaint updatedComplaint = complaintRepository.save(complaint);
        return ResponseEntity.ok(updatedComplaint);

    }

    @DeleteMapping("/complaints/{id}")
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
