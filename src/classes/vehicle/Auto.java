package classes.vehicle;

import java.util.ArrayList;

public abstract class Auto<T> extends Vehicle<T> {
    public Auto() {
        capacity = 4;
        passengers = new ArrayList<>();
    }
}
