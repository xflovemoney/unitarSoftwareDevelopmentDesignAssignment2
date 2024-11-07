package assignment2;

// Class representing a Technical Employee, which is a type of Employee
public class TechnicalEmployee extends Employee {
    // Instance variable to track the number of successful code check-ins
    public int checkins;

    // Constructor for TechnicalEmployee that initializes the employee with a name
    public TechnicalEmployee(String name) {
        // Call the parent class constructor to initialize the name with a default base salary of 75000
        super(name, 75000.00); 
        checkins = 0; // Initialize the check-in count to zero
    }

    // Method to return a String representation of the Technical Employee's status
    public String employeeStatus() {
        // Return the employee's ID, name, and the number of successful check-ins
        return super.toString() + " has " + checkins + " successful check ins";
    }

    // Method to increment the successful check-in count by one
    public void setCheckin() {
        checkins++; // Increase the check-in count
    }
}
