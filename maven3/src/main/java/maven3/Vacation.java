//Copyright (C) 2023
 //All rights reserved
package maven3;

public class Vacation {
	private String destination;
	private int travelers;
	private int duration;
	private int base_cost = 1000;
	
	private double total_cost = 0;
	
	/**
	 Constructor of the class * 
	 */
	public Vacation() {
		
	}
	
	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public int getTravelers() {
		return travelers;
	}

	public void setTravelers(int travelers) {
		this.travelers = travelers;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public int getBase_cost() {
		return base_cost;
	}

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
	
	/**
	  Method responsible for verifying if the destination is a touristic 
	post in order to add an additional cost 
	
	@param destination is the name of the destiny of the package
	
	**/
	public double verifyDestiny(String destination) {
		int additional = 0;
		if(destination.toUpperCase().equals("Paris")) {
			additional = 500 + this.base_cost;
		}
		else if(destination.toUpperCase().equals("New York City")) {
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
		double discount = 0;
		double fee = 200;
		if(travelers>4 && travelers <10) {
			discount = total_cost*0.10;
			this.total_cost = totalcost - discount;	
		}
		if(travelers>10) {
			discount = total_cost*0.20;
			this.total_cost = totalcost - discount;	
		}
		if(duration<7) {
			this.total_cost = totalcost + fee;	
		}
		if(duration>30 || travelers == 2) {
			this.total_cost = totalcost - fee;
		}
		else {
			this.total_cost = this.base_cost;
		}
	}
}