package assignment2;

// Class representing a Software Engineer, which is a type of Technical Employee
public class SoftwareEngineer extends TechnicalEmployee {
    // Instance variable to track if the Software Engineer has code access
    public boolean CodeAccess;

    // Constructor for SoftwareEngineer that initializes the employee with a name
    public SoftwareEngineer(String name) {
        super(name); // Call the parent class constructor to initialize the name
        setCodeAccess(false); // Initially set code access to false (no access to code)
    }

    // Getter method to check if the Software Engineer has code access
    public boolean getCodeAccess() {
        return CodeAccess; // Return the current code access status
    }

    // Setter method to update the Software Engineer's code access privileges
    public void setCodeAccess(boolean access) {
        this.CodeAccess = access; // Set the code access status to the provided value
    }

    // Getter method to return the number of successful code check-ins
    public int getSuccessfulCheckIns() {
        return checkins; // Return the count of successful check-ins
    }

    // Method to attempt checking in code; returns true if successful, false otherwise
    public boolean checkInCode() {
        // Cast the manager reference to TechnicalLead
        TechnicalLead manager = (TechnicalLead) this.getManager(); 

        // Check if the manager approves the check-in
        if (manager.approveCheckIn(this)) {
            this.checkins++; // Increment the count of successful check-ins
            manager.setCheckin();
            return true; // Return true for a successful check-in
        } else {
            // If check-in is not approved, revoke code access
            CodeAccess = false; 
            return false; // Return false for an unsuccessful check-in
        }
    }
}
