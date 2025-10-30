package com.pluralsight;

import java.util.ArrayList;
import java.util.Scanner;

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
                    processGetbyMakeModelRequest();
                    break;
                case 4:
                    processsGetByYearRequest();
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
                case 8:
                    processAddVehicleRequest();
                    break;
                case 9:
                    processRemoveVehicleRequest();
                    break;
                case 99:
                    System.out.println("Exiting Program");
                    return;
                default:
                    System.out.println("Invalid Option.");

            }
        }

    }


    //dealership info
    private void init(){
        DealershipFileManager fileManager = new DealershipFileManager("DealershipFile.csv");
        this.dealership = fileManager.getDealership();

        if(dealership != null) {
            System.out.println("Dealership : " + dealership.getName());
        } else {
            System.out.println("Error Loading Dealership");
        }
    }

    //display menu
    //todo: other menu options
    private void displayMenu(){
        System.out.println("*****Main Menu*****");
        System.out.println("1 - List All Vehicles");
        //other menu options
        System.out.println("99 - Quit");
    }

    //list vehicles
    private void processGetAllVehiclesRequest(){
        ArrayList<Vehicle> vehicles = dealership.getAllVehicles();
        displayVehicles(vehicles);
    }

    //helper method for vehicles
    private void displayVehicles(ArrayList<Vehicle> vehicles){
        if (vehicles == null || vehicles.isEmpty()) {
            System.out.println("No Vehicles Found");
            return;
        }

    //print inventory list
        System.out.println("---Inventory List---");
        for (Vehicle v : vehicles){
            System.out.println(v.toString());
        }
    }
}