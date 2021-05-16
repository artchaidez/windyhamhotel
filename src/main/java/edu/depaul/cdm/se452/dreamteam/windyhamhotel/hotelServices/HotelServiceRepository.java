package edu.depaul.cdm.se452.dreamteam.windyhamhotel.hotelServices;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface HotelServiceRepository extends MongoRepository<HotelService, Long> {

}

