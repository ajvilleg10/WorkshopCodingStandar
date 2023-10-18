//Copyright (C) 2023
 //All rights reserved
package maven3;

import java.util.Scanner;

public class VacationEstimator {
	//CHECKSTYLE:OFF
	public static void main(String[] args) {
	//CHECKSTYLE:ON
		Vacation vac1 = new Vacation();
		Scanner sc = new Scanner(System.in);
		System.out.println("*****Vacation Package Estimator*****");
		System.out.println("Enter your destination:");
		vac1.setDestination(sc.nextLine());
		System.out.println("Enter the number of travelers:");
		vac1.setTravelers(sc.nextInt());
		System.out.println("Enter the duration in days:");
		vac1.setDuration(sc.nextInt());
		if(vac1.getTravelers()>80) {
			System.out.println("The vacation package is not available for groups of more than 80 persons");	
		}
		else {
			double total_cost = vac1.verifyDestiny(vac1.getDestination());
			vac1.getCost(total_cost, vac1.getTravelers(), vac1.getDuration());
			System.out.println("The total cost of the vacation package is " + vac1.getTotal_cost());
		}

	}

}