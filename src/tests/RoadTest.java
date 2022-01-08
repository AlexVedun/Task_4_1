package tests;

import classes.man.Fireman;
import classes.man.Man;
import classes.man.Militiaman;
import classes.vehicle.Bus;
import classes.vehicle.FireTruck;
import classes.vehicle.Road;
import classes.vehicle.Taxi;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RoadTest {
    private final Road road = new Road();

    @Test
    void testGetCountOfHumans() {
        assertDoesNotThrow(() -> {
            Man passenger1 = new Fireman();
            Man passenger2 = new Fireman();
            Man passenger3 = new Fireman();
            Man passenger4 = new Militiaman();
            Man passenger5 = new Militiaman();
            Man passenger6 = new Militiaman();
            Man passenger7 = new Fireman();
            Man passenger8 = new Fireman();
            Man passenger9 = new Fireman();

            Taxi taxi = new Taxi();
            Bus bus = new Bus();
            FireTruck fireTruck = new FireTruck();

            taxi.landingIn(passenger1);
            taxi.landingIn(passenger2);
            taxi.landingIn(passenger3);
            taxi.landingOut(passenger3);
            road.addCarToRoad(taxi);

            bus.landingIn(passenger4);
            bus.landingIn(passenger5);
            bus.landingIn(passenger6);
            bus.landingIn(passenger3);
            road.addCarToRoad(bus);

            fireTruck.landingIn(passenger7);
            fireTruck.landingIn(passenger8);
            fireTruck.landingIn(passenger9);
            road.addCarToRoad(fireTruck);

            assertEquals(9, road.getCountOfHumans());
        });
    }
}
