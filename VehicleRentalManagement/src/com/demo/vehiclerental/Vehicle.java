package com.demo.vehiclerental;

   abstract class Vehicle {

	   private String licenseNumber;
	    private String make;
	    private String model;
	    private boolean available;

	    public Vehicle(String licenseNumber, String make, String model,boolean available) {
	        this.licenseNumber = licenseNumber;
	        this.make = make;
	        this.model = model;
	        this.available = available;
	    }

	    public String getlicenseNumber() {
	        return licenseNumber;
	    }

	    public String getMake() {
	        return make;
	    }

	    public String getModel() {
	        return model;
	    }

	    public boolean isAvailable() {
	        return available;
	    }

	    public void setAvailable(boolean available) {
	        this.available = available;
	    }

	    public abstract void display();
	}

