package com.demo.vehiclerental;

import java.time.LocalDateTime;

public class Rental {

	private Vehicle rentedVehicle;
    private Customer customer;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    
    
	public Rental(Vehicle rentedVehicle, Customer customer) {
		super();
		this.rentedVehicle = rentedVehicle;
		this.customer = customer;
		this.startTime = LocalDateTime.now();
	}
	public Vehicle getRentedVehicle() {
		return rentedVehicle;
	}
	public void setRentedVehicle(Vehicle rentedVehicle) {
		this.rentedVehicle = rentedVehicle;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public LocalDateTime getStartTime() {
		return startTime;
	}
	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}
	public LocalDateTime getEndTime() {
		return endTime;
	}
	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}
	public double calculateRentalCost(LocalDateTime endTime2) {
		endTime = LocalDateTime.now();
        return startTime.until(endTime, java.time.temporal.ChronoUnit.HOURS);
	}
	public double calculateRentalCost() {
        double rentalDuration = calculateRentalCost();
        double vehicleCostPerHour = 10.0; 

        return rentalDuration * vehicleCostPerHour;
    }
    
}
