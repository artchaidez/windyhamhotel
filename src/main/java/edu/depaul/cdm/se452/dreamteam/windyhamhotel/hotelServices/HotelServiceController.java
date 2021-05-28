package edu.depaul.cdm.se452.dreamteam.windyhamhotel.hotelServices;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import edu.depaul.cdm.se452.dreamteam.windyhamhotel.exception.ResourceNotFoundException;
import edu.depaul.cdm.se452.dreamteam.windyhamhotel.service.SequenceGeneratorService;

@RestController
@RequestMapping("/api/v1/hotelServices")
@CrossOrigin(origins = "http://localhost:8081")
public class HotelServiceController {
    @Autowired
    private HotelServiceRepository hotelServiceRepository;

//    @Autowired
//    private SequenceGeneratorService sequenceGeneratorService;
    @GetMapping
    public List<HotelService> getAllServices() {
        return this.hotelServiceRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<HotelService> getServiceById(@PathVariable(value = "id") Long serviceId) 
    throws ResourceNotFoundException {
        HotelService hotelService = hotelServiceRepository.findById(serviceId)
        .orElseThrow(() -> new ResourceNotFoundException("HotelService not found with id: " + serviceId));

        return ResponseEntity.ok().body(hotelService);

    }

    @PostMapping
    public HotelService createService(@Valid @RequestBody HotelService hotelService) {
//        hotelService.setId(sequenceGeneratorService.generateSequence(hotelService.SEQUENCE_NAME));
        return hotelServiceRepository.save(hotelService);
    }


//    @PutMapping("/{id}")
//    public ResponseEntity<HotelService> updateService(@ Valid @RequestBody HotelService hotelService, @PathVariable ("id") Long serviceId)
//    throws ResourceNotFoundException {
//        HotelService existingService = hotelServiceRepository.findById(serviceId)
//        .orElseThrow(() -> new ResourceNotFoundException("Seevice not found with id: " + serviceId));
//
//        existingService.setGuest(hotelService.getGuest());
//        existingService.setName(hotelService.getName());
//        existingService.setDuration(hotelService.getDuration());
//        final HotelService updateHotelService = hotelServiceRepository.save(hotelService);
//        return ResponseEntity.ok(updateHotelService);
//    }
        @PutMapping("/{id}")
        public HotelService updateService(@ Valid @RequestBody HotelService hotelService, @PathVariable ("id") Long serviceId)
                throws ResourceNotFoundException {
            HotelService existingService = hotelServiceRepository.findById(serviceId)
                    .orElseThrow(() -> new ResourceNotFoundException("Seevice not found with id: " + serviceId));

            existingService.setName(hotelService.getName());
            existingService.setHour(hotelService.getHour());
            existingService.setDescription(hotelService.getDescription());
            return hotelServiceRepository.save(existingService);
        }

    @DeleteMapping("/{id}")
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
