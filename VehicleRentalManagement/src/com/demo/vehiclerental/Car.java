package com.demo.vehiclerental;

public class Car extends Vehicle {

	private int numberOfSeats;

	public Car(String registrationNumber, String make, String model, boolean available) {
		super(registrationNumber, make, model, available);
	}

	public int getNumberOfSeats() {
		return numberOfSeats;
	}

	public void display() {
		System.out.println("Car -" + getMake() + "," + getModel() + ", licenseNumber: " + getlicenseNumber());
	}
}

class Motorcycle extends Vehicle {
	private int engineCapacity;

	public Motorcycle(String registrationNumber, String make, String model, int engineCapacity, boolean available) {
		super(registrationNumber, make, model, available);
		this.engineCapacity = engineCapacity;
	}

	public int getEngineCapacity() {
		return engineCapacity;
	}

	public void display() {
		System.out
				.println("Motorcycle - " + getMake() + " " + getModel() + ", licenseNumber: " + getlicenseNumber());
	}
}

class Customer {
	private String customerId;
	private String firstName;
    private String lastName;
	private String contactNumber;
	
	
	public Customer() {
	}
	public Customer(String customerId, String firstName, String lastName, String contactNumber) {
		super();
		this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.contactNumber = contactNumber;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

}