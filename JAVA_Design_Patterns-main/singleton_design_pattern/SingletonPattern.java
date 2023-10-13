package singleton_design_pattern;// Package for implementing the Singleton Design Pattern in various ways

// Singleton class implemented using eager initialization
class SingletonEager {
  private static SingletonEager instance = new SingletonEager();

  private SingletonEager() {
    // private constructor to prevent instantiation
  }

  public static SingletonEager getInstance() {
    return instance;
  }
}

// Singleton class implemented using lazy initialization without synchronization
class Singleton {
  private static Singleton instance;

  private Singleton() {
    // private constructor to prevent instantiation
  }

  public static Singleton getInstance() {
    if (instance == null) {
      instance = new Singleton();
    }
    return instance;
  }
}

// Singleton class implemented using lazy initialization with synchronized method
class SingletonSynchronizedMethod {
  private static SingletonSynchronizedMethod instance;

  private SingletonSynchronizedMethod() {
    // private constructor to prevent instantiation
  }

  public static synchronized SingletonSynchronizedMethod getInstance() {
    if (instance == null) {
      instance = new SingletonSynchronizedMethod();
    }
    return instance;
  }
}

// Singleton class implemented using lazy initialization with double-checked locking
class SingletonSynchronized {
  private static SingletonSynchronized instance;

  private SingletonSynchronized() {
    // private constructor to prevent instantiation
  }

  public static SingletonSynchronized getInstance() {
    if (instance == null) {
      synchronized (SingletonSynchronized.class) {
        if (instance == null) {
          instance = new SingletonSynchronized();
        }
      }
    }
    return instance;
  }
}

// Main class demonstrating the usage of different Singleton patterns
public class SingletonPattern {
  public static void main(String[] args) {
    // Creating instances of the Singleton classes
    SingletonSynchronized instance = SingletonSynchronized.getInstance();
    System.out.println(instance);

    SingletonSynchronized instance1 = SingletonSynchronized.getInstance();
    System.out.println(instance1);
  }
}
