package composite_design_pattern;
// Package for implementing the Composite Design Pattern in a banking system

import java.util.ArrayList;
import java.util.List;

// Abstract class representing an Account
abstract class Account {
  // Abstract method to get the balance
  public abstract float getBalance();
}

// Concrete class representing a Deposit Account
class DepositAccount extends Account {
  private String accountNo;
  private float accountBalance;

  // Constructor taking account number and balance
  public DepositAccount(String accountNo, float accountBalance) {
    super();
    this.accountNo = accountNo;
    this.accountBalance = accountBalance;
  }

  // Implementation of the abstract method to get the balance
  public float getBalance() {
    return accountBalance;
  }
}

// Concrete class representing a Savings Account
class SavingsAccount extends Account {
  private String accountNo;
  private float accountBalance;

  // Constructor taking account number and balance
  public SavingsAccount(String accountNo, float accountBalance) {
    super();
    this.accountNo = accountNo;
    this.accountBalance = accountBalance;
  }

  // Implementation of the abstract method to get the balance
  public float getBalance() {
    return accountBalance;
  }
}

// Composite class representing a group of accounts
class CompositeAccount extends Account {
  private float totalBalance;
  private List<Account> accountList = new ArrayList<Account>();

  // Implementation of the abstract method to get the balance
  public float getBalance() {
    totalBalance = 0;
    for (Account acc : accountList) {
      totalBalance += acc.getBalance();
    }
    return totalBalance;
  }

  // Method to add an account to the group
  public void addAccount(Account acc) {
    accountList.add(acc);
  }

  // Method to remove an account from the group
  public void removeAccount(Account acc) {
    accountList.remove(acc);
  }
}

// Main class demonstrating the usage of the Composite Pattern
public class CompositePattern {
  public static void main(String[] args) {
    // Creating a composite account
    CompositeAccount compositeAccount = new CompositeAccount();

    // Adding various accounts to the composite account
    compositeAccount.addAccount(new DepositAccount("DA001", 100));
    compositeAccount.addAccount(new DepositAccount("DA002", 150));
    compositeAccount.addAccount(new SavingsAccount("SA001", 200));

    // Getting the total balance of the composite account
    float totalBalance = compositeAccount.getBalance();
    System.out.println("Total Balance: " + totalBalance);
  }
}
