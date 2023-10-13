package factory_design_pattern;// Package for implementing the Factory Design Pattern in a vehicle system

// Abstract class representing a Vehicle
abstract class Vehicle {
	// Abstract method to get the number of wheels
	public abstract int getWheel();

	// Override toString to display the number of wheels
	public String toString() {
		return "Wheel: " + this.getWheel();
	}
}

// Concrete class representing a Car
class Car extends Vehicle {
	int wheel;

	// Constructor taking the number of wheels as a parameter
	Car(int wheel) {
		this.wheel = wheel;
	}

	// Implementation of the abstract method to get the number of wheels
	@Override
	public int getWheel() {
		return this.wheel;
	}
}

// Concrete class representing a Bike
class Bike extends Vehicle {
	int wheel;

	// Constructor taking the number of wheels as a parameter
	Bike(int wheel) {
		this.wheel = wheel;
	}

	// Implementation of the abstract method to get the number of wheels
	@Override
	public int getWheel() {
		return this.wheel;
	}
}

// Factory class to create instances of different vehicles
class VehicleFactory {
	public static Vehicle getInstance(String type, int wheel) {
		if (type.equals("car")) {
			return new Car(wheel);
		} else if (type.equals("bike")) {
			return new Bike(wheel);
		}
		return null;
	}
}

// Main class demonstrating the usage of the Factory Pattern
public class FactoryPattern {
	public static void main(String[] args) {
		// Creating an instance of a car with 4 wheels
		Vehicle car = VehicleFactory.getInstance("car", 4);
		System.out.println(car);

		// Creating an instance of a bike with 2 wheels
		Vehicle bike = VehicleFactory.getInstance("bike", 2);
		System.out.println(bike);
	}
}
