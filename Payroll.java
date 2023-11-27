package SoftwareSolutionsNowPackage;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Payroll {
    private double hoursWorked;
    private double regularRate;// regular pay rate per hour of work

    // Default Constructors
    public Payroll() {
        hoursWorked = 0.25f;
        regularRate = 0.0f;
    }

    // Primary Constructors
    public Payroll(double regRate, double hoursWorked) {
        this.regularRate = regRate;
        this.hoursWorked = hoursWorked;
    }

    // Getter and Setter methods
    public double getRegularRate() {
        return regularRate;
    }

    public void setRegularRate(double regularRate) {
        this.regularRate = regularRate;
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(double hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public double calculateRegularPay() {
        double regularPay = 0;

        if (hoursWorked >= 40) {
            regularPay = 40 * regularRate + (hoursWorked - 40) * (regularRate * 1.5);
        } else {
            regularPay = hoursWorked * regularRate;
        }

        return regularPay;
    }

    public double calculateOvertimePay() {
        double overtimePay = 0;

        if (hoursWorked > 40) {
            overtimePay = (hoursWorked - 40) * regularRate * 1.5;
        }

        return overtimePay;
    }

    public double calculateGrossPay() {
        double regularPay = calculateRegularPay();
        double overtimePay = calculateOvertimePay();

        return regularPay + overtimePay;
    }

    // Display details as a string
    public String toString() {
        String output;

        output = "Regular Pay: " + calculateRegularPay() + "\n";
        output += "Overtime Pay: " + calculateOvertimePay() + "\n";
        output += "Gross Pay: " + calculateGrossPay() + "\n";

        return output;
    }

    // Write Payroll details to a file
    public void writeToOutputFile(String filename) {
        try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(filename, true)))) {
            writer.println("~~~Payroll Details~~~");
            writer.println("Regular Pay: " + calculateRegularPay());
            writer.println("Overtime Pay: " + calculateOvertimePay());
            writer.println("Gross Pay: " + calculateGrossPay());
            writer.println(); // Add a newline character between payroll records

            System.out.println("Payroll data written to file successfully.");
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

}
