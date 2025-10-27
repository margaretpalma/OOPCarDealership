package com.pluralsight;

import java.io.*;
import java.util.ArrayList;

public class DealershipFileManager {


        private String filename; //file read/write

        public DealershipFileManager(String filename) {
        this.filename = filename;
    }

        public Dealership getDealership() {
            Dealership dealership = null;

            try (BufferedReader br = new BufferedReader(new FileReader("DealershipFile"))) {


                //dealership info name|address|phone
                String line = br.readLine();

                if (line != null) {

                    String[] parts = line.split("\\|");
                    String name = parts[0];
                    String address = parts[1];
                    String phone = parts[2];

                    dealership = new Dealership(name, address, phone);
                }
                //------------------------
                //vehicle lines

                while ((line = br.readLine()) != null) {
                    String[] parts = line.split("\\|");

                    int vin = Integer.parseInt(parts[0]);
                    int vehicleYear = Integer.parseInt(parts[1]);
                    String vehicleMake = parts[2];
                    String vehicleModel = parts[3];
                    String vehicleType = parts[4];
                    String vehcieleColor = parts[5];
                    int odometer = Integer.parseInt[6];
                    double price = Integer.parseInt[7];

                    Vehicle vehicle = new Vehicle(vin, vehicleYear, vehicleMake, vehicleModel, vehicleType, vehcieleColor, odometer, price);

                }
            }
          //catching exception
        } catch (IOException e) {
        System.out.println("Error Reading File: " + e.getMessage());
        }
        return dealership;
}

        //dealership goes to file

        public void saveDealership(Dealership dealership) {
//            try (BufferedReader bw = new BufferedWriter(new FileWriter("DealershipFile"))) {
//                bw.write(dealership.getName() + "|" + dealership.getAddress() + "|" + dealership.getPhoneNumber());
//                bw.newLine();
//
//                //write vehicle
//
//                for (Vehicle v : dealership.getAllVehicles()) {
//                    String vehicleLine = v.getVehicleVin() + "|"
//                    v.getVehicleYear() + "|"
//                    v.getVehicleMake() + "|"
//                    v.getVehicleModel() + "|"
//                    v.getVehicleType() + "|"
//                    v.getVehicleColor() + "|"
//                    v.getVehicleOdometer() + "|"
//                    v.getVehiclePrice() + "|"
//                    bw.write(vehicleLine);
//                    bw.newLine();
//                }
            } catch (IOException e){
        System.out.

println("Errpr Writing File: "+e.getMessage());
        }

            }
        }

}


