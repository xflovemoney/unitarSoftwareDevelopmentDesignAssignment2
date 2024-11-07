package assignment2;

public class Accountant extends BusinessEmployee {
    // Reference to the TechnicalLead that this Accountant is supporting
    public TechnicalLead teamSupported;

    // Constructor for the Accountant class
    // Initializes the Accountant with the given name and sets the bonus budget to 0
    public Accountant(String name) {
        super(name); // Call to the superclass constructor to set the name
        bonusBudget = 0; // Initialize bonus budget to 0
    }

    // Returns the TechnicalLead currently being supported by this Accountant
    public TechnicalLead getTeamSupported() {
        return teamSupported; // Return the current team supported
    }

    // Allows the Accountant to support a TechnicalLead
    // Updates the Accountant's bonus budget based on the salaries of the SoftwareEngineers
    public void supportTeam(TechnicalLead lead) {
        this.teamSupported = lead; // Set the TechnicalLead being supported

        // Calculate the bonus budget based on the SoftwareEngineers' salaries
        for (int i = 0; i < lead.team.size(); i++) {
            // Add the base salary of each SoftwareEngineer plus 10% to the bonus budget
            this.bonusBudget += lead.team.get(i).getBaseSalary() * 1.1;
        }
    }

    // Approves a suggested bonus amount based on the remaining budget
    // Returns true if the bonus can be approved, otherwise false
    public boolean canApproveBonus(double bonus) {
        double requestedBonus = bonus; // Store the requested bonus amount
        
        // Check if the requested bonus is within the budget
        if (requestedBonus <= getBonusBudget()) {
            return true; // Bonus can be approved
        } else {
            // Print a message if the budget is not sufficient
            System.out.print("Rejected because Budget not sufficient.");
            return false; // Bonus cannot be approved
        }
    }

    // Returns a String representation of the Accountant's status
    // Includes their ID, name, budget size, and the name of the supported TechnicalLead
    public String employeeStatus() {
        return this.toString() + " with a budget of " + getBonusBudget() + " is supporting " + this.getTeamSupported();
    }
}
