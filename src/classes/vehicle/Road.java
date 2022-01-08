package classes.vehicle;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Road implements Serializable {
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
