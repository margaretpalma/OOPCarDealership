package com.pluralsight;

import java.util.ArrayList;

public class UserInterface {

    //load dealership from file
    private Dealership dealership;

    //display menu
    public void display() {
        //
        init();

        int command;


        //while loop

        while (true) {
            displayMenu();

            command = ConsoleHelper.promptForInt("Enter Command");

            //switch statements for menu
            switch (command) {
                //todo: all other cases
                case 1:
                    processGetAllVehiclesRequest();
                    break;
                case 2:
                    processGetByPriceRequest();
                    break;
                case 3:
                    processGetByMakeModelRequest();
                    break;
                case 4:
                    processGetByYearRequest();
                    break;
                case 5:
                    processGetByColorRequest();
                    break;
                case 6:
                    processGetByMileageRequest();
                    break;
                case 7:
                    processGetByTypeRequest();
                    break;
//               // case 8:
//                 //   processAddVehicleRequest();
//                    break;
//                case 9:
//                    processRemoveVehicleRequest();
//                    break;
////                case 99:
//                    System.out.println("Exiting Program");
//                    return;
                default:
                    System.out.println("Invalid Option.");

            }
        }

    }


    //dealership info
    private void init() {
        DealershipFileManager fileManager = new DealershipFileManager("DealershipFile.csv");
        this.dealership = fileManager.getDealership();

        if (dealership != null) {
            System.out.println("Dealership : " + dealership.getName());
        } else {
            System.out.println("Error Loading Dealership");
        }
    }

    //display menu
    //todo: other menu options
    private void displayMenu() {
        System.out.println("*****Main Menu*****");

        System.out.println("1 - Find Vehicles By Price Range ");
        System.out.println("2 - Find Vehicles By Make/Model");
        System.out.println("3 - Find Vehicles By Year Range");
        System.out.println("4 - Find Vehicles By Color");
        System.out.println("5 - Find Vehicles By Type(Car, Truck, Van");
        System.out.println("6 - Find Vehicles By Type");
        System.out.println("7 - List All Vehicles");
        System.out.println("8 - Add A Vehicle");
        System.out.println("9 - Remove A Vehicle");
        System.out.println("99 - Quit Program");
    }

    //list vehicles
    private void processGetAllVehiclesRequest() {
        ArrayList<Vehicle> vehicles = dealership.getAllVehicles();
        displayVehicles(vehicles);
    }

    //helper method for vehicles
    private void displayVehicles(ArrayList<Vehicle> vehicles) {
        if (vehicles == null || vehicles.isEmpty()) {
            System.out.println("No Vehicles Found");
            return;
        }

        //print inventory list
        System.out.println("---Inventory List---");
        for (Vehicle v : vehicles) {
            System.out.println(v);
        }
    }


    //get by price request
    private void processGetByPriceRequest() {
        System.out.println("---Search By Price Range ");


        float minPrice = ConsoleHelper.promptForFloat("Enter Minimum Price");
        float maxPrice = ConsoleHelper.promptForFloat("Enter Maximum Price");

        ArrayList<Vehicle> results = dealership.findByPriceRange(minPrice, maxPrice);

        displayVehicles(results);
    }

    private void processGetByYearRequest(){
        System.out.println("---Search By Year---");

        int minYear = ConsoleHelper.promptForInt("Enter Minimum Year");
        int maxYear = ConsoleHelper.promptForInt("Enter Maximum Year");

        ArrayList<Vehicle> results = dealership.findByYear(minYear, maxYear);
        displayVehicles(results);
    }

    private void processGetByColorRequest(){
        System.out.println("---Search By Color---");

        String color = ConsoleHelper.promptForString("Enter Vehicle Color");
        ArrayList<Vehicle> results = dealership.findByColor(color);
    }

    private void processGetByMakeModelRequest(){
        System.out.println("---Search By Make/Model");

        String make = ConsoleHelper.promptForString("Enter Vehicle Make");
        String model = ConsoleHelper.promptForString("Enter Vehicle Model - ");

        ArrayList<Vehicle> results = dealership.findByMakeModel(make, model);
        displayVehicles(results);

    }

    private void processGetByMileageRequest(){
        System.out.println("---Search By Mileage Range---");

        int minMiles = ConsoleHelper.promptForInt("Enter Minimum Mileage");
        int maxMiles = ConsoleHelper.promptForInt("Enter Maximum Mileage");

        ArrayList<Vehicle> results = dealership.findByMileageRange(minMiles, maxMiles);
        displayVehicles(results);
    }

//    private void processGetByTypeRequest(){
//        System.out.println("---Search By Type---");
//        String type = ConsoleHelper.promptForString("Enter Vehicle Type (Car, Truck, Van");
//
//        ArrayList<Vehicle> results = dealership.find
//

    }

}
//        System.out.println("5 - Find Vehicles By Type(Car, Truck, Van");
//        System.out.println("6 - Find Vehicles By Type");
//        System.out.println("7 - List All Vehicles");
//        System.out.println("8 - Add A Vehicle");
//        System.out.println("9 - Remove A Vehicle");
//        System.out.println("99 - Quit Program");
