package edu.depaul.cdm.se452.dreamteam.windyhamhotel.food;

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
@RequestMapping("/api/v1")
@CrossOrigin(origins="http://localhost:8081")
public class FoodController {
    @Autowired
    private FoodRepository foodRepository;

//    @Autowired
//    private SequenceGeneratorService sequenceGeneratorService;

    @GetMapping("/foods")
    public List<Food> getAllFoods() {
        return this.foodRepository.findAll();
    }

    @GetMapping("/foods/{id}")
    public ResponseEntity<Food> getFoodById(@PathVariable(value = "id") Long foodId) 
    throws ResourceNotFoundException {
        Food food = foodRepository.findById(foodId)
        .orElseThrow(() -> new ResourceNotFoundException("Food not found with id: " + foodId));

        return ResponseEntity.ok().body(food);

    }

    @PostMapping("/foods")
    public Food createFood(@Valid @RequestBody Food food) {
//        food.setId(sequenceGeneratorService.generateSequence(food.SEQUENCE_NAME));
        return foodRepository.save(food);
    }


    @PutMapping("/foods/{id}")
    public ResponseEntity<Food> updateFood(@ Valid @RequestBody Food food, @PathVariable ("id") Long foodId)
    throws ResourceNotFoundException {
        Food existingFood = foodRepository.findById(foodId)
        .orElseThrow(() -> new ResourceNotFoundException("Food not found with id: " + foodId));

//        existingFood.setGuest(food.getGuest());
        existingFood.setType(food.getType());
        existingFood.setName(food.getName());
        existingFood.setPrice(food.getPrice());
        final Food updatedFood = foodRepository.save(existingFood);
        return ResponseEntity.ok(updatedFood);

    }

    @DeleteMapping("/foods/{id}")
    public Map<String, Boolean> deleteFood(@PathVariable ("id") Long foodId) 
    throws ReflectiveOperationException {

        Food existingFood = foodRepository.findById(foodId)
                .orElseThrow(() -> new ResourceNotFoundException("Food not found with id: " + foodId));

        foodRepository.delete(existingFood);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
