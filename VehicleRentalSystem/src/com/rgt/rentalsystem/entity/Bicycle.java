package com.rgt.rentalsystem.entity;

public class Bicycle extends Vehicle{

	private Integer BicycleId;
	private String BicycleName;

	public Bicycle(String licensePlate, String make, String model, Integer bicycleId, String bicycleName) {
		super(licensePlate, make, model);
		BicycleId = bicycleId;
		BicycleName = bicycleName;
	}
	public Integer getBicycleId() {
		return BicycleId;
	}
	public void setBicycleId(Integer bicycleId) {
		BicycleId = bicycleId;
	}
	public String getBicycleName() {
		return BicycleName;
	}
	public void setBicycleName(String bicycleName) {
		BicycleName = bicycleName;
	}

	
	
}
