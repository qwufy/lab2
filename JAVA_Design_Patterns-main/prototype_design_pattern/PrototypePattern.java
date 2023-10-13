package prototype_design_pattern;// Package for implementing the Prototype Design Pattern in a vehicle system

import java.util.ArrayList;
import java.util.List;

// Prototype class representing a Vehicle
class Vehicle implements Cloneable {
  private List<String> vehicleList;

  // Default constructor initializing the vehicle list
  public Vehicle() {
    this.vehicleList = new ArrayList<String>();
  }

  // Parameterized constructor initializing the vehicle list with provided data
  public Vehicle(List<String> list) {
    this.vehicleList = list;
  }

  // Method to insert data into the vehicle list
  public void insertData() {
    vehicleList.add("Honda Amaze");
    vehicleList.add("Audi A4");
    vehicleList.add("Hyundai Creta");
    vehicleList.add("Maruti Baleno");
    vehicleList.add("Renault Duster");
  }

  // Getter method to retrieve the vehicle list
  public List<String> getVehicleList() {
    return this.vehicleList;
  }

  // Override the clone method to create a deep copy of the object
  @Override
  public Object clone() throws CloneNotSupportedException {
    List<String> tempList = new ArrayList<String>();

    // Copying each element from the original list to the new list
    for (String s : this.getVehicleList()) {
      tempList.add(s);
    }

    // Creating and returning a new Vehicle object with the copied list
    return new Vehicle(tempList);
  }
}

// Main class demonstrating the usage of the Prototype Pattern
public class PrototypePattern {
  public static void main(String[] args) throws CloneNotSupportedException {
    // Creating an original Vehicle object
    Vehicle originalVehicle = new Vehicle();
    originalVehicle.insertData();

    // Cloning the original Vehicle object
    Vehicle clonedVehicle = (Vehicle) originalVehicle.clone();

    // Modifying the cloned object's list
    List<String> clonedList = clonedVehicle.getVehicleList();
    clonedList.add("Honda New Amaze");

    // Displaying the original and modified lists
    System.out.println(originalVehicle.getVehicleList());
    System.out.println(clonedList);

    // Modifying the cloned object's list and displaying both lists again
    clonedList.remove("Audi A4");
    System.out.println(clonedList);
    System.out.println(originalVehicle.getVehicleList());
  }
}
