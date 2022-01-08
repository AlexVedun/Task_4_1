package classes.vehicle;

import java.util.ArrayList;
import java.util.List;

public class Road {
    public List<Vehicle> carsInRoad = new ArrayList<>();

    public int getCountOfHumans() {
        Integer sum = 0;

        for (Vehicle car: carsInRoad) {
            sum += car.getNumberOfPassengers();
        }

        return sum;
    }

    public void addCarToRoad(Vehicle car) {
        carsInRoad.add(car);
    }
}
