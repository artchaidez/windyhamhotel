package edu.depaul.cdm.se452.dreamteam.windyhamhotel.drink;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DrinkRepository extends MongoRepository<Drink, Long> {
    
}
