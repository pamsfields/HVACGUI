package com.PamFields;
import java.util.Scanner;
import java.util.TreeMap;
/**
 * Created by Pam on 4/2/2017.
 */
public class Input {
    private static Scanner scanner = new Scanner(System.in);   //Global scanner used for all input

    public static int getPositiveIntInput() {
        return getPositiveIntInput(null);
    }

    public static int getPositiveIntInput(String question) {

        if (question != null) {
            System.out.println(question);
        }
        while (true) {
            try {
                String stringInput = scanner.nextLine();
                int intInput = Integer.parseInt(stringInput);
                if (intInput >= 0) {
                    return intInput;
                } else {
                    System.out.println("Please enter a positive number");
                }
            } catch (NumberFormatException fne) {
                System.out.println("Please type a positive number");
            }
        }
    }


    public static double getPositiveDoubleInput() {
        return getPositiveDoubleInput(null);
    }

    public static double getPositiveDoubleInput(String question) {

        if (question != null) {
            System.out.println(question);
        }
        while (true) {
            try {
                String stringInput = scanner.nextLine();
                double doubleInput = Double.parseDouble(stringInput);
                if (doubleInput >= 0) {
                    return doubleInput;
                } else {
                    System.out.println("Please enter a positive number");
                }
            } catch (NumberFormatException nfe) {
                System.out.println("Please type a positive number");
            }
        }
    }


    public static String getStringInput() {
        return getStringInput(null);
    }

    public static String getStringInput(String question) {
        if (question != null) {
            System.out.println(question);
        }
        String entry = scanner.nextLine();
        return entry;
    }


    /* Request a valid type from the furnace types allowed, based on the FurnaceTypes enum */
    public static Furnace.FurnaceType getFurnaceType() {

        //Build a TreeMap - a HashMap with sorted keys - of the valid types
        TreeMap<Integer, Furnace.FurnaceType> furnaceTypes = new TreeMap<Integer, Furnace.FurnaceType>();

        int code = 1;
        for (Furnace.FurnaceType type : Furnace.FurnaceType.values()) {
            furnaceTypes.put(code++, type);
        }

        int totalTypes = code - 1;   //If there are 3 types, then code will be 4 at the end of the loop.

        // Display codes and types, ask user to enter code number corresponding to the desired type
        // Validate that the type code entered is a valid one.
        while (true) {

            System.out.println("Enter type of furnace");

            for (int typeCode : furnaceTypes.keySet()) {
                System.out.println(typeCode + " " + furnaceTypes.get(typeCode));
            }

            int typeCodeInt = Input.getPositiveIntInput();

            if ( typeCodeInt > totalTypes || typeCodeInt < 1 ) {
                System.out.println("Please enter a valid type code number");
            }

            else {
                return furnaceTypes.get(typeCodeInt);
            }
        }
    }
    public static WaterHeater.WaterHeaterType getWaterHeaterType() {

        //Build a TreeMap - a HashMap with sorted keys - of the valid types
        TreeMap<Integer, WaterHeater.WaterHeaterType> WaterHeaterTypes = new TreeMap<Integer, WaterHeater.WaterHeaterType>();

        int code = 1;
        for (WaterHeater.WaterHeaterType type : WaterHeater.WaterHeaterType.values()) {
            WaterHeaterTypes.put(code++, type);
        }

        int totalTypes = code - 1;   //If there are 3 types, then code will be 4 at the end of the loop.

        // Display codes and types, ask user to enter code number corresponding to the desired type
        // Validate that the type code entered is a valid one.
        while (true) {

            System.out.println("Enter type of furnace");

            for (int typeCode : WaterHeaterTypes.keySet()) {
                System.out.println(typeCode + " " + WaterHeaterTypes.get(typeCode));
            }

            int typeCodeInt = Input.getPositiveIntInput();

            if ( typeCodeInt > totalTypes || typeCodeInt < 1 ) {
                System.out.println("Please enter a valid type code number");
            }

            else {
                return WaterHeaterTypes.get(typeCodeInt);
            }
        }
    }
}


