--DROP TABLE Guest CASCADE CONSTRAINTS;
--DROP TABLE Reservation;
--DROP TABLE Employee CASCADE CONSTRAINTS;
--DROP TABLE Room;

/* TODO: Discuss primary/ foreign keys for these tables. 
Depends how Java code designed. Certain vars may need to be changed. */

CREATE TABLE Guest (
    guest_id int,
    first_name varchar(15), 
    last_name varchar(15), 
    email varchar(25),
    password varchar(25),
    phone varchar(15),
    payment_info int, --Still discussing how this works
    PRIMARY KEY (guest_id)
);

CREATE TABLE Room (
    room_number int,
    type varchar(15),   
    price NUMERIC(6,2), --NOTE: may need to be changed
    description varchar(30), 
    status varchar(10), --MARK: may be changed to Bool
    PRIMARY KEY (room_number)
);

CREATE TABLE Reservation (
    reservation_id int,
    guest_id int,
    adult int,
    children int,
    checkin date,
    checkout date,
    room_number int, 
    -- guest varchar(30), --NOTE: just the person's name
                        -- TODO:: from Jackson: I don't think we need this if we have the reservation_id and guest_id
    PRIMARY KEY (reservation_id),
    FOREIGN KEY (guest_id) REFERENCES Guest(id),
    FOREIGN KEY (room_number) REFERENCES Room(room_number)
);

-- TODO: Payroll info
CREATE TABLE Employee (
    employee_id int,
    --position varchar(20),
    password varchar(25),
    PRIMARY KEY (employee_id)
);



