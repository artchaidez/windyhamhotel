package edu.depaul.cdm.se452.dreamteam.windyhamhotel.contact;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<Contact, String>{
    
}
