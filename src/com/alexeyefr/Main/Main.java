package com.alexeyefr.Main;

import classes.man.Fireman;
import classes.man.Man;
import classes.man.Militiaman;
import classes.vehicle.Bus;
import classes.vehicle.FireTruck;

public class Main {

    public static void main(String[] args) {
	    Bus<Man> bus = new Bus<>();
        Fireman passenger1 = new Fireman();
        Militiaman passenger2 = new Militiaman();
        FireTruck<Fireman> firetruck = new FireTruck<>();

        bus.landingIn(passenger1);
        bus.landingIn(passenger2);
        System.out.println("Capacity: " + bus.getCapacity());
        System.out.println("Number of passengers: " + bus.getNumberOfPassengers());

        firetruck.landingIn(passenger1);
    }
}
