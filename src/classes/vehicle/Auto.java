package classes.vehicle;

import classes.Globals;

import java.util.ArrayList;

public abstract class Auto<T> extends Vehicle<T> {
    public Auto() {
        capacity = Globals.AUTO_CAPACITY;
        passengers = new ArrayList<>();
    }
}
