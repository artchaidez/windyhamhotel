package edu.depaul.cdm.se452.dreamteam.windyhamhotel;

import edu.depaul.cdm.se452.dreamteam.windyhamhotel.Reservation.Reservation;
import edu.depaul.cdm.se452.dreamteam.windyhamhotel.Reservation.ReservationRepository;
import edu.depaul.cdm.se452.dreamteam.windyhamhotel.bill.Bill;
import edu.depaul.cdm.se452.dreamteam.windyhamhotel.guest.Guest;
import edu.depaul.cdm.se452.dreamteam.windyhamhotel.hotel.Hotel;
import edu.depaul.cdm.se452.dreamteam.windyhamhotel.hotel.HotelRepository;
import edu.depaul.cdm.se452.dreamteam.windyhamhotel.address.Address;
import edu.depaul.cdm.se452.dreamteam.windyhamhotel.address.AddressRepository;
import edu.depaul.cdm.se452.dreamteam.windyhamhotel.room.Room;
import edu.depaul.cdm.se452.dreamteam.windyhamhotel.room.RoomRepository;
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
	CommandLineRunner runner1(HotelRepository hotelRepository, AddressRepository hotelAddressRepository, RoomRepository roomRepository) {
		return args -> {
			Address address1 = new Address("IL", "Chicago", "4141 N State", "60601");
			Hotel hotel1 = new Hotel("WindyHam-Chicago", address1);
			hotelRepository.save(hotel1);
			roomRepository.save(new Room(100, 200.00, "VIP Room", "This is room 100", "Vacant", hotel1));
			roomRepository.save(new Room(101, 210.00, "Regular Room", "This is room 101", "Vacant", hotel1));
			roomRepository.save(new Room(102, 220.00, "Suite", "This is room 102", "Vacant", hotel1));
			roomRepository.save(new Room(103, 230.00, "VIP Room", "This is room 103", "Vacant", hotel1));
			roomRepository.save(new Room(104, 240.00, "Regular Room", "This is room 104", "Vacant", hotel1));


			Address address2 = new Address("NY", "New York", "4141 N State", "60601");
			Hotel hotel2 = new Hotel("WindyHam-New York", address2);
			hotelRepository.save(hotel2);
			roomRepository.save(new Room(100, 200.00, "VIP Room", "This is room 100", "Vacant", hotel2));
			roomRepository.save(new Room(101, 210.00, "Regular Room", "This is room 101", "Vacant", hotel2));
			roomRepository.save(new Room(102, 220.00, "Suite", "This is room 102", "Vacant", hotel2));
			roomRepository.save(new Room(103, 230.00, "VIP Room", "This is room 103", "Vacant", hotel2));
			roomRepository.save(new Room(104, 240.00, "Regular Room", "This is room 104", "Vacant", hotel2));

		};
	}

//	@Bean
//	CommandLineRunner runner2(RoomRepository roomRepository) {
//		return args -> {
//			roomRepository.save(new Room(100, 200.00, "VIP Room", "This is room 100", "Vacant"));
//			roomRepository.save(new Room(101, 210.00, "Regular Room", "This is room 101", "Vacant"));
//			roomRepository.save(new Room(102, 220.00, "Suite", "This is room 102", "Vacant"));
//			roomRepository.save(new Room(103, 230.00, "VIP Room", "This is room 103", "Vacant"));
//			roomRepository.save(new Room(104, 240.00, "Regular Room", "This is room 104", "Vacant"));
//		};
//	}

//	@Bean
//	CommandLineRunner runner3(ReservationRepository reservationRepository) {
//		return args -> {
//			Guest guest = new Guest("Alice", "Blue", "alice@gmail.com", "312-111-111");
//			Bill bill = new Bill("2021-5-20","40", "400", "440");
//			Reservation reservation = new Reservation(2, 2, 3, "2012-5-1", "2021-5-3", 100, guest,bill);
//			reservationRepository.save(reservation);
//		};
//	}

}
