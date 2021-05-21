package edu.depaul.cdm.se452.dreamteam.windyhamhotel.guest;

/* NOTE: Made this on accident, meant to make EmployeeRepository. 
Will leave blank for now- Arturo Chaidez */
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuestRepository extends JpaRepository<Guest, Integer>{

}
