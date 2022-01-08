package classes.vehicle;

import classes.Globals;
import classes.man.Man;

import java.util.ArrayList;

public class Bus<T extends Man> extends Vehicle<T> {
    public Bus() {
        this.capacity = Globals.BUS_CAPACITY;
        this.passengers = new ArrayList<>();
    }
}
