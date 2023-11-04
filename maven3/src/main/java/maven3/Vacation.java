//Copyright (C) 2023
 //All rights reserved
package maven3;

import java.util.Locale;

/**
 * This class represents a vacation package with information about the destination, the number of travelers, and the duration.
 * It also calculates the total cost of the vacation package based on various restrictions and selected add-ons.
 * 
 * @author User
 * @version 1.0
 * @since 2023
 */
public class Vacation {
	//Class Fields
	/**
     * The destination of the vacation package.
     */
    private String destination;

    /**
     * The number of travelers for the vacation package.
     */
    private int travelers;

    /**
     * The duration in days of the vacation package.
     */
    private int duration;

    /**
     * The base cost of the vacation package.
     */
    private int base_cost = 1000;

    /**
     * The total cost of the vacation package, including all additional charges and discounts.
     */
    private double total_cost;

    /**
     * The code representing the selected extra/add-on for the vacation package.
     */
    private int extra;

	/**
	 Constructor of the class * 
	 */
	public Vacation() {
		
	}
	
	public String getDestination() {
		return destination;
	}
	
	/**
     * Sets the destination of the vacation package.
     * 
     * @param destination The name of the destination for the package.
     */
	public void setDestination(String destination) {
		this.destination = destination;
	}

	public int getTravelers() {
		return travelers;
	}

	/**
     * Sets the number of travelers for the vacation package.
     * 
     * @param travelers The number of travelers.
     */
	public void setTravelers(int travelers) {
		this.travelers = travelers;
	}

	public int getDuration() {
		return duration;
	}

	/**
     * Sets the duration in days of the vacation package.
     * 
     * @param duration The duration in days of the package.
     */
	public void setDuration(int duration) {
		this.duration = duration;
	}

	public int getBase_cost() {
		return base_cost;
	}

	/**
     * Sets the base cost of the vacation package.
     * 
     * @param base_cost The base cost of the package.
     */
	public void setBase_cost(int base_cost) {
		this.base_cost = base_cost;
	}
	
	/**
		Return the total cost of the package * 
	 */
	public double getTotal_cost() {
		if (total_cost == 0){
			return -1;
		}
		return total_cost;
	}
	
	
	public void setTotal_cost(double total_cost) {
		this.total_cost = total_cost;
	}
	
	
	public int getExtra() {
		return extra;
	}

	 /**
     * Sets the code of the selected add-on for the vacation package.
     * 
     * @param extra The code of the selected add-on.
     */
	public void setExtra(int extra) {
		this.extra = extra;
	}
	
	
	/**
	  Method responsible for verifying if the destination is a touristic 
	post in order to add an additional cost 
	
	@param destination is the name of the destiny of the package
	
	**/
	public double verifyDestiny(String destination) {
		int additional = 0;
		if("Paris".equals(destination.toUpperCase(Locale.ROOT))) {
			additional = 500 + this.base_cost;
		}
		else if("New York City".equals(destination.toUpperCase(Locale.ROOT))) {
			additional= 600 + this.base_cost;
		}
		return additional + this.base_cost;	
	}

	/** Method that return the total cost of the package including all the restrictions
	 
	  @param totalcost is the total amount of money the package is going to cost
	  @param travelers is the number of the travelers that are going to use the package
	  @param duration is the time in days that the travel is going to last
	  
	  **/
	public void getCost(double totalcost, int travelers, int duration) {
		double discount;
		double fee = 200;
		if(travelers>4 && travelers <10) {
			discount = total_cost*0.10;
			this.total_cost = totalcost - discount;	
		}
		if(travelers>10) {
			discount = total_cost*0.20;
			this.total_cost = totalcost - discount;	//NOPMD
		}
		if(duration<7) {
			this.total_cost = totalcost + fee; //NOPMD
		}
		if(duration>30 || travelers == 2) {
			this.total_cost = totalcost - fee; //NOPMD
		}
		else {
			this.total_cost = this.base_cost;
		}
	}
	
	/** Method that calculate the total cost of the package including the extra cost
	 
	  @param extraCode is the option or number that correspond to an specific add-on 
	  @param travelers is the number of the travelers that are going to use the package
	  
	  **/
	public void getTotalWithExtra(int extraCode, int travelers) {
		double plusCost = 0;
		if(extraCode<1 && extraCode > 3) {
			System.out.println(-2);
		}
		switch(extraCode) {
		case 1: plusCost = 200*travelers; break;
		case 2: plusCost = 150*travelers; break;
		case 3: plusCost = 100*travelers; break;
		default: plusCost = 0;  break;
		}
		this.total_cost = this.total_cost+plusCost;
	}
}