package edu.depaul.cdm.se452.dreamteam.windyhamhotel.complaint;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ComplaintRepository extends MongoRepository<Complaint, Long> {
    
}
