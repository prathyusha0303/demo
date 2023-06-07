package com.demo.vehiclerental;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VehicleReturnManagementSystem {
	private static List<Vehicle> vehicles;
	private List<Customer> customers;

	public VehicleReturnManagementSystem() {
		vehicles = new ArrayList<>();
		customers = new ArrayList<>();
	}

	public void addVehicle(Vehicle vehicle) {
		vehicles.add(vehicle);
	}

	public void addCustomer(Customer customer) {
		customers.add(customer);
	}

	public void displayAvailableVehicles() {
		System.out.println("Available Vehicles:");
		for (Vehicle vehicle : vehicles) {
			if (vehicle.isAvailable()) {
				vehicle.display();
			}
		}
	}

	public Rental rentVehicle(String licenseNumber, Customer customer) {
		for (Vehicle vehicle : vehicles) {
			if (vehicle.getlicenseNumber().equals(licenseNumber) && vehicle.isAvailable()) {
				vehicle.setAvailable(false);
				System.out.println("Vehicle with licenseNumber " + licenseNumber + " rented successfully to "
						+ customer.getFirstName() + customer.getLastName());
				return null;
			}
		}
		System.out.println("Vehicle with licenseNumber " + licenseNumber + " not found or already rented.");
		return null;
	}

	public void returnVehicle(String licenseNumber) {
		for (Vehicle vehicle : vehicles) {
			if (vehicle.getlicenseNumber().equals(licenseNumber) && !vehicle.isAvailable()) {
				vehicle.setAvailable(true);
				System.out.println("Vehicle with licenseNumber " + licenseNumber + " returned successfully.");
				return;
			}
		}
		System.out.println("Vehicle with licenseNumber" + licenseNumber + " not found or not rented.");
	}

	public static void main(String[] args) {
		VehicleReturnManagementSystem managementSystem = new VehicleReturnManagementSystem();
		Scanner scanner = new Scanner(System.in);

		// Add some sample vehicles to the management system
		managementSystem.addVehicle(new Car("CAR001", "Toyota", "Camry", false));
		managementSystem.addVehicle(new Car("CAR002", "Honda", "Accord", true));
		managementSystem.addVehicle(new Motorcycle("MOTO001", "HARLEY", "DAVIDSON", 9, true));
		managementSystem.addVehicle(new Motorcycle("MOTO002", "YAMAHA", "YAA", 2, true));

		// Add some sample customers to the management system
		managementSystem.addCustomer(new Customer("CUST001", "PRATHYUSHA", "B", "9090909090"));
		managementSystem.addCustomer(new Customer("CUST002", "LIKKI", "G", "9898989898"));

		while (true) {
			System.out.println("Vehicle Return Management System");
			System.out.println("1. Add Vehicle");
			System.out.println("2. Display Available Vehicles");
			System.out.println("3. Rent a Vehicle");
			System.out.println("4. Return a Vehicle");
			System.out.println("5. Exit");
			System.out.print("Enter your choice: ");

			int choice = scanner.nextInt();
			scanner.nextLine();

			switch (choice) {
			case 1:
				addVehicle(scanner);
				break;
			case 2:
				managementSystem.displayAvailableVehicles();
				break;
			case 3:
				System.out.print("Enter the registration number of the vehicle to rent: ");
				String rentRegNumber = scanner.nextLine();
				System.out.print("Enter customer name: ");
				String customerName = scanner.nextLine();
				System.out.print("Enter customer contact number: ");
				String customerContact = scanner.nextLine();
				Customer customer = new Customer("CUST001", "PRATHYUSHA", "B", "989898");
				managementSystem.rentVehicle(rentRegNumber, customer);
				break;
			case 4:
				System.out.print("Enter the registration number of the vehicle to return: ");
				String returnRegNumber = scanner.nextLine();
				managementSystem.returnVehicle(returnRegNumber);
				break;
			case 5:
				System.out.println("Thank you for using the Vehicle Return Management System.");
				scanner.close();
				System.exit(0);
			case 6:
				System.out.print("Enter the registration number of the vehicle: ");
				String regNumber = scanner.nextLine();
				System.out.print("Enter the end time (yyyy-MM-dd HH:mm): ");
				String endTimeStr = scanner.nextLine();
				LocalDateTime endTime = LocalDateTime.parse(endTimeStr,
						DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
				Rental rental = findRentalByRegistrationNumber(regNumber);
				if (rental != null) {
					double cost = rental.calculateRentalCost(endTime);
					System.out.println("Rental cost: $" + cost);
				} else {
					System.out.println("Vehicle with registration number " + regNumber + " not found or not rented.");
				}
				break;
			default:
				System.out.println("Invalid choice. Please try again.");
			}
		}
	}

	private static void addVehicle(Scanner scanner) {
		System.out.print("Enter the type of vehicle (car, motorcycle, bicycle): ");
		String type = scanner.nextLine();

		System.out.print("Enter the license plate: ");
		String licensePlate = scanner.nextLine();

		System.out.print("Enter the make: ");
		String make = scanner.nextLine();

		System.out.print("Enter the model: ");
		String model = scanner.nextLine();

		Vehicle vehicle;
		switch (type) {
		case "car":
			System.out.println("Enter the Carname");
			String carname = scanner.next();
			System.out.print("Enter the number of doors: ");
			Integer numDoors = scanner.nextInt();
			vehicle = new Car(carname, make, model, true);
			break;
		default:
			System.out.println("Invalid vehicle type. Vehicle not added.");
			return;
		}
		vehicles.add(vehicle);
		System.out.println("Vehicle added successfully.");

	}

	private static Rental findRentalByRegistrationNumber(String regNumber) {
		// TODO Auto-generated method stub
		return null;
	}

}
