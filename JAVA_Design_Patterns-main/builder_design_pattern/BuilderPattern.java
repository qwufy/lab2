// Package for implementing the Builder Design Pattern in a Vehicle class

// Class representing a Vehicle
class Vehicle {
  private String engine;
  private int wheel;
  private int airbags;

  // Getter methods for engine, wheel, and airbags
  public String getEngine() {
    return this.engine;
  }

  public int getWheel() {
    return this.wheel;
  }

  public int getAirbags() {
    return this.airbags;
  }

  // Private constructor taking a VehicleBuilder as a parameter
  private Vehicle(VehicleBuilder builder) {
    this.engine = builder.engine;
    this.wheel = builder.wheel;
    this.airbags = builder.airbags;
  }

  // Static nested class representing the VehicleBuilder
  public static class VehicleBuilder {
    private String engine;
    private int wheel;
    private int airbags;

    // Constructor taking engine and wheel parameters
    public VehicleBuilder(String engine, int wheel) {
      this.engine = engine;
      this.wheel = wheel;
    }

    // Method to set the number of airbags
    public VehicleBuilder setAirbags(int airbags) {
      this.airbags = airbags;
      return this;
    }

    // Method to build the Vehicle instance
    public Vehicle build() {
      return new Vehicle(this);
    }
  }
}

// Main class demonstrating the usage of the Builder Pattern
public class BuilderPattern {
  public static void main(String[] args) {
    // Creating a car using the VehicleBuilder with specified engine, wheel, and airbags
    Vehicle car = new Vehicle.VehicleBuilder("1500cc", 4).setAirbags(4).build();

    // Creating a bike using the VehicleBuilder with specified engine and wheel
    Vehicle bike = new Vehicle.VehicleBuilder("250cc", 2).build();

    // Displaying details of the car
    System.out.println("Car details:");
    System.out.println("Engine: " + car.getEngine());
    System.out.println("Wheel count: " + car.getWheel());
    System.out.println("Airbags count: " + car.getAirbags());

    // Displaying details of the bike
    System.out.println("\nBike details:");
    System.out.println("Engine: " + bike.getEngine());
    System.out.println("Wheel count: " + bike.getWheel());
    System.out.println("Airbags count: " + bike.getAirbags());
  }
}
