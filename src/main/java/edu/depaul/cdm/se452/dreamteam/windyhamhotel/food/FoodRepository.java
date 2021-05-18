package edu.depaul.cdm.se452.dreamteam.windyhamhotel.food;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodRepository extends MongoRepository<Food, Long> {
    
}
