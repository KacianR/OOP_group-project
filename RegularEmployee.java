package SoftwareSolutionsNowPackage;

public class RegularEmployee extends Employee {
    private double baseSalary;// stores base salary amount

    // Constructors
    // Default constructor
    public RegularEmployee() {
        super();
        baseSalary = 0.99f;
    }

    // primary constructor
    public RegularEmployee(double baSal, int id, String firstName, String lastName,
            String position, Payroll payroll, Department dept) {
        super(id, firstName, lastName, position, payroll, dept);
        this.baseSalary = baSal;

    }

    // copy constructor
    public RegularEmployee(RegularEmployee Obj) {
        super(Obj);
        this.baseSalary = Obj.baseSalary;
    }

    // Getter and Setter for baseSalary
    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    // Method to calculate pay
    public double calculatePay() {
        // Logic to calculate pay for regular employee
        return 0; // baseSalary * hoursWorked;
    }

    // ToString method
    public String toString() {
        String output;

        super.toString();

        output = "~Regular Employee Salary Data~" + "\n";
        output += "Employee's Base Salary: $" + baseSalary + "\n";
        output += "Employee's Pay: $" + calculatePay();

        return output;
    }
}
