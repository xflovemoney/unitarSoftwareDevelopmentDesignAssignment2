package assignment2;

public class BusinessEmployee extends Employee {
    // BusinessEmployee constructor
    // Initializes a BusinessEmployee with a default salary of 50000
    public BusinessEmployee(String name) {
        super(name, 50000.00); // Call to the superclass constructor to set the name and default salary
    }

    // Returns the current bonus budget for this BusinessEmployee
    // The exact budget calculation will depend on the specific type of BusinessEmployee
    public double getBonusBudget() {
        return bonusBudget; // Return the remaining bonus budget
    }

    // Sets the bonus budget for this BusinessEmployee
    public void setBonusBudget(double bonusBudget) {
        this.bonusBudget = bonusBudget; // Update the bonus budget with the provided value
    }

    // Returns a String representation of this BusinessEmployee
    // Includes their ID, name, and the size of their currently managed budget
    public String employeeStatus() {
        // Format the bonus budget to two decimal places
        String s = String.format("%.2f", bonusBudget);
        // Return a string that includes the BusinessEmployee's details
        return this.toString() + " with a budget of " + s;
    }
}