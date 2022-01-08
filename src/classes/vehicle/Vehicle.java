package classes.vehicle;

import classes.man.Man;

import java.io.Serializable;
import java.util.List;

public abstract class Vehicle<T> implements Serializable {
    protected Integer capacity;
    protected List<T> passengers;

    public Integer getCapacity() {
        return capacity;
    }

    public Integer getNumberOfPassengers() {
        return passengers.size();
    }

    public void landingIn(T passenger) {
        try {
            if (passengers.size() < capacity) {
                passengers.add(passenger);
            } else {
                throw new IllegalStateException();
            }
        } catch (IllegalStateException exception) {
            System.out.println("Cannot landing passenger to vehicle. The vehicle is full.");
            throw exception;
        }
    }

    public void landingOut(T passenger) {
        try {
            if (passengers.contains(passenger)) {
                passengers.remove(passenger);
            } else {
                throw new IllegalStateException();
            }
        } catch (IllegalStateException exception) {
            System.out.println("Passenger is not in the vehicle");
            throw exception;
        }
    }
}
