package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.StringReader;
import java.util.ArrayList;

public class DealershipFileManager {


        private String filename; //file read/write

        public DealershipFileManager(String filename) {
        this.filename = filename;
    }

        public Dealership getDealership(){
            Dealership dealership = null;

            try(BufferedReader br = new BufferedReader(new FileReader("DealershipFile")));

            String line = br.readLine();

            if (line != null) {

                String[] parts = line.split("\\|");
                String name = parts[0];
                String address = parts[1];
                String phone = parts[2];

                dealership =
            }




        }


}