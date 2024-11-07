package assignment2;

// Abstract class representing a generic Employee
public abstract class Employee {
    // Constructor that initializes an Employee with a name and base salary
    public Employee(String name, double baseSalary) {
        this.name = name; // Set the employee's name
        this.baseSalary = baseSalary; // Set the employee's base salary
        countID++; // Increment the static ID counter
        this.employeeID = countID; // Assign a unique employee ID
    }
    // Static variable to keep track of the total number of employees created
    private static int countID; 

    // Instance variables for employee properties
    public String name; // The name of the employee
    public int employeeID; // Unique identifier for each employee
    public double baseSalary; // Base salary of the employee
    public double bonus; // Bonus amount for the employee

    public Employee manager; // Reference to the employee's manager
    public Accountant accountantSupport; // Reference to an Accountant the employee may support
    public int headcount = 0; // Number of direct reports for managers (not used in this base class)

    public double bonusBudget; // Budget available for bonuses



    // Getter method to return the employee's current base salary
    public double getBaseSalary() {
        return this.baseSalary;
    }

    // Getter method to return the employee's name
    public String getName() {
        return this.name;  
    }

    // Getter method to return the employee's unique ID
    public int getEmployeeID() {
        return this.employeeID;
    }

    // Getter method to return a reference to the employee's manager
    public Employee getManager() {
        return manager;
    }

    // Getter method to return the Accountant the employee supports
    public Accountant getAccountantSupport() {
        return accountantSupport;
    }

    // Setter method to assign a manager to the employee
    public void setManager(Employee manager) {
        this.manager = manager;
    }

    // Method to check equality of two Employee objects based on their IDs
    public boolean equals(Employee other) {
        return this.getEmployeeID() == other.getEmployeeID(); // Return true if IDs match
    }

    // Returns a String representation of the employee in the format "ID Name"
    public String toString() {
        return getEmployeeID() + " " + getName();
    }

    // Abstract method to be implemented by subclasses to return specific employee status
    public abstract String employeeStatus();

    // Placeholder method for getting a bonus (not implemented here)
    public void getBonus() {
        // Logic for getting a bonus can be defined in subclasses
    }
}
