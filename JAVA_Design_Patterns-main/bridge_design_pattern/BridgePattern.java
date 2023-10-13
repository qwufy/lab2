// Package for implementing the Bridge Design Pattern in TV and Remote systems

// Abstract class representing a TV
abstract class TV {
    Remote remote;

    // Constructor taking a Remote instance
    TV(Remote r) {
        this.remote = r;
    }

    // Abstract methods to turn the TV on and off
    abstract void on();

    abstract void off();
}

// Concrete class representing a Sony TV
class Sony extends TV {
    Remote remoteType;

    // Constructor taking a Remote instance
    Sony(Remote r) {
        super(r);
        this.remoteType = r;
    }

    // Implementation of turning Sony TV on
    public void on() {
        System.out.print("Sony TV ON: ");
        remoteType.on();
    }

    // Implementation of turning Sony TV off
    public void off() {
        System.out.print("Sony TV OFF: ");
        remoteType.off();
    }
}

// Concrete class representing a Philips TV
class Philips extends TV {
    Remote remoteType;

    // Constructor taking a Remote instance
    Philips(Remote r) {
        super(r);
        this.remoteType = r;
    }

    // Implementation of turning Philips TV on
    public void on() {
        System.out.print("Philips TV ON: ");
        remoteType.on();
    }

    // Implementation of turning Philips TV off
    public void off() {
        System.out.print("Philips TV OFF: ");
        remoteType.off();
    }
}

// Interface representing a Remote control
interface Remote {
    // Method to turn on the device
    public void on();

    // Method to turn off the device
    public void off();
}

// Concrete class representing an old type of Remote
class OldRemote implements Remote {
    @Override
    public void on() {
        System.out.println("ON with Old Remote");
    }

    @Override
    public void off() {
        System.out.println("OFF with old Remote");
    }
}

// Concrete class representing a new type of Remote
class NewRemote implements Remote {
    @Override
    public void on() {
        System.out.println("ON with New Remote");
    }

    @Override
    public void off() {
        System.out.println("OFF with New Remote");
    }
}

// Main class demonstrating the usage of the Bridge Pattern
public class BridgePattern {
    public static void main(String[] args) {
        // Creating a Sony TV with an old remote and using it
        TV sonyOldRemote = new Sony(new OldRemote());
        sonyOldRemote.on();
        sonyOldRemote.off();
        System.out.println();

        // Creating a Sony TV with a new remote and using it
        TV sonyNewRemote = new Sony(new NewRemote());
        sonyNewRemote.on();
        sonyNewRemote.off();
        System.out.println();

        // Creating a Philips TV with an old remote and using it
        TV philipsOldRemote = new Philips(new OldRemote());
        philipsOldRemote.on();
        philipsOldRemote.off();
        System.out.println();

        // Creating a Philips TV with a new remote and using it
        TV philipsNewRemote = new Philips(new NewRemote());
        philipsNewRemote.on();
        philipsNewRemote.off();
    }
}
