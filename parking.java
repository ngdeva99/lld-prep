import java.util.Date;
import java.util.List;

class ParkingLot {
	List<ParkingFloor> parkingFloors;
	List<Entries> entries;
	List<Exits> exits;

	Address address;
	String name;


	public boolean isParkingSpaceAvailableForVehicle(Vehicle vehicle);
	public boolean updateParkingAttendant(ParkingAttendant parkingAttendant, int gateId);
}

class Gate {
	int gateId;
	ParkingAttendant parkingAttendant;
}

class Entries extends Gate {
	public ParkingTicket getParkingTicket(Vehicle vehicle);
}

class Exits extends Gate {
	public void processPayment(ParkingTicket ParkingTicket, PaymentMethod paymentMethod);
}

public enum PaymentMethod {
	CC, TD_BANK, PP, CRYPTO
}

class ParkingFloor {
	List<ParkingSpaces> parkingSpaces;
	ParkingDisplayBoard parkingDisplayBoard;
	int levelId;
}

class ParkingSpaces {
	int spaceId;
	boolean isFree;
	Vehicle vehicle;
	ParkingSpaceType parkingSpaceType;
	double costPerHour;
}

class ParkingDisplayBoard {
	Map<ParkingSpaceType, Integer> availableFreeSpaces;
	public void updateAvailableFreeSpaces(ParkingSpaceType parkingSpaceType, int spaces);
}

class Address {
	String country;
	String state;
	String city;
	String street;
	String pinCode; //ZipCode
}

class Account {
	String name;
	String email;
	String password;
	String empId;
	Address address;
}

class Vehicle {
	String licensePlateNumber;
	VehicleType vehicleType;
	ParkingTicket ParkingTicket;
	PaymentInfo paymentInfo;
}

public enum ParkingSpaceType {
	BIKE_TYPE, CAR_TYPE, VAN_TYPE
}

class ParkingAttendant {
	Payment makePayment;
	public PaymentInfo processPayment(ParkingTicket parkingTicket, PaymentType paymentType);
	public boolean processVehicleEntry(Vehicle vehicle);
}

class ParkingTicket {
	int ticketId;
	int levelId;
	int spaceId;
	Date vehicleEntryDateTime;
	Date vehicleExitDateTime;
	ParkingSpaceType parkingSpaceType;
	double totalCost;
	ParkingTicketStatus parkingTicketStatus;

	public void updateTotalCost();
	public void updateVehicleExitTime(Date vehicleExitDateTime);

}

public enum ParkingTicketStatus {
	ACTIVE, PAID
}

public enum VehicleType{
	CAR, BIKE, VAN
}

public class PaymentInfo {

	double amount;
	Date paymentDate;
	int transactionId;
	ParkingTicket parkingTicket;
	PaymentStatus paymentStatus;

}


public enum PaymentStatus {

	UNPAID, PENDING, COMPLETED, DECLINED, CANCELLED, REFUNDED;

}

class Payment {

	public PaymentInfo makePayment(ParkingTicket parkingTicket, PaymentType paymentType);
}