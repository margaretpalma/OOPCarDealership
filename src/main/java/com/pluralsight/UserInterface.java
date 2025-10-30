package com.pluralsight;

import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {

    //load dealership from file
    private Dealership dealership;
    private final Scanner scanner = new Scanner(System.in);


    //display menu
    public void display() {
        init();

        int command;


        //while loop

        while (true) {
            displayMenu();

            command = ConsoleHelper.promptForInt("Enter Command");

            switch (command) {
                case 1:
                    //processGetAllVehiclesRequest();
                    break;

                //other cases

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
        displayVehicles(vehicles);

    }


}