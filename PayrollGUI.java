//old GUI 

package SoftwareSolutionsNowPackage;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class PayrollGUI extends JFrame {
    private List<Employee> employeeList;
    private List<Department> departmentList;

    public PayrollGUI(List<Employee> employeeList, List<Department> departmentList) {
        super("SSN Payroll Management System");
        this.employeeList = employeeList;
        this.departmentList = departmentList;
        initializeUI();
    }

    private void initializeUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 500);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(4, 2));

        JLabel labelEmployeeID = new JLabel("Employee ID:");
        JTextField textFieldEmployeeID = new JTextField(15);
        JLabel labelFirstName = new JLabel("First Name:");
        JTextField textFieldFirstName = new JTextField(15);
        JLabel labelLastName = new JLabel("Last Name:");
        JTextField textFieldLastName = new JTextField(15);
        JLabel labelDepartmentCode = new JLabel("Department Code:");
        JTextField textFieldDepartmentCode = new JTextField(15);
        JLabel labelPosition = new JLabel("Position:");
        JTextField textFieldPosition = new JTextField(15);
        JLabel labelHoursWorked = new JLabel("Hours Worked:");
        JTextField textFieldHoursWorked = new JTextField(15);
        JLabel labelRegularRate = new JLabel("Pay Rate:");
        JTextField textFieldRegularRate = new JTextField(15);

        JButton addButton = new JButton("Add Employee");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int employeeID = Integer.parseInt(textFieldEmployeeID.getText());
                    String firstName = textFieldFirstName.getText();
                    String lastName = textFieldLastName.getText();
                    int departmentCode = Integer.parseInt(textFieldDepartmentCode.getText());
                    String position = textFieldPosition.getText();
                    double hoursWorked = Double.parseDouble(textFieldHoursWorked.getText());
                    double regularRate = Double.parseDouble(textFieldRegularRate.getText());

                    // Create Department object or retrieve existing one
                    Department department = findOrCreateDepartment(departmentCode);

                    // Create Payroll object
                    Payroll payroll = new Payroll(regularRate, hoursWorked);

                    // Create Employee object and add to the list
                    Employee employee = new Employee(employeeID, firstName, lastName, position, payroll, department);
                    employeeList.add(employee);

                    JOptionPane.showMessageDialog(null, "Employee added successfully", "Success",
                            JOptionPane.INFORMATION_MESSAGE);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid input. Please enter valid numeric values.", "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        mainPanel.add(labelEmployeeID);
        mainPanel.add(textFieldEmployeeID);
        mainPanel.add(labelFirstName);
        mainPanel.add(textFieldFirstName);
        mainPanel.add(labelLastName);
        mainPanel.add(textFieldLastName);
        mainPanel.add(labelDepartmentCode);
        mainPanel.add(textFieldDepartmentCode);
        mainPanel.add(labelPosition);
        mainPanel.add(textFieldPosition);
        mainPanel.add(labelHoursWorked);
        mainPanel.add(textFieldHoursWorked);
        mainPanel.add(addButton);
        mainPanel.add(labelRegularRate);
        mainPanel.add(textFieldRegularRate);

        add(mainPanel);
        pack();
        setLocationRelativeTo(null); // Center the frame
        setVisible(true);
    }
    

    private Department findOrCreateDepartment(int departmentCode) {
        for (Department department : departmentList) {
            if (department.getDepartmentCode() == departmentCode) {
                return department;
            }
        }

        // If department does not exist, create a new one
        Department newDepartment = new Department(departmentCode, "", 0.0);
        departmentList.add(newDepartment);
        return newDepartment;
    }

    public static void main(String[] args) {
        List<Employee> employeeList = new ArrayList<>();
        List<Department> departmentList = new ArrayList<>();

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new PayrollGUI(employeeList, departmentList).setVisible(true);
            }
        });
    }
}
