package edu.depaul.cdm.se452.dreamteam.windyhamhotel.hotelServices;

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
public class HotelServiceController {
    @Autowired
    private HotelServiceRepository hotelServiceRepository;

    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

    @GetMapping("/hotelServices")
    public List<HotelService> getAllServices() {
        return this.hotelServiceRepository.findAll();
    }

    @GetMapping("/hotelServices/{id}")
    public ResponseEntity<HotelService> getServiceById(@PathVariable(value = "id") Long serviceId) 
    throws ResourceNotFoundException {
        HotelService hotelService = hotelServiceRepository.findById(serviceId)
        .orElseThrow(() -> new ResourceNotFoundException("HotelService not found with id: " + serviceId));

        return ResponseEntity.ok().body(hotelService);

    }

    @PostMapping("/hotelServices")
    public HotelService createService(@Valid @RequestBody HotelService hotelService) {
        hotelService.setId(sequenceGeneratorService.generateSequence(hotelService.SEQUENCE_NAME));
        return hotelServiceRepository.save(hotelService);
    }


    @PutMapping("/hotelServices/{id}")
    public ResponseEntity<HotelService> updateService(@ Valid @RequestBody HotelService hotelService, @PathVariable ("id") Long serviceId)
    throws ResourceNotFoundException {
        HotelService existingService = hotelServiceRepository.findById(serviceId)
        .orElseThrow(() -> new ResourceNotFoundException("Seevice not found with id: " + serviceId));

        existingService.setGuest(hotelService.getGuest());
        existingService.setName(hotelService.getName());
        existingService.setDuration(hotelService.getDuration());
        final HotelService updateHotelService = hotelServiceRepository.save(hotelService);
        return ResponseEntity.ok(updateHotelService);

    }

    @DeleteMapping("/hotelServices/{id}")
    public Map<String, Boolean> deleteService(@PathVariable ("id") Long serviceId) 
    throws ReflectiveOperationException {

        HotelService existingService = hotelServiceRepository.findById(serviceId)
                .orElseThrow(() -> new ResourceNotFoundException("HotelService not found with id: " + serviceId));

        hotelServiceRepository.delete(existingService);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
