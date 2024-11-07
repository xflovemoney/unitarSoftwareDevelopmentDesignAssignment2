package assignment2;

import java.util.ArrayList;

// Class representing a Technical Lead, which is a type of Technical Employee and also a Manager
public class TechnicalLead extends TechnicalEmployee {
    // List to hold the Software Engineers that report to this Technical Lead
    public ArrayList<SoftwareEngineer> team;

    // Constructor for TechnicalLead that initializes the TechnicalLead with a name
    public TechnicalLead(String name) {
        // Call the parent class constructor to initialize the Technical Lead as a Technical Employee
        super(name);
        // Set the base salary to 1.3 times the base salary of a Technical Employee
        this.baseSalary *= 1.3;
        // Set the default headcount to 4
        headcount = 4;
        // Initialize the team list to hold Software Engineers
        this.team = new ArrayList<SoftwareEngineer>();
    }

    // Method to check if the Technical Lead has available headcount for direct reports
    public boolean hasHeadCount() {
        // Return true if the current number of team members is less than the allowed headcount
        return team.size() < headcount;
    }

    // Method to add a Software Engineer to the Technical Lead's team
    public boolean addReport(SoftwareEngineer e) {
        // Check if there is headcount available
        if (hasHeadCount()) {
            // Add the Software Engineer to the team and set this Technical Lead as their manager
            team.add(e);
            e.setManager(this);
            return true; // Return true if the employee was successfully added
        } else {
            return false; // Return false if there is no headcount available
        }
    }

    // Method to approve a code check-in for a Software Engineer
    public boolean approveCheckIn(SoftwareEngineer e) {
        // Check if the Software Engineer reports to this Technical Lead and has code access
        if (e.getManager().equals(this) && e.getCodeAccess()) {
            return true; // Return true if both conditions are satisfied
        } else {
            return false; // Return false otherwise
        }
    }

    // Method to request a bonus for an Employee
    public boolean requestBonus(Employee e, double bonus) {
        // Get the BusinessLead that supports this Technical Lead
        BusinessLead businessLead = (BusinessLead) getAccountantSupport().getManager();
        // Check if the BusinessLead approves the bonus
        if (businessLead.approveBonus(e, bonus)) {
            // If approved, return true
            return true;
        } else {
            // If not approved, return false
            return false;
        }
    }

    // Method to get the status of the Technical Lead and their team
    public String getTeamStatus() {
        // Check if the Technical Lead has no direct reports
        if (team.size() == 0) {
            // Return the employee status and indicate no direct reports
            return this.employeeStatus() + " and no direct reports yet";
        } else {
            // String to accumulate team status
            String teamStatus = "";
            // Iterate through the team to build the status of each Software Engineer
            for (int i = 0; i < team.size(); i++) {
                teamStatus += ("    " + team.get(i).employeeStatus() + "\n");
            }
            // Return the Technical Lead's status along with their team's status
            return this.employeeStatus() + " and is managing: \n" + teamStatus;
        }
    }
}
