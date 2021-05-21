package edu.depaul.cdm.se452.dreamteam.windyhamhotel;

import edu.depaul.cdm.se452.dreamteam.windyhamhotel.Reservation.Reservation;
import edu.depaul.cdm.se452.dreamteam.windyhamhotel.Reservation.ReservationRepository;
import edu.depaul.cdm.se452.dreamteam.windyhamhotel.account.Account;
import edu.depaul.cdm.se452.dreamteam.windyhamhotel.bill.Bill;
import edu.depaul.cdm.se452.dreamteam.windyhamhotel.contact.Contact;
import edu.depaul.cdm.se452.dreamteam.windyhamhotel.department.Department;
import edu.depaul.cdm.se452.dreamteam.windyhamhotel.employee.Employee;
import edu.depaul.cdm.se452.dreamteam.windyhamhotel.employee.EmployeeRepository;
import edu.depaul.cdm.se452.dreamteam.windyhamhotel.guest.Guest;
import edu.depaul.cdm.se452.dreamteam.windyhamhotel.hotel.Hotel;
import edu.depaul.cdm.se452.dreamteam.windyhamhotel.hotel.HotelRepository;
import edu.depaul.cdm.se452.dreamteam.windyhamhotel.address.Address;
import edu.depaul.cdm.se452.dreamteam.windyhamhotel.address.AddressRepository;
import edu.depaul.cdm.se452.dreamteam.windyhamhotel.review.Review;
import edu.depaul.cdm.se452.dreamteam.windyhamhotel.review.ReviewRepository;
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
			Address address1 = new Address("IL", "Chicago", "4141 N State", 60601);
			Hotel hotel1 = new Hotel("WindyHam-Chicago", address1);
			hotelRepository.save(hotel1);
			roomRepository.save(new Room(100, 200.00, "VIP Room", "This is room 100", "Vacant", hotel1));
			roomRepository.save(new Room(101, 210.00, "Regular Room", "This is room 101", "Vacant",hotel1));
			roomRepository.save(new Room(102, 220.00, "Suite", "This is room 102", "Vacant",hotel1));
			roomRepository.save(new Room(103, 230.00, "VIP Room", "This is room 103", "Vacant",hotel1));
			roomRepository.save(new Room(104, 240.00, "Regular Room", "This is room 104", "Vacant",hotel1));

			Address address2 = new Address("FL", "Miami", "1111 South Royal Poinciana Boulevard", 33166);
			Hotel hotel2 = new Hotel("WindyHam-Miami", address2);
			hotelRepository.save(hotel2);
			roomRepository.save(new Room(100, 200.00, "VIP Room", "This is room 100", "Vacant", hotel2));
			roomRepository.save(new Room(101, 210.00, "Regular Room", "This is room 101", "Vacant",hotel2));
			roomRepository.save(new Room(102, 220.00, "Suite", "This is room 102", "Vacant",hotel2));
			roomRepository.save(new Room(103, 230.00, "VIP Room", "This is room 103", "Vacant",hotel2));
			roomRepository.save(new Room(104, 240.00, "Regular Room", "This is room 104", "Vacant",hotel2));


		};
	}

//	@Bean
//	CommandLineRunner runner3(ReservationRepository reservationRepository) {
//		return args -> {
//			Guest guest = new Guest("Alice", "Blue", "alice@gmail.com", "312-111-111");
//			Bill bill = new Bill("2021-5-20","40", "400", "440");
//			Reservation reservation = new Reservation(2, 2, 3, "2012-5-1", "2021-5-3", 100, guest,bill);
//			reservationRepository.save(reservation);
//		};
//	}

	@Bean
	CommandLineRunner runner4(ReviewRepository reviewRepository) {
		return args -> {
			Review review = new Review( "Adam",  "5",  "May 14, 2021",  "Great place to stay!!!");


			reviewRepository.save(review);
		};
	}

	@Bean
    CommandLineRunner runner5(EmployeeRepository employeeRepository) {
        return args -> {
			Address address1 = new Address("IL", "Chicago", "4141 N State", 60601);
            Contact contact = new Contact("Paul A", address1, "10/12/98", "Male", "paul@gmail.com", "312-4444");
            Department department = new Department("HouseKeeping");
            Account account = new Account(1234567890, "Paul A");

            Employee employee1 = new Employee("Paul A", 4000.00, "Manager", contact, department,account);

            employeeRepository.save(employee1);
        };
    }

}
