package tests;

import classes.Globals;
import classes.man.Fireman;
import classes.man.Man;
import classes.man.Militiaman;
import classes.vehicle.Bus;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BusTest {
    private final Bus<Man> bus = new Bus<>();

    @Test
    void testGetCapacity() {
        assertEquals(Globals.BUS_CAPACITY, bus.getCapacity());
    }

    @Test
    void testGetNumberOfPassengers() {
        assertEquals(0, bus.getNumberOfPassengers());
    }

    @Test
    void testLendingIn() {
        assertThrows(IllegalStateException.class, () -> {
            for (int i = 0; i < Globals.BUS_CAPACITY + 1; i++) {
                Man passenger;
                if ((((int)(Math.random() * 100)) % 2) == 0) {
                    passenger = new Fireman();
                } else {
                    passenger = new Militiaman();
                }

                bus.landingIn(passenger);
            }
        });
    }

    @Test
    void testLendingOut() {
        assertThrows(IllegalStateException.class, () -> {
            Man passenger = new Fireman();
            bus.landingOut(passenger);
        });
    }
}
