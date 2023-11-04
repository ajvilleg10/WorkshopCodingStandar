//Copyright (C) 2023
 //All rights reserved
package maven3;

import java.util.Scanner;

/**
 * VacationEstimator class estimates the cost of a vacation package based on user input for destination, number of travelers,
 * duration, and selected add-ons. It handles user input, validates inputs, and calculates the total cost of the vacation package.
 * 
 * @version 1.0
 * @since 2023
 */
public class VacationEstimator {
	//CHECKSTYLE:OFF
	/**
     * Main method initializes the vacation package estimator. It prompts the user for input, validates the input,
     * calculates the total cost, and displays the result.
     * 
     * @param args The command-line arguments (not used).
     */
	public static void main(String[] args) {
	//CHECKSTYLE:ON
		 try (Scanner sc = new Scanner(System.in)) {
	            Vacation vac1 = new Vacation();
	            System.out.println("*****Vacation Package Estimator*****");

	            // Manejar la entrada del usuario para el destino
	            System.out.println("Enter your destination:");
	            vac1.setDestination(getUserInput(sc));

	            // Manejar la entrada del usuario para el número de viajeros
	            System.out.println("Enter the number of travelers:");
	            vac1.setTravelers(getPositiveIntegerInput(sc));

	            // Manejar la entrada del usuario para la duración en días
	            System.out.println("Enter the duration in days:");
	            vac1.setDuration(getPositiveIntegerInput(sc));

	            // Manejar la entrada del usuario para los extras
	            printAddonOptions();
	            vac1.setExtra(getAddonChoice(sc));

	            while (vac1.getExtra() < 1 || vac1.getExtra() > 4) {
	                System.out.println("Invalid choice. Please select a valid option (1-4):");
	                printAddonOptions();
	                vac1.setExtra(getAddonChoice(sc));
	            }

	            // Validar el número de viajeros
	            if (vac1.getTravelers() > 80) {
	                System.out.println("The vacation package is not available for groups of more than 80 persons");
	            } else {
	                try {
	                    double total_cost = vac1.verifyDestiny(vac1.getDestination());
	                    vac1.getCost(total_cost, vac1.getTravelers(), vac1.getDuration());
	                    vac1.getTotalWithExtra(vac1.getExtra(), vac1.getTravelers());
	                    System.out.println("The total cost of the vacation package is " + vac1.getTotal_cost());
	                } catch (Exception e) {
	                    System.out.println("Error occurred while calculating the total cost: " + e.getMessage());
	                }
	            }
	        } catch (Exception e) {
	            System.out.println("An error occurred: " + e.getMessage());
	        }
	    }

	    private static String getUserInput(Scanner scanner) {
	        String userInput = null;
	        boolean validInput = false;
	        while (!validInput) {
	            userInput = scanner.nextLine();
	            if (!userInput.isEmpty()) {
	                validInput = true;
	            } else {
	                System.out.println("Invalid input. Please enter a valid string:");
	            }
	        }
	        return userInput;
	    }

	    private static int getPositiveIntegerInput(Scanner scanner) {
	        int input = 0;
	        boolean validInput = false;
	        while (!validInput) {
	            try {
	                input = Integer.parseInt(scanner.nextLine());
	                if (input > 0) {
	                    validInput = true;
	                } else {
	                    System.out.println("Invalid input. Please enter a positive number:");
	                }
	            } catch (NumberFormatException e) {
	                System.out.println("Invalid input. Please enter a valid number:");
	            }
	        }
	        return input;
	    }

	    private static void printAddonOptions() {
	        System.out.println("Select your add-ons:");
	        System.out.println("1. All-Inclusive Package - $200 per traveler");
	        System.out.println("2. Adventure Activities Package - $150 per traveler");
	        System.out.println("3. Spa and Wellness Package - $100 per traveler");
	        System.out.println("4. Nothing");
	    }

	    private static int getAddonChoice(Scanner scanner) {
	        int choice = 0;
	        boolean validInput = false;
	        while (!validInput) {
	            choice = getPositiveIntegerInput(scanner);
	            if (choice >= 1 && choice <= 4) {
	                validInput = true;
	            } else {
	                System.out.println("Invalid choice. Please select a valid option (1-4):");
	            }
	        }
	        return choice;
	    }
}