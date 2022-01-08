package tests;

import classes.Globals;
import classes.man.Fireman;
import classes.vehicle.FireTruck;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FireTruckTest {
    private final FireTruck<Fireman> fireTruck = new FireTruck<>();

    @Test
    void testGetCapacity() {
        assertEquals(Globals.AUTO_CAPACITY, fireTruck.getCapacity());
    }

    @Test
    void testGetNumberOfPassengers() {
        assertEquals(0, fireTruck.getNumberOfPassengers());
    }

    @Test
    void testLendingIn() {
        assertThrows(IllegalStateException.class, () -> {
            for (int i = 0; i < Globals.AUTO_CAPACITY + 1; i++) {
                Fireman passenger = new Fireman();
                fireTruck.landingIn(passenger);
            }
        });
    }

    @Test
    void testLendingOut() {
        assertThrows(IllegalStateException.class, () -> {
            Fireman passenger = new Fireman();
            fireTruck.landingOut(passenger);
        });
    }
}
