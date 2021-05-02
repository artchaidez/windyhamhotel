package edu.depaul.cdm.se452.dreamteam.windyhamhotel;

import edu.depaul.cdm.se452.dreamteam.windyhamhotel.entity.Reservation;
import edu.depaul.cdm.se452.dreamteam.windyhamhotel.entity.Room;
import edu.depaul.cdm.se452.dreamteam.windyhamhotel.repository.ReservationRepository;
import edu.depaul.cdm.se452.dreamteam.windyhamhotel.repository.RoomRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class WindyhamhotelApplication {

	public static void main(String[] args) {
		SpringApplication.run(WindyhamhotelApplication.class, args);
	}

	@Bean
	CommandLineRunner runner1(RoomRepository roomRepository) {
		return args -> {
			roomRepository.save(new Room(100, 200.00, "One Bed Room", "This is one bed room 100", "Vacant"));
			roomRepository.save(new Room(101, 210.00, "Two Bed Room", "This is two bed room 101", "Vacant"));
			roomRepository.save(new Room(102, 220.00, "One Bed Room", "This is one bed room 102", "Vacant"));
			roomRepository.save(new Room(103, 230.00, "Two Bed Room", "This is two bed room 103", "Vacant"));
			roomRepository.save(new Room(104, 240.00, "One Bed Room", "This is one bed room 104", "Vacant"));
		};
	}

	@Bean
	CommandLineRunner runner2(ReservationRepository reservationRepository) {
		return args -> {
			reservationRepository.save(new Reservation(2,1,2,"2012-5-1", "2021-5-3", 100, 1, 600.00));
			reservationRepository.save(new Reservation(1,0,3,"2012-5-1", "2021-5-4", 101, 2, 700.00));
			reservationRepository.save(new Reservation(3,2,4,"2012-5-1", "2021-5-5", 102, 3, 800.00));
			reservationRepository.save(new Reservation(2,1,5,"2012-5-1", "2021-5-6", 103, 4, 900.00));
		};
	}

}
