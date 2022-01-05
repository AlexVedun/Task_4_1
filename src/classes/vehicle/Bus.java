package classes.vehicle;

import classes.man.Man;

import java.util.ArrayList;

public class Bus<T extends Man> extends Vehicle<T> {
    public Bus() {
        this.capacity = 22;
        this.passengers = new ArrayList<>();
    }
}
