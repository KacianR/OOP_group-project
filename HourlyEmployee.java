package SoftwareSolutionsNowPackage;

public class HourlyEmployee extends Employee{

    private double hourlyRate;

    //Default constructor
    public HourlyEmployee() {
        super(); // Call the constructor of the parent class (Employee)
        hourlyRate = 0.0;
 }

    // Primary constructor
    public HourlyEmployee(int id, String firstName, String lastName, String position, Payroll payroll, Department dept, double hourlyRate) {
        super(id, firstName, lastName, position, payroll, dept);
        this.hourlyRate = hourlyRate;
    }
    //copy constructor
    public HourlyEmployee(HourlyEmployee obj){
        super(obj);
        this.hourlyRate = obj.hourlyRate;
    }


    // Getter and Setter for hourlyRate
    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    // Override calculatePay method for HourlyEmployee
    public double calculatePay() {
        // Implement your logic for calculating pay for hourly employees
        // This might involve using hourlyRate, hoursWorked, etc.
        return 1;
    }

    // Override ToString method to include hourlyRate
    public String toString() {
        String show;
        super.toString();

        show = "~Hourly Pay Rate Data~" + "\n";
        show+= "Employee Hourly Pay Rate: " + hourlyRate + "\n";
        show+= "Employee Pay: $" + calculatePay() + "\n";

        return show;
    }

}