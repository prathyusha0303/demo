package com.rgt.rentalsystem.entity;

public class Car extends Vehicle{

	public Car(String licensePlate, String make, String model, String carName,
			Integer numberOfDoors) {
		super(licensePlate, make, model);
		CarName = carName;
		this.numberOfDoors = numberOfDoors;
	}

	private String CarName;
	private Integer numberOfDoors;
	
	public String getCarName() {
		return CarName;
	}

	public void setCarName(String carName) {
		CarName = carName;
	}

	public Integer getNumberOfDoors() {
		return numberOfDoors;
	}

	public void setNumberOfDoors(Integer numberOfDoors) {
		this.numberOfDoors = numberOfDoors;
	}

	@Override
	public String toString() {
		return "Car [CarName=" + CarName + ", numberOfDoors=" + numberOfDoors + "]";
	}
	
	
}
