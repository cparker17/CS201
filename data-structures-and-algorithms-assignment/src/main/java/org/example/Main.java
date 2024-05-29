package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {

        //INITIAL STATE & CAPITAL DATE SORTED BY STATE IN A 2-DIMENSIONAL ARRAY
        String[][] stateAndCapitalsArray = {
                {"Alabama", "Alaska", "Arizona", "Arkansas", "California", "Colorado", "Connecticut", "Delaware",
                        "Florida", "Georgia", "Hawaii", "Idaho", "Illinois", "Indiana", "Iowa", "Kansas", "Kentucky",
                        "Louisiana", "Maine", "Maryland", "Massachusetts", "Michigan", "Minnesota", "Mississippi",
                        "Missouri", "Montana", "Nebraska", "Nevada", "New Hampshire", "New Jersey", "New Mexico",
                        "New York", "North Carolina", "North Dakota", "Ohio", "Oklahoma", "Oregon", "Pennsylvania",
                        "Rhode Island", "South Carolina", "South Dakota", "Tennessee", "Texas", "Utah", "Vermont",
                        "Virginia", "Washington", "West Virginia", "Wisconsin", "Wyoming" },
                {"Montgomery", "Juneau", "Phoenix", "Little Rock", "Sacramento", "Denver", "Hartford", "Dover", "Tallahassee",
                        "Atlanta", "Honolulu", "Boise", "Springfield", "Indianapolis", "Des Moines", "Topeka", "Frankfort",
                        "Baton Rouge", "Augusta", "Annapolis", "Boston", "Lansing", "St. Paul", "Jackson", "Jefferson City",
                        "Helena", "Lincoln", "Carson City", "Concord", "Trenton", "Santa Fe", "Albany", "Raleigh", "Bismarck",
                        "Columbus", "Oklahoma City", "Salem", "Harrisburg", "Providence", "Columbia", "Pierre", "Nashville",
                        "Austin", "Salt Lake City", "Montpelier", "Richmond", "Olympia", "Charleston", "Madison", "Cheyenne" }};

        //PART 1: SORTING ARRAYS
        bubbleSortTwoDimensionalArrayBySecondRow(stateAndCapitalsArray);
        displayTwoDimensionalArrayData(stateAndCapitalsArray);
        promptUserForCapitalsForEachState(stateAndCapitalsArray);

        //PART 2: SORTING & SEARCHING HASHMAP

        //CREATE AND POPULATE A HASHMAP WITH THE STATE & CAPITAL DATA
        Map<String, String> stateAndCapitalsMap = new HashMap<>();
        for (int i = 0; i < stateAndCapitalsArray[0].length; i++) {
            stateAndCapitalsMap.put(stateAndCapitalsArray[0][i], stateAndCapitalsArray[1][i]);
        }

        //DISPLAY EACH KEY/VALUE PAIR IN THE HASHMAP
        for (Map.Entry entry : stateAndCapitalsMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        //CREATE A TREEMAP AND LOAD THE DATA FROM THE STATE/CAPITAL HASHMAP
        TreeMap<String, String> stateAndCapitalsTreeMap = new TreeMap<>(stateAndCapitalsMap);
        for (Map.Entry entry : stateAndCapitalsTreeMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        //PROMPT USER FOR STATE AND DISPLAY VALUE
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the name of a state to see the capital: ");
        String userInput = scanner.nextLine();
        System.out.println("The capital of " + userInput + " is " + stateAndCapitalsTreeMap.get(userInput) + ".");
    }

    private static void bubbleSortTwoDimensionalArrayBySecondRow(String[][] array) {
        String secondRowTempValue, firstRowTempValue;
        for (int i = 0; i < array[0].length; i++) {
            for (int j = 0; j < array[0].length - 1; j++) {
                if (array[1][j].compareToIgnoreCase(array[1][j + 1]) > 0) {
                    secondRowTempValue = array[1][j];
                    array[1][j] = array[1][j + 1];
                    array[1][j + 1] = secondRowTempValue;
                    firstRowTempValue = array[0][j];
                    array[0][j] = array[0][j + 1];
                    array[0][j + 1] = firstRowTempValue;
                }
            }
        }
    }

    private static void displayTwoDimensionalArrayData(String[][] array) {
        for (int i = 0; i < array[0].length; i++) {
            System.out.println(array[0][i] + ": " + array[1][i]);
        }
    }

    private static void promptUserForCapitalsForEachState(String[][] array) {
        //DISPLAY DIRECTIONS TO USER
        System.out.println("Enter the name of the capital for each state:\n");

        Scanner scanner = new Scanner(System.in);
        String userInput;
        int correctCapitalNameCounter = 0;

        //LOOP THROUGH ARRAY TO OUTPUT EACH STATE AND GET INPUT FROM USER FOR CAPITAL NAME
        for (int i = 0; i < array[0].length; i++) {
            System.out.println(array[0][i] + ": ");
            userInput = scanner.nextLine();
            if (userInput.compareToIgnoreCase(array[1][i]) == 0) {
                correctCapitalNameCounter++;
            }
        }

        //DISPLAY HOW MANY CAPITALS WERE ENTERED CORRECTLY
        System.out.println("\n   Total Correct Count = " + correctCapitalNameCounter);
    }
}