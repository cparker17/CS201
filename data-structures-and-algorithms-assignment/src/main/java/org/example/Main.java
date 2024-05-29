package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //PART 1: SORTING ARRAYS
        String[][] stateAndCapitals = {
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

        bubbleSortTwoDimensionalArrayBySecondRow(stateAndCapitals);
        displayTwoDimensionalArrayData(stateAndCapitals);
        promptUserForCapitalsForEachState(stateAndCapitals);

        //PART 2: SORTING & SEARCHING HASHMAP
        Map<String, String> stateAndCapitalsMap = new HashMap<>();

    }

    private static void bubbleSortTwoDimensionalArrayBySecondRow(String[][] array) {
        String secondRowTempValue, firstRowTempValue;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1; j++) {
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
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[0][i] + ": " + array[1][i]);
        }
    }

    private static void promptUserForCapitalsForEachState(String[][] array) {
        System.out.println("Enter the name of the capital for each state:\n");
        Scanner scanner = new Scanner(System.in);
        String userInput;
        int correctCapitalNameCounter = 0;
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[0][i] + ": ");
            userInput = scanner.nextLine();
            if (userInput.compareToIgnoreCase(array[1][i]) == 0) {
                correctCapitalNameCounter++;
            }
        }
        System.out.println("\n   Total Correct Count = " + correctCapitalNameCounter);
    }
}