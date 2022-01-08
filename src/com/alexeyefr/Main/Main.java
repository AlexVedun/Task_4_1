package com.alexeyefr.Main;

import classes.Globals;
import classes.man.Fireman;
import classes.man.Man;
import classes.man.Militiaman;
import classes.vehicle.*;

import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String answer;
        String filename = "storage.tst";
        Road road = new Road();

        answer = getUserChoice(scanner, "Input last result from file?");

        if (answer.equals("y")) {
            File file = new File(filename);
            if (file.exists()) {
                try(ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(file))) {
                    Road serializedRoad = (Road) inputStream.readObject();
                    printRoadInfo(serializedRoad);
                } catch (IOException | ClassNotFoundException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("File not found.");
            }
        } else {
            for (int i = 0; i < getRandomInt(3, 5); i++) {
                switch (getRandomInt(1, 4)) {
                    case 1 -> {
                        FireTruck<Fireman> fireTruck = new FireTruck<>();
                        for (int j = 0; j < getRandomInt(1, Globals.AUTO_CAPACITY); j++) {
                            Fireman fireman = new Fireman();
                            fireTruck.landingIn(fireman);
                        }
                        road.addCarToRoad(fireTruck);
                    }
                    case 2 -> {
                        MilitianAuto<Militiaman> militianAuto = new MilitianAuto<>();
                        for (int j = 0; j < getRandomInt(1, Globals.AUTO_CAPACITY); j++) {
                            Militiaman militiaman = new Militiaman();
                            militianAuto.landingIn(militiaman);
                        }
                        road.addCarToRoad(militianAuto);
                    }
                    case 3 -> {
                        Taxi<Man> taxi = new Taxi<>();
                        for (int j = 0; j < getRandomInt(1, Globals.AUTO_CAPACITY); j++) {
                            Man passenger = switch (getRandomInt(1, 2)) {
                                case 2 -> new Militiaman();
                                default -> new Fireman();
                            };
                            taxi.landingIn(passenger);
                        }
                        road.addCarToRoad(taxi);
                    }
                    case 4 -> {
                        Bus<Man> bus = new Bus<>();
                        for (int j = 0; j < getRandomInt(1, Globals.BUS_CAPACITY); j++) {
                            Man passenger = switch (getRandomInt(1, 2)) {
                                case 2 -> new Militiaman();
                                default -> new Fireman();
                            };
                            bus.landingIn(passenger);
                        }
                        road.addCarToRoad(bus);
                    }
                }
            }

            printRoadInfo(road);

            answer = getUserChoice(scanner, "Save results to the file?");
            if (answer.equals("y")) {
                try(ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(filename, false))) {
                    outputStream.writeObject(road);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static int getRandomInt(int a, int b) {
        return (a + (int) (Math.random() * b));
    }

    private static void printRoadInfo(Road road) {
        System.out.println("Vehicles on the road:");
        for (Vehicle auto : road.carsInRoad) {
            System.out.println(auto);
        }
        System.out.println("Total passengers on the road: " + road.getCountOfHumans());
        System.out.println();
    }

    private static String getUserChoice(Scanner scanner, String message) {
        String answer;

        System.out.println(message + " (y/n)");
        do {
            answer = scanner.next();
        } while (!answer.equals("y") && !answer.equals("n"));

        return answer;
    }
}
