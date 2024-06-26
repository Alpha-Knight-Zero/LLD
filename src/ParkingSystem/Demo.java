package ParkingSystem;

import ParkingSystem.VehicleType.Bike;
import ParkingSystem.VehicleType.Car;
import ParkingSystem.VehicleType.Vehicle;

public class Demo {
    public static void main(String[] args) {
        ParkingLot parkingLot = ParkingLot.getInstance();
        parkingLot.addLevel(new Level(1, 3));
        parkingLot.addLevel(new Level(2, 4));

        Vehicle car = new Car("ABC123");
        Vehicle motorcycle = new Bike("M1234");

        // Park vehicles
        parkingLot.parkVehicle(car);
        parkingLot.parkVehicle(motorcycle);

        // Display availability
        parkingLot.displayAvailability();

        // Remove vehicle
        parkingLot.removeVehicle(motorcycle);

        // Display updated availability
        parkingLot.displayAvailability();
    }
}
