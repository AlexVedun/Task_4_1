package tests;

import classes.Globals;
import classes.man.Militiaman;
import classes.vehicle.MilitianAuto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MilitianAutoTest {
    private final MilitianAuto<Militiaman> militianAuto = new MilitianAuto<>();

    @Test
    void testGetCapacity() {
        assertEquals(Globals.AUTO_CAPACITY, militianAuto.getCapacity());
    }

    @Test
    void testGetNumberOfPassengers() {
        assertEquals(0, militianAuto.getNumberOfPassengers());
    }

    @Test
    void testLendingIn() {
        assertThrows(IllegalStateException.class, () -> {
            for (int i = 0; i < Globals.AUTO_CAPACITY + 1; i++) {
                Militiaman passenger = new Militiaman();
                militianAuto.landingIn(passenger);
            }
        });
    }

    @Test
    void testLendingOut() {
        assertThrows(IllegalStateException.class, () -> {
            Militiaman passenger = new Militiaman();
            militianAuto.landingOut(passenger);
        });
    }
}
