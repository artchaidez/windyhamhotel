DROP TABLE Guest CASCADE CONSTRAINTS;
DROP TABLE Reservation;
DROP TABLE Employee CASCADE CONSTRAINTS;
DROP TABLE Room;

/* TODO: Discuss primary/ foreign keys for these tables. 
Depends how Java code designed. Certain vars may need to be changed. */

--name may be separated to two varchars: firstName and lastName
CREATE TABLE Guest (
    id int,
    name varchar(25), 
    email varchar(25),
    phone varchar(15),
    PRIMARY KEY (id)
)

/* TODO: var room is a foreign reference to Table Room. 
Room currently a string, it needs to match room_number (int) in Table Room*/
CREATE TABLE Reservation (
    id int,
    adult int,
    children int,
    checkin date,
    checkout date,
    room varchar(10), --MARK: may be changed to room_number int,
    guest varchar(20),
    --FOREIGN KEY (room_number) REFERENCES Room(room_number),
    FOREIGN KEY (id) REFERENCES Guest(id)
)

CREATE TABLE Employee (
    id int,
    password varchar(25),
    PRIMARY KEY (id) 
)

/* TODO: Discuss what id and room_number are.
Do not think Table id is related to Guest ID*/
CREATE TABLE Room (
    id int,
    room_number int,
    type varchar(15),
    price NUMERIC(6,2), --NOTE: may need to be changed
    description varchar(30), -- NOTE: unsure on how long description can be
    status varchar(10), --MARK: may be changed to Bool
    PRIMARY KEY (room_number)
)


