package com.rgt.rentalsystem.rentalMain;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

import com.rgt.rentalsystem.entity.Bicycle;
import com.rgt.rentalsystem.entity.Car;
import com.rgt.rentalsystem.entity.Customer;
import com.rgt.rentalsystem.entity.Motorcycle;
import com.rgt.rentalsystem.entity.Rental;
import com.rgt.rentalsystem.entity.Vehicle;
import com.rgt.rentalsystem.rental.service.RentalService;

public class RentalSystem {

	public static void main(String[] args) {
		RentalService rentalService = new RentalService();
		Scanner scanner = new Scanner(System.in);
		boolean exit = false;
		while (!exit) {
			System.out.println("Vehicle Rental System :");
			System.out.println("1. Add Vehicle");
			System.out.println("2. List Available Vehicles");
			System.out.println("3. Rent a Vehicle");
			System.out.println("4. Calculate rental cost");
			System.out.println("5.Return vehicle");
			System.out.println("6. Quit");
			System.out.print("Enter your choice :");
			int choice = scanner.nextInt();
			scanner.nextLine();
			switch (choice) {
			case 1:
                addVehicle(rentalService, scanner);
                break;
             case 2:
            	 listAvailableVehicles(rentalService);
                 break;
             case 3:
            	 System.out.print("Enter your licenseNumber: "); 
            	 String licenseNumber =scanner.next();
            	 System.out.print("Enter your customer: "); 
            	 String customer =scanner.next();
				//    rentVehicle(rentalService, scanner);
            	 rentVehicle(licenseNumber, customer);
                 break;
             case 4:
                 calculateRentalCost(rentalService, scanner);
                 break;
             case 5:
                 returnVehicle(rentalService, scanner);
                 break;
             case 6:
                 exit = true;
                 break;
             default:
                 System.out.println("Invalid choice. Please try again.");
         
		}
		}
		}
	public static void rentVehicle(String licenseNumber, Customer customer) {
		 List<Vehicle> vehicles = null;
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getLicensePlate().equals(licenseNumber) && vehicle.isAvailable()) {
                vehicle.setAvailable(false);
                System.out.println("Vehicle with licenseNumber " + licenseNumber + " rented successfully to " + customer.getFirstName()+customer.getLastName());
               
            }
        }
        System.out.println("Vehicle with licenseNumber " + licenseNumber + " not found or already rented.");
	
    }
		/*
		 * private static void rentVehicle(RentalService rentalService, Scanner scanner)
		 * { System.out.print("Enter your first name: "); String firstName =
		 * scanner.nextLine();
		 * 
		 * System.out.print("Enter your last name: "); String lastName =
		 * scanner.nextLine();
		 * 
		 * System.out.println("Enter your mobilenumber: "); Long
		 * phonenumber=scanner.nextLong();
		 * 
		 * System.out.print("Enter your ID: "); Integer customerId = scanner.nextInt();
		 * 
		 * System.out.print("Enter the license plate of the vehicle you want to rent: "
		 * ); String licensePlate = scanner.next();
		 * 
		 * System.out.print("Enter the start date and time (yyyy-MM-dd HH:mm): ");
		 * String startDateTimeStr = scanner.next(); String startTime;
		 * 
		 * try { startTime = startDateTimeStr; } catch (DateTimeParseException e) {
		 * System.out.
		 * println("Invalid date-time format. Please enter in the format yyyy-MM-dd HH:mm."
		 * ); return; }
		 * 
		 * System.out.print("Enter the end date and time (yyyy-MM-dd HH:mm): "); String
		 * endDateTimeStr = scanner.nextLine(); LocalDateTime endTime;
		 * 
		 * try { endTime = LocalDateTime.parse(endDateTimeStr,
		 * DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")); } catch
		 * (DateTimeParseException e) { System.out.
		 * println("Invalid date-time format. Please enter in the format yyyy-MM-dd HH:mm."
		 * ); return; }
		 * 
		 * Customer customer = new Customer(customerId, firstName, lastName,
		 * phonenumber); Vehicle selectedVehicle =
		 * rentalService.getVehicleByLicensePlate(licensePlate);
		 * 
		 * if (selectedVehicle != null) { Rental rental =
		 * rentalService.rentVehicle(customer, selectedVehicle, endTime, endTime);
		 * 
		 * if (rental != null) { System.out.println("Rental successful!"); } else {
		 * System.out.println("The selected vehicle is not available for rent."); } }
		 * else { System.out.println("Invalid license plate. Please try again."); } }
		 */

	    private static void calculateRentalCost(RentalService rentalService, Scanner scanner) {
	        System.out.print("Enter the rental ID: ");
	        String rentalId = scanner.nextLine();

	        Rental rental = rentalService.getRentalById(rentalId);
	        if (rental != null) {
	            BigDecimal rentalCost = rentalService.calculateRentalCost(rental);
	            System.out.println("Rental Cost: $" + rentalCost);
	        } else {
	            System.out.println("Invalid rental ID.");
	        }
	    }

	    private static void returnVehicle(RentalService rentalService, Scanner scanner) {
	        System.out.print("Enter the rental ID: ");
	        String rentalId = scanner.nextLine();

	        Rental rental = rentalService.getRentalById(rentalId);
	        if (rental != null) {
	            boolean success = rentalService.returnVehicle(rental);
	            if (success) {
	                System.out.println("Vehicle returned successfully.");
	            } else {
	                System.out.println("Failed to return the vehicle.");
	            }
	        } else {
	            System.out.println("Invalid rental ID.");
	        }
	    }

	private static void addVehicle(RentalService rentalService, Scanner scanner) {
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
			vehicle = new Car(licensePlate, make, model, carname, numDoors);
			break;
		case "motorcycle":
			System.out.print("Is it electric? (true/false): ");
			boolean isElectric = scanner.nextBoolean();
			vehicle = new Motorcycle(licensePlate, make, model, isElectric);
			break;
		case "bicycle":
			System.out.println("Enter the bicycleName");
			String bicycleName = scanner.next();
			System.out.println("Enter bicycleId");
			Integer bicycleId = scanner.nextInt();
			vehicle = new Bicycle(licensePlate, make, model, bicycleId, bicycleName);
			break;
		default:
			System.out.println("Invalid vehicle type. Vehicle not added.");
			return;
		}
		rentalService.addVehicle(vehicle);
		System.out.println("Vehicle added successfully.");

	}

	private static void listAvailableVehicles(RentalService rentalService) {
		List<Vehicle> availableVehicles = rentalService.getAvailableVehicles();
		if (availableVehicles.isEmpty()) {
			System.out.println("No vehicles available for rent.");
		} else {
			System.out.println("Available Vehicles:"+ availableVehicles.size());
			for (Vehicle vehicle : availableVehicles) {
				System.out.println(availableVehicles );
				System.out.println("License Plate: " + vehicle.getLicensePlate());
				System.out.println("Make: " + vehicle.getMake());
				System.out.println("Model: " + vehicle.getModel());
				System.out.println();
			}
		}

	}
}