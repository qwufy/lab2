package adapter_design_pattern;// Package for implementing the Adapter Design Pattern in WebDriver

// Interface defining the common methods for various web drivers
interface WebDriver {
	// Method to get an element
	public void getElement();
	// Method to select an element
	public void selectElement();
}

// Concrete implementation of WebDriver for Chrome
class ChromeDriver implements WebDriver {
	@Override
	public void getElement() {
		System.out.println("Get element from ChromeDriver");
	}

	@Override
	public void selectElement() {
		System.out.println("Select element from ChromeDriver");
	}
}

// Another class representing a different web driver (IE Driver)
class IEDriver {
	// Method to find an element
	public void findElement() {
		System.out.println("Find element from IEDriver");
	}

	// Method to click on an element
	public void clickElement() {
		System.out.println("Click element from IEDriver");
	}
}

// Adapter class to make IEDriver compatible with the WebDriver interface
class WebDriverAdapter implements WebDriver {
	IEDriver ieDriver;

	// Constructor taking an instance of IEDriver
	public WebDriverAdapter(IEDriver ieDriver) {
		this.ieDriver = ieDriver;
	}

	// Implementation of the WebDriver interface's getElement using IEDriver's findElement
	@Override
	public void getElement() {
		ieDriver.findElement();
	}

	// Implementation of the WebDriver interface's selectElement using IEDriver's clickElement
	@Override
	public void selectElement() {
		ieDriver.clickElement();
	}
}

// Main class demonstrating the usage of the Adapter Pattern
public class AdapterPattern {
	public static void main(String[] args) {
		// Creating an instance of ChromeDriver and using its methods
		ChromeDriver chromeDriver = new ChromeDriver();
		chromeDriver.getElement();
		chromeDriver.selectElement();

		// Creating an instance of IEDriver and using its methods
		IEDriver ieDriver = new IEDriver();
		ieDriver.findElement();
		ieDriver.clickElement();

		// Creating an instance of WebDriverAdapter and using it as a WebDriver
		WebDriver webDriverAdapter = new WebDriverAdapter(ieDriver);
		webDriverAdapter.getElement();
		webDriverAdapter.selectElement();
	}
}
