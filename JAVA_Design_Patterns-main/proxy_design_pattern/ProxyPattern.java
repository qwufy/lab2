package proxy_design_pattern;// Package for implementing the Proxy Design Pattern in a database execution system

// Interface representing a Database Executer
interface DatabaseExecuter {
	void executeDatabase(String query) throws Exception;
}

// Concrete class implementing the Database Executer interface
class DatabaseExecuterImpl implements DatabaseExecuter {
	@Override
	public void executeDatabase(String query) throws Exception {
		System.out.println("Going to execute Query: " + query);
	}
}

// Proxy class implementing the Database Executer interface
class DatabaseExecuterProxy implements DatabaseExecuter {
	private boolean ifAdmin;
	private DatabaseExecuterImpl dbExecuter;

	// Constructor initializing the proxy with the provided username and password
	public DatabaseExecuterProxy(String name, String passwd) {
		ifAdmin = (name.equals("Admin") && passwd.equals("Admin@123"));
		dbExecuter = new DatabaseExecuterImpl();
	}

	// Implementation of the executeDatabase method in the proxy
	@Override
	public void executeDatabase(String query) throws Exception {
		if (ifAdmin) {
			// Execute the query if the user is an admin
			dbExecuter.executeDatabase(query);
		} else {
			// Check if the query is DELETE and throw an exception if it is
			if (query.equals("DELETE")) {
				throw new Exception("DELETE not allowed for non-admin user");
			} else {
				// Execute the query for non-admin users
				dbExecuter.executeDatabase(query);
			}
		}
	}
}

// Main class demonstrating the usage of the Proxy Pattern
public class ProxyPattern {
	public static void main(String[] args) throws Exception {
		// Creating instances of the proxy with different users
		DatabaseExecuter nonAdminExecuter = new DatabaseExecuterProxy("NonAdmin", "Admin@123");
		nonAdminExecuter.executeDatabase("DELEE");

		DatabaseExecuter nonAdminExecuterDELETE = new DatabaseExecuterProxy("NonAdmin", "Admin@123");
		nonAdminExecuterDELETE.executeDatabase("DELETE");

		DatabaseExecuter adminExecuter = new DatabaseExecuterProxy("Admin", "Admin@123");
		adminExecuter.executeDatabase("DELETE");
	}
}
