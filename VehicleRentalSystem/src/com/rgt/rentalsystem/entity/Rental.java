package com.rgt.rentalsystem.entity;

import java.time.LocalDateTime;
import java.util.UUID;

public class Rental {

	private String Id;
	private Vehicle rentedVehicle;
    private Customer customer;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    
    
	public Rental(Vehicle rentedVehicle, Customer customer, LocalDateTime startTime, LocalDateTime endTime) {
		Id = UUID.randomUUID().toString();
		this.rentedVehicle = rentedVehicle;
		this.customer = customer;
		this.startTime = startTime;
		this.endTime = endTime;
	}
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
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
}
