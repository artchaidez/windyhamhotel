package edu.depaul.cdm.se452.dreamteam.windyhamhotel.drink;

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
public class DrinkController {
    @Autowired
    private DrinkRepository drinkRepository;

    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

    @GetMapping("/drinks")
    public List<Drink> getAllDrinks() {
        return this.drinkRepository.findAll();
    }

    @GetMapping("/drinks/{id}")
    public ResponseEntity<Drink> getDrinkById(@PathVariable(value = "id") Long drinkId) 
    throws ResourceNotFoundException {
        Drink drink = drinkRepository.findById(drinkId)
        .orElseThrow(() -> new ResourceNotFoundException("Drink not found with id: " + drinkId));

        return ResponseEntity.ok().body(drink);

    }

    @PostMapping("/drinks")
    public Drink createDrink(@Valid @RequestBody Drink drink) {
        drink.setId(sequenceGeneratorService.generateSequence(drink.SEQUENCE_NAME));
        return drinkRepository.save(drink);
    }


    @PutMapping("/drinks/{id}")
    public ResponseEntity<Drink> updateDrink(@ Valid @RequestBody Drink drink, @PathVariable ("id") Long drinkId)
    throws ResourceNotFoundException {
        Drink existingDrink = drinkRepository.findById(drinkId)
        .orElseThrow(() -> new ResourceNotFoundException("Drink not found with id: " + drinkId));

        existingDrink.setGuest(drink.getGuest());
        existingDrink.setName(drink.getName());
        existingDrink.setPrice(drink.getPrice());
        final Drink updatedDrink = drinkRepository.save(drink);
        return ResponseEntity.ok(updatedDrink);

    }

    @DeleteMapping("/drinks/{id}")
    public Map<String, Boolean> deleteDrink(@PathVariable ("id") Long drinkId) 
    throws ReflectiveOperationException {

        Drink existingDrink = drinkRepository.findById(drinkId)
                .orElseThrow(() -> new ResourceNotFoundException("Drink not found with id: " + drinkId));

        drinkRepository.delete(existingDrink);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
