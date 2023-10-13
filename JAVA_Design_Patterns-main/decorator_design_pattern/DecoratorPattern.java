// Package for implementing the Decorator Design Pattern in a dress system

// Interface representing a Dress
interface Dress {
	void assemble();
}

// Concrete class representing a Basic Dress
class BasicDress implements Dress {
	@Override
	public void assemble() {
		System.out.println("Basic Dress Features");
	}
}

// Abstract class representing a Dress Decorator
abstract class DressDecorator implements Dress {
	protected Dress dress;

	// Constructor taking a Dress instance
	public DressDecorator(Dress c) {
		this.dress = c;
	}

	// Implementation of the assemble method
	@Override
	public void assemble() {
		this.dress.assemble();
	}
}

// Concrete class representing a Casual Dress
class CasualDress extends DressDecorator {
	public CasualDress(Dress c) {
		super(c);
	}

	@Override
	public void assemble() {
		super.assemble();
		System.out.println("Adding Casual Dress Features");
	}
}

// Concrete class representing a Sporty Dress
class SportyDress extends DressDecorator {
	public SportyDress(Dress c) {
		super(c);
	}

	@Override
	public void assemble() {
		super.assemble();
		System.out.println("Adding Sporty Dress Features");
	}
}

// Concrete class representing a Fancy Dress
class FancyDress extends DressDecorator {
	public FancyDress(Dress c) {
		super(c);
	}

	@Override
	public void assemble() {
		super.assemble();
		System.out.println("Adding Fancy Dress Features");
	}
}

// Main class demonstrating the usage of the Decorator Pattern
public class DecoratorPattern {
	public static void main(String[] args) {
		// Creating a Sporty Dress on top of a Basic Dress
		Dress sportyDress = new SportyDress(new BasicDress());
		sportyDress.assemble();
		System.out.println();

		// Creating a Fancy Dress on top of a Basic Dress
		Dress fancyDress = new FancyDress(new BasicDress());
		fancyDress.assemble();
		System.out.println();

		// Creating a Casual Dress on top of a Basic Dress
		Dress casualDress = new CasualDress(new BasicDress());
		casualDress.assemble();
		System.out.println();

		// Creating a Sporty Dress on top of a Fancy Dress on top of a Basic Dress
		Dress sportyFancyDress = new SportyDress(new FancyDress(new BasicDress()));
		sportyFancyDress.assemble();
		System.out.println();

		// Creating a Casual Dress on top of a Fancy Dress on top of a Basic Dress
		Dress casualFancyDress = new CasualDress(new FancyDress(new BasicDress()));
		casualFancyDress.assemble();
	}
}
