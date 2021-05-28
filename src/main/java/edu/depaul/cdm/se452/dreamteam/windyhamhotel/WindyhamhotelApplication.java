package edu.depaul.cdm.se452.dreamteam.windyhamhotel;

import edu.depaul.cdm.se452.dreamteam.windyhamhotel.account.Account;
import edu.depaul.cdm.se452.dreamteam.windyhamhotel.complaint.Complaint;
import edu.depaul.cdm.se452.dreamteam.windyhamhotel.complaint.ComplaintRepository;
import edu.depaul.cdm.se452.dreamteam.windyhamhotel.contact.Contact;
import edu.depaul.cdm.se452.dreamteam.windyhamhotel.department.Department;
import edu.depaul.cdm.se452.dreamteam.windyhamhotel.drink.Drink;
import edu.depaul.cdm.se452.dreamteam.windyhamhotel.drink.DrinkRepository;
import edu.depaul.cdm.se452.dreamteam.windyhamhotel.employee.Employee;
import edu.depaul.cdm.se452.dreamteam.windyhamhotel.employee.EmployeeRepository;
import edu.depaul.cdm.se452.dreamteam.windyhamhotel.food.Food;
import edu.depaul.cdm.se452.dreamteam.windyhamhotel.food.FoodRepository;
import edu.depaul.cdm.se452.dreamteam.windyhamhotel.hotel.Hotel;
import edu.depaul.cdm.se452.dreamteam.windyhamhotel.hotel.HotelRepository;
import edu.depaul.cdm.se452.dreamteam.windyhamhotel.address.Address;
import edu.depaul.cdm.se452.dreamteam.windyhamhotel.address.AddressRepository;
import edu.depaul.cdm.se452.dreamteam.windyhamhotel.hotelServices.HotelService;
import edu.depaul.cdm.se452.dreamteam.windyhamhotel.hotelServices.HotelServiceRepository;
import edu.depaul.cdm.se452.dreamteam.windyhamhotel.review.Review;
import edu.depaul.cdm.se452.dreamteam.windyhamhotel.review.ReviewRepository;
import edu.depaul.cdm.se452.dreamteam.windyhamhotel.room.Room;
import edu.depaul.cdm.se452.dreamteam.windyhamhotel.room.RoomRepository;
import edu.depaul.cdm.se452.dreamteam.windyhamhotel.service.SequenceGeneratorService;
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

	@Bean
	CommandLineRunner runner2(DrinkRepository drinkRepository, FoodRepository foodRepository) {
		return args -> {
			drinkRepository.deleteAll();
			drinkRepository.save(new Drink(1, "Coke","Drink", 2.99));
			drinkRepository.save(new Drink(2, "Apple Juice","Drink", 3.99));

			foodRepository.deleteAll();
			foodRepository.save(new Food(1,"Pizza", "Food", 15.99));
			foodRepository.save(new Food(2,"Cake", "Food", 4.99));

		};
	}

	@Bean
	CommandLineRunner runner3(ReviewRepository reviewRepository, SequenceGeneratorService sequenceGeneratorService) {
		return args -> {

			reviewRepository.deleteAll();
			Review review1 = new Review( "Adam",  "5",  "5/14/2021, 4:11:42 PM",  "Great place to stay!!!");
			review1.setId(sequenceGeneratorService.generateSequence(review1.SEQUENCE_NAME));
			reviewRepository.save(review1);

			Review review2 = new Review( "Anonymous",  "4",  "5/20/2021, 5:11:00 PM",  "Amazing Hotel!!!");
			review2.setId(sequenceGeneratorService.generateSequence(review2.SEQUENCE_NAME));
			reviewRepository.save(review2);

		};
	}

	@Bean
    CommandLineRunner runner4(EmployeeRepository employeeRepository) {
        return args -> {
			Address address1 = new Address("IL", "Chicago", "4141 N State", 60601);
            Contact contact = new Contact("Paul A", address1, "10/12/98", "Male", "paul@gmail.com", "312-4444");
            Department department = new Department("HouseKeeping");
            Account account = new Account(1234567890, "Paul A");

            Employee employee1 = new Employee("Paul A", 4000.00, "Manager", contact, department,account);

            employeeRepository.save(employee1);
        };
    }

	@Bean
	CommandLineRunner runner5(HotelServiceRepository hotelServiceRepository) {
		return args -> {
			hotelServiceRepository.deleteAll();
			HotelService hotelService1 = new HotelService(1,"Hotel Fitness Center", "Open 24-hours a day with room keycard", "Being away from home can easily interrupt the fitness routine of even those with the best intentions.  WindyHam Hotel makes staying on track a breeze with our 24-hour Fitness Center, located on the third floor. This light-filled space boasts a wide range of cardio equipment (including two fully-connected Peloton Bikes) as well as a large selection of free-weights and weight-assisted lifting equipment, all in an open, energizing environment. An adjoining 75-foot indoor lap pool and locker facilities complete the package, allowing fitness enthusiast of all types maintain their programs while on the road. ");
			HotelService hotelService2 = new HotelService(2, "Hotel Swimming Pool", "Mon-Sun: 05:00 AM - 07:00 PM", "WindyHam Hotel guests enjoy complimentary access to our feature pool, adult pool  and indoor pool along with chaise lounges, chairs, towels, complete locker facilities, two outdoor whirlpools and a children's splash pad.");
			hotelServiceRepository.save(hotelService1);
			hotelServiceRepository.save(hotelService2);
		};
	}

	@Bean
	CommandLineRunner runner6(ComplaintRepository complaintRepository, SequenceGeneratorService sequenceGeneratorService) {
		return args -> {
			complaintRepository.deleteAll();

			Complaint complaint1 = new Complaint("Hongli", "Xue", "hongli@gmail.com", "312-4001234", "Check-in takes too long",
					"It took more than an hour to check us in even though we had a confirmed reservation.");
			complaint1.setId(sequenceGeneratorService.generateSequence(complaint1.SEQUENCE_NAME));
			complaintRepository.save(complaint1);

			Complaint complaint2 = new Complaint("Liang", "Gao", "liang@gmail.com", "312-4115239", "Unclean room",
					"The room did not get cleaned at all during our stay!!");
			complaint2.setId(sequenceGeneratorService.generateSequence(complaint2.SEQUENCE_NAME));
			complaintRepository.save(complaint2);
		};
	}

}
