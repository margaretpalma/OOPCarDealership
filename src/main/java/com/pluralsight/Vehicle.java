package com.pluralsight;

public class Vehicle {

        private int vehicleVin;
        private int vehicleYear;
        private String vehicleMake;
        private String vehicleModel;
        private String vehicleType;
        private String vehicleColor;
        private int odometer;
        private double price;

        public Vehicle(int vehicleVin, int vehicleYear, String vehicleMake, String vehicleModel, String vehicleType, String vehicleColor, int odometer, double price) {
                this.vehicleVin = vehicleVin;
                this.vehicleYear = vehicleYear;
                this.vehicleMake = vehicleMake;
                this.vehicleModel = vehicleModel;
                this.vehicleType = vehicleType;
                this.vehicleColor = vehicleColor;
                this.odometer = odometer;
                this.price = price;
        }


}
