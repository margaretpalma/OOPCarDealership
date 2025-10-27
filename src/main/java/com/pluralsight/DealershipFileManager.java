package com.pluralsight;

import java.io.*;
import java.util.ArrayList;

public class DealershipFileManager {

    private String filename; // file read/write

    // constructor
    public DealershipFileManager(String filename) {
        this.filename = filename;
    }

    // read dealership from file
    public Dealership getDealership() {
        Dealership dealership = null;

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {

            // dealership info name|address|phone
            String line = br.readLine();

            if (line != null) {
                String[] parts = line.split("\\|");
                String name = parts[0];
                String address = parts[1];
                String phone = parts[2];

                dealership = new Dealership(name, address, phone);
            }

            //------------------------
            // vehicle lines

            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\|");

                int vin = Integer.parseInt(parts[0]);
                int vehicleYear = Integer.parseInt(parts[1]);
                String vehicleMake = parts[2];
                String vehicleModel = parts[3];
                String vehicleType = parts[4];
                String vehicleColor = parts[5]; // fixed typo
                int odometer = Integer.parseInt(parts[6]); // fixed syntax
                double price = Double.parseDouble(parts[7]); // price is double

                Vehicle vehicle = new Vehicle(vin, vehicleYear, vehicleMake, vehicleModel, vehicleType, vehicleColor, odometer, price);

                dealership.addVehicle(vehicle); // add vehicle to dealership
            }

        } catch (IOException e) {
            // catching exception
            System.out.println("Error Reading File: " + e.getMessage());
        }

        return dealership; // fixed missing semicolon
    }

    // dealership goes to file
    public void saveDealership(Dealership dealership) {
//        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
//
//            // write dealership info
//            bw.write(dealership.getName() + "|" + dealership.getAddress() + "|" + dealership.getPhoneNumber());
//            bw.newLine();
//
//            // write vehicle info
//            for (Vehicle v : dealership.getAllVehicles()) {
//                String vehicleLine = v.getVehicleVin() + "|" +
//                        v.getVehicleYear() + "|" +
//                        v.getVehicleMake() + "|" +
//                        v.getVehicleModel() + "|" +
//                        v.getVehicleType() + "|" +
//                        v.getVehicleColor() + "|" +
//                        v.getOdometer() + "|" +
//                        v.getPrice();
//                bw.write(vehicleLine);
//                bw.newLine();
//            }
//
//        } catch (IOException e) {
//            System.out.println("Error Writing File: " + e.getMessage()); // fixed typo
//        }
    }
}
