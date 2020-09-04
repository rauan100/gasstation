package rauan.ferreira.gasstation.daos;

import java.util.ArrayList;
import java.util.List;

import rauan.ferreira.gasstation.entities.Vehicle;

public class VehicleDao {

    private static List<Vehicle> vehicles = new ArrayList();

    public static List<Vehicle> getVehicles () {
        return vehicles;
    }

    public static Vehicle getByPosition (int position) {
        return vehicles.get(position);
    }

    public static void create(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    public static void update(int vehicle, Vehicle newVehicle) {
        delete(vehicle);
        vehicles.add(newVehicle);
    }

    public static void delete(int vehicle) {
        vehicles.remove(vehicle);
    }

    public static int total() {
        return vehicles.size();
    }
}
