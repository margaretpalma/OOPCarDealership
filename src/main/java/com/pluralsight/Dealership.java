package com.pluralsight;

import java.util.ArrayList;

public class Dealership {
    //what do we know?
    private String name;
    private String address;
    private String phoneNumber;
    private ArrayList<Vehicle> inventory;

    //constructor
    public Dealership(String name, String address, String phoneNumber) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.inventory = new ArrayList<>();
    }

    public String getName() {
        return null;
    }

    public String getAddress() {
        return null;
    }

    public String getPhoneNumber() {
        return null;
    }

    public ArrayList<Vehicle> getAllVehicles() {
        return inventory;
    }

    //adding vehicle
    public void addVehicle(Vehicle vehicle) {
        inventory.add(vehicle);
        //todo: print for adding vehicle to inventory
    }

    public void removeVehicle(int vehicleVin) {
          //todo: remove by vin
        }
    }

