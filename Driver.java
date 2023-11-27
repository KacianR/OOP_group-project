package SoftwareSolutionsNowPackage;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.SwingUtilities;

public class Driver {
    private static final String EMPLOYEE_FILE = "employee_data.txt";
    private static final String DEPARTMENT_FILE = "department_data.txt";
    // private static final String PAYROLL_FILE = "payroll.txt";
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        List<Employee> employeeList = new ArrayList<>();
        List<Department> departmentList = new ArrayList<>();

        // loadEmployeeData(employeeList, EMPLOYEE_FILE);
        // loadDepartmentData(departmentList, DEPARTMENT_FILE);

        SwingUtilities.invokeLater(() -> {
            PayrollGUI payrollGUI = new PayrollGUI(employeeList, departmentList);
            payrollGUI.setVisible(true);

            // Save data when the GUI is closed
            payrollGUI.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                    saveEmployeeData(employeeList, EMPLOYEE_FILE);
                    saveDepartmentData(departmentList, DEPARTMENT_FILE);
                    System.exit(0);
                }
            });
        });

        while (true) {
            System.out.println("Entering SSN Payroll Management System.");
            System.out.println("Please select an option: ");
            System.out.println("1. Add Employee to Record");
            System.out.println("2. Update an Employee Record");
            System.out.println("3. View an Employee Record");
            System.out.println("4. View All Employee Record");
            System.out.println("5. View All in Department");
            System.out.println("6. Delete a record");
            System.out.println("7. Manage Departments");
            System.out.println("8. Exit");
            System.out.println("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Add new employee record
                    System.out.println("\nAdding new Employee to SSN Payroll Management System.\n");
                    System.out.println("Enter Employee ID: ");
                    int employeeID = scanner.nextInt();// accepts int from user for employee id number
                    System.out.println("Enter first name: ");
                    scanner.nextLine(); // Consume the newline character
                    String firstName = scanner.nextLine();// Accepts string from user for employee first name
                    System.out.println("Enter last name: ");
                    String lastName = scanner.nextLine();// Accepts string from user for employee last name
                    System.out.println("Enter department code: ");
                    int departmentCode = scanner.nextInt();// Accepts string from user for department code
                    System.out.println("Enter position: ");
                    scanner.nextLine(); // Consume the newline character
                    String position = scanner.nextLine(); // Accepts string from user for employee position
                    System.out.println("Enter hours worked: ");
                    double hoursWorked = scanner.nextDouble(); // Accepts string from user for hours worked by employee

                    try {
                        if (hoursWorked <= 0 || hoursWorked >= 80) {// checks hoursworked for errors
                            System.out.println("\n");
                            System.out.println("Hours Worked is: " + hoursWorked + " hours!");
                            System.out.println("There is an Error!");
                            System.out.println("\n");
                            break;
                        }
                    } catch (Exception e) {
                        System.out.println("\n");
                        System.out.println("ERROR, Hours Worked cannot exceed 80 or be below 0!");
                        System.out.println("\n");
                        break;
                    } finally {
                        System.out.println("Checked Hours Worked Input for errors.");
                        System.out.println("\n");
                    }

                    System.out.println("Enter department name: ");// Accepts data from user for Department name
                    scanner.nextLine(); // Consume the newline character
                    String departmentName = scanner.nextLine();
                    System.out.println("Enter Regular Pay Rate per Hour: "); // Accepts data from user for Hourly pay
                    double regularRate = scanner.nextDouble();

                    Department department = new Department(departmentCode, departmentName, regularRate);
                    departmentList.add(department);
                    saveDepartmentData(departmentList, DEPARTMENT_FILE);
                    department.writeToOutputFile(DEPARTMENT_FILE);

                    Payroll payroll = new Payroll(regularRate, hoursWorked);
                    payroll.writeToOutputFile("payroll_data.txt");

                    Employee newEmployee = new Employee(employeeID, firstName, lastName, position, payroll, department);
                    employeeList.add(newEmployee);
                    System.out.println("\nCompleted Adding Employee to SSN Payroll Management System.\n\n");
                    saveEmployeeData(employeeList, EMPLOYEE_FILE);
                    newEmployee.writeToOutputFile(EMPLOYEE_FILE);

                    break;

                case 2:
                    // Update existing employee record
                    System.out.println("\nUpdating Employee data in SSN Payroll Management System.\n\n");
                    System.out.println("Enter Employee ID to update: ");
                    int employeeIDToUpdate = scanner.nextInt();
                    boolean found = false;
                    for (Employee employee : employeeList) {
                        if (employee.getId() == employeeIDToUpdate) {
                            found = true;
                            System.out.println("Enter new hours worked: ");
                            double newHoursWorked = scanner.nextDouble();
                            employee.getPayroll().setHoursWorked(newHoursWorked);
                            System.out.println("Employee record updated successfully.");
                            employee.getPayroll().writeToOutputFile("payroll_data.txt");
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Employee not found.");
                    }
                    System.out.println("\nExiting Employee Data Update.\n");
                    break;

                case 3:
                    // View a single employee record
                    System.out.println("Entering Records view for SSN");
                    System.out.println("Enter Employee ID to view: ");
                    int employeeIDToView = scanner.nextInt();
                    for (Employee employee : employeeList) {
                        if (employee.getId() == employeeIDToView) {
                            System.out.println(employee.toString());
                            System.out.println("Payroll Details:");
                            System.out.println(employee.getPayroll().toString());
                            break;
                        }
                    }
                    System.out.println("Exiting Records view for SSN");
                    break;
                case 4:
                    // View all employee records
                    System.out.println("Employee Records Display");
                    for (Employee employee : employeeList) {
                        System.out.println(employee.toString() + "\n");
                    }
                    break;
                case 5:
                    // View all employee records for a specified department
                    System.out.println("Enter department code to view: ");
                    int departmentCodeToView = scanner.nextInt();
                    System.out.println("Display off Employee's in this department.");
                    for (Employee employee : employeeList) {
                        if (employee.getDept().getDepartmentCode() == departmentCodeToView) {
                            System.out.println(employee.toString() + "\n");
                        }
                    }
                    break;
                case 6:
                    // Delete an employee record
                    System.out.println("You are about to delete an Employee's Data.");
                    System.out.println("Enter Employee ID to delete: ");
                    int employeeIDToDelete = scanner.nextInt();
                    for (Employee employee : employeeList) {
                        if (employee.getId() == employeeIDToDelete) {
                            employeeList.remove(employee);
                            System.out.println("Employee record deleted successfully.");
                            break;
                        }
                    }
                    break;
                case 7:
                    // Department management options
                    while (true) {
                        System.out.println("1. Add Department");
                        System.out.println("2. Update Department");
                        System.out.println("3. View Department");
                        System.out.println("4. View All Departments");
                        System.out.println("5. Exit Department Management");
                        System.out.println("Enter your choice: ");
                        int departmentChoice = scanner.nextInt();

                        switch (departmentChoice) {
                            case 1:
                                System.out.println("Enter department code: ");
                                int code = scanner.nextInt();
                                scanner.nextLine();
                                System.out.println("Enter department name: ");
                                String name = scanner.nextLine();
                                System.out.println("Enter regular rate: ");
                                regularRate = scanner.nextDouble();

                                Department newDepartment = new Department(code, name, regularRate);
                                departmentList.add(newDepartment);
                                System.out
                                        .println("\nCompleted Adding Department to SSN Payroll Management System.\n\n");
                                saveDepartmentData(departmentList, DEPARTMENT_FILE);
                                newDepartment.writeToOutputFile(DEPARTMENT_FILE);

                                break;

                            case 2:
                                System.out.println("Enter department code to update: ");
                                int codeToUpdate = scanner.nextInt();
                                found = false;
                                for (Department Department : departmentList) {
                                    if (Department.getDepartmentCode() == codeToUpdate) {
                                        found = true;
                                        System.out.println("Enter new regular rate: ");
                                        double newRegularRate = scanner.nextDouble();
                                        // System.out.println("Enter new overtime rate: ");
                                        // double newOvertimeRate = scanner.nextDouble();
                                        Department.setRegularRate(newRegularRate);
                                        System.out.println("Department record updated successfully.");

                                        break;
                                    }
                                }
                                if (!found) {
                                    System.out.println("Department not found.");
                                }
                                break;
                            case 3:
                                System.out.println("Enter department code to view: ");
                                int codeToView = scanner.nextInt();
                                for (Department Department : departmentList) {
                                    if (Department.getDepartmentCode() == codeToView) {
                                        System.out.println(Department.toString());
                                        break;
                                    }
                                }
                                break;
                            case 4:
                                for (Department Department : departmentList) {
                                    System.out.println(Department.toString() + "\n");
                                }
                                break;
                            case 5:
                                System.exit(0);
                                break;
                            default:
                                System.out.println("Invalid choice. Please try again.");
                        }

                        if (departmentChoice == 5) {
                            saveDepartmentData(departmentList, DEPARTMENT_FILE);
                            break;
                        }
                    }
                    break;
                case 8:
                    saveEmployeeData(employeeList, EMPLOYEE_FILE);
                    saveDepartmentData(departmentList, DEPARTMENT_FILE);
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void saveEmployeeData(List<Employee> employeeList, String fileName) {
        try (FileWriter writer = new FileWriter(fileName)) {
            for (Employee employee : employeeList) {
                // Write employee.toString() to the file
                writer.write(employee.toString());
                writer.write("\n");
            }
        } catch (IOException e) {
            System.out.println("Error saving employee data to file.");
        }
    }

    private static void saveDepartmentData(List<Department> departmentList, String fileName) {
        try (FileWriter writer = new FileWriter(fileName)) {
            for (Department department : departmentList) {
                // Write department.toString() to the file
                writer.write(department.toString());
                writer.write("\n");
            }
        } catch (IOException e) {
            System.out.println("Error saving department data to file.");
        }
    }
}
