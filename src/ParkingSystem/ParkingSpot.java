package ParkingSystem;

import ParkingSystem.VehicleType.Vehicle;
import ParkingSystem.VehicleType.VehicleType;

public class ParkingSpot {
    private final int spotNumber;
    private final VehicleType type;
    private Vehicle parkedVehicle;

    private static ParkingSpot spot;

    private ParkingSpot(int spotNumber, VehicleType type){
        this.spotNumber = spotNumber;
        this.type=type;
    }

    public static ParkingSpot initParkingSpot(int SNo,VehicleType type) {
        if(spot==null){
            spot=new ParkingSpot(SNo,type);
        }
        return spot;
    }

    public synchronized boolean isAvailable() {
        return parkedVehicle == null;
    }

    public synchronized void parkVehicle(Vehicle vehicle) {
        if (isAvailable()) {
            if(vehicle.getType() == type){
                parkedVehicle = vehicle;
            }
            else{
                throw new IllegalArgumentException("Vehicle type mismatch.");
            }
        } else {
            throw new IllegalArgumentException("Spot already occupied.");
        }
    }

    public synchronized void removeVehicle() {
        parkedVehicle = null;
    }

    public VehicleType getVehicleType() {
        return type;
    }

    public Vehicle getParkedVehicle() {
        return parkedVehicle;
    }

    public int getSpotNumber() {
        return spotNumber;
    }
}
