package assignment2;

import java.util.ArrayList; // Import ArrayList for managing a list of Accountants

public class BusinessLead extends BusinessEmployee {
    // List to hold the direct reports (Accountants) of this BusinessLead
    public ArrayList<Accountant> team;

    // Constructor for the BusinessLead class
    // Initializes a new BusinessLead with a name, base salary, and headcount
    public BusinessLead(String name) {
        super(name); // Call to the superclass constructor to set the name
        this.baseSalary = getBaseSalary() * 2; // Set base salary to twice that of an Accountant
        this.headcount = 10; // Initialize headcount to 10
        this.team = new ArrayList<Accountant>(); // Initialize the list of Accountants
    }

    // Checks if the BusinessLead has remaining headcount for direct reports
    public boolean hasHeadCount() {
        // Return true if the current team size is less than the headcount
        return this.team.size() < this.headcount;
    }

    // Adds an Accountant to the BusinessLead's team
    // Updates the Accountant's supporting team and increases the bonus budget
    public boolean addReport(Accountant e, TechnicalLead supportTeam) {
        // Check if there is headcount available
        if (hasHeadCount()) {
            team.add(e); // Add the Accountant to the team
            e.setManager(this); // Set the current BusinessLead as the Accountant's manager
            e.supportTeam(supportTeam); // Update the Accountant to support the given TechnicalLead
            this.bonusBudget += e.getBonusBudget(); // Increase bonus budget by 110% of the Accountant's salary
            supportTeam.accountantSupport = e; // Set the Accountant as supporting the TechnicalLead
            return true; // Return true indicating the Accountant was successfully added
        } else {
            return false; // Return false if no headcount is available
        }
    }

    // Requests a bonus for a given Employee
    // Deducts the bonus from the BusinessLead's budget if possible
    public boolean requestBonus(Employee e, double bonus) {
        // Check if the bonus amount can be covered by the current budget
        if (bonus <= getBonusBudget()) {
            this.bonusBudget -= bonus; // Deduct the bonus from the BusinessLead's budget
            e.bonusBudget += bonus; // Add the bonus to the Employee's budget
            return true; // Return true indicating the bonus request was successful
        } else {
            return false; // Return false if the budget is insufficient
        }
    }

    // Approves a bonus for an Employee based on their supporting Accountant's budget
    public boolean approveBonus(Employee e, double bonus) {
        // Iterate through each Accountant in the team
        for (int i = 0; i < team.size(); i++) {
            // Check if the Accountant supports the TechnicalLead of the Employee and can approve the bonus
            if ((team.get(i).getTeamSupported()).equals(e.manager) && team.get(i).canApproveBonus(bonus)) {
                e.bonus += bonus; // Grant the bonus to the Employee
                team.get(i).bonusBudget -= bonus; // Deduct the bonus from the Accountant's budget
                return true; // Return true indicating the bonus was approved
            }
        }
        return false; // Return false if no Accountant can approve the bonus
    }

    // Returns the status of the BusinessLead and their team
    public String getTeamStatus() {
        // Check if the team has no direct reports
        if (team.size() == 0) {
            return this.employeeStatus() + " and no direct reports yet"; // Return status indicating no reports
        } else {
            String teamStatus = ""; // Initialize a string to hold the team status
            // Iterate through the team and append each Accountant's status to the teamStatus string
            for (int i = 0; i < team.size(); i++) {
                teamStatus += ("    " + team.get(i).employeeStatus() + "\n"); // Add each Accountant's status
            }
            // Return the BusinessLead's status along with the team status
            return this.employeeStatus() + " and is managing: \n" + teamStatus;
        }
    }
}
