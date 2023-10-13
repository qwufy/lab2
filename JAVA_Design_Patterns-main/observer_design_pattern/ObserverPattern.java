package observer_design_pattern;// Package for implementing the Observer Design Pattern in a delivery system

import java.util.ArrayList;
import java.util.List;

// Interface representing a Subject
interface Subject {
    void register(Observer obj);

    void unregister(Observer obj);

    void notifyObservers();
}

// Concrete class representing delivery data as a Subject
class DeliveryData implements Subject {
    private List<Observer> observers;
    private String location;

    public DeliveryData() {
        this.observers = new ArrayList<>();
    }

    @Override
    public void register(Observer obj) {
        observers.add(obj);
    }

    @Override
    public void unregister(Observer obj) {
        observers.remove(obj);
    }

    @Override
    public void notifyObservers() {
        for (Observer obj : observers) {
            obj.update(location);
        }
    }

    // Method to simulate a change in location
    public void locationChanged() {
        this.location = getLocation();
        notifyObservers();
    }

    // Method to get a simulated location
    public String getLocation() {
        return "YPlace";
    }
}

// Interface representing an Observer
interface Observer {
    void update(String location);
}

// Concrete class representing a Seller as an Observer
class Seller implements Observer {
    private String location;

    @Override
    public void update(String location) {
        this.location = location;
        showLocation();
    }

    public void showLocation() {
        System.out.println("Notification at Seller - Current Location: " + location);
    }
}

// Concrete class representing a User as an Observer
class User implements Observer {
    private String location;

    @Override
    public void update(String location) {
        this.location = location;
        showLocation();
    }

    public void showLocation() {
        System.out.println("Notification at User - Current Location: " + location);
    }
}

// Concrete class representing a Warehouse Center as an Observer
class DeliveryWarehouseCenter implements Observer {
    private String location;

    @Override
    public void update(String location) {
        this.location = location;
        showLocation();
    }

    public void showLocation() {
        System.out.println("Notification at Warehouse - Current Location: " + location);
    }
}

// Main class demonstrating the usage of the Observer Pattern
public class ObserverPattern {
    public static void main(String[] args) {
        // Creating a delivery data topic
        DeliveryData topic = new DeliveryData();

        // Creating observers (Seller, User, DeliveryWarehouseCenter)
        Observer obj1 = new Seller();
        Observer obj2 = new User();
        Observer obj3 = new DeliveryWarehouseCenter();

        // Registering observers to the delivery data topic
        topic.register(obj1);
        topic.register(obj2);
        topic.register(obj3);

        // Simulating a location change and notifying observers
        topic.locationChanged();

        // Unregistering one observer (DeliveryWarehouseCenter)
        topic.unregister(obj3);

        // Simulating another location change and notifying remaining observers
        System.out.println();
        topic.locationChanged();
    }
}
