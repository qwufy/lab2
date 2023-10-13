package flyweight_design_pattern;// Package for implementing the Flyweight Design Pattern in an employee system

import java.util.HashMap;
import java.util.Random;

// Interface representing an Employee
interface Employee {
  void assignSkill(String skill);

  void task();
}

// Concrete class representing a Developer
class Developer implements Employee {
  private final String JOB;
  private String skill;

  // Constructor initializing the job
  public Developer() {
    JOB = "Fix the issue";
  }

  // Implementation of assigning a skill to the Developer
  @Override
  public void assignSkill(String skill) {
    this.skill = skill;
  }

  // Implementation of performing a task
  @Override
  public void task() {
    System.out.println("Developer with skill: " + this.skill + " with Job: " + JOB);
  }
}

// Concrete class representing a Tester
class Tester implements Employee {
  private final String JOB;
  private String skill;

  // Constructor initializing the job
  public Tester() {
    JOB = "Test the issue";
  }

  // Implementation of assigning a skill to the Tester
  @Override
  public void assignSkill(String skill) {
    this.skill = skill;
  }

  // Implementation of performing a task
  @Override
  public void task() {
    System.out.println("Tester with Skill: " + this.skill + " with Job: " + JOB);
  }
}

// Factory class to create instances of different employees
class EmployeeFactory {
  private static HashMap<String, Employee> m = new HashMap<String, Employee>();

  // Method to get an instance of an Employee
  public static Employee getEmployee(String type) {
    Employee p = null;

    // If the employee instance already exists, return it
    if (m.get(type) != null) {
      p = m.get(type);
    } else {
      // Create a new instance based on the employee type
      switch (type) {
        case "Developer":
          System.out.println("Developer Created");
          p = new Developer();
          break;
        case "Tester":
          System.out.println("Tester Created");
          p = new Tester();
          break;
        default:
          System.out.println("No Such Employee");
      }

      // Cache the instance for future use
      m.put(type, p);
    }

    return p;
  }
}

// Main class demonstrating the usage of the Flyweight Pattern
public class FlyweightPattern {
  private static String employeeType[] = {"Developer", "Tester"};
  private static String skills[] = {"Java", "C++", ".Net", "Python"};

  public static void main(String[] args) {
    // Generate and assign tasks to employees with different skills
    for (int i = 0; i < 10; i++) {
      Employee e = EmployeeFactory.getEmployee(getRandEmployee());
      e.assignSkill(getRandSkill());
      e.task();
    }
  }

  // Helper method to get a random employee type
  public static String getRandEmployee() {
    Random r = new Random();
    int randInt = r.nextInt(employeeType.length);
    return employeeType[randInt];
  }

  // Helper method to get a random skill
  public static String getRandSkill() {
    Random r = new Random();
    int randInt = r.nextInt(skills.length);
    return skills[randInt];
  }
}
