package tests;

import classes.Globals;
import classes.man.Fireman;
import classes.man.Man;
import classes.man.Militiaman;
import classes.vehicle.Taxi;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TaxiTest {
    private final Taxi<Man> taxi = new Taxi<>();

    @Test
    void testGetCapacity() {
        assertEquals(Globals.AUTO_CAPACITY, taxi.getCapacity());
    }

    @Test
    void testGetNumberOfPassengers() {
        assertEquals(0, taxi.getNumberOfPassengers());
    }

    @Test
    void testLendingIn() {
        assertThrows(IllegalStateException.class, () -> {
            for (int i = 0; i < Globals.AUTO_CAPACITY + 1; i++) {
                Man passenger;
                if ((((int)(Math.random() * 100)) % 2) == 0) {
                    passenger = new Fireman();
                } else {
                    passenger = new Militiaman();
                }

                taxi.landingIn(passenger);
            }
        });
    }

    @Test
    void testLendingOut() {
        assertThrows(IllegalStateException.class, () -> {
            Man passenger = new Fireman();
            taxi.landingOut(passenger);
        });
    }
}
