package SoftwareSolutionsNowPackage;


public class Department
{
	// attributes
	  private int departmentCode;// Code of the department
	  private String departmentName;// department's name
	  private double regularRate;// regular pay rate per hour of work
	  

	  // default constructor
	  public Department() {

	    departmentCode = 123456;
	    departmentName = "Marketing and Research";
	    regularRate = 0.0f;
	    //overtimeRate = 0.0f;
	  }

	  // primary constructor
	  public Department(int depCode, String depName, double regRate) {

	    this.departmentCode = depCode;
	    this.departmentName = depName;
	    this.regularRate = regRate;
	    //this.overtimeRate = overRate;
	  }

	  // Getters and setters
	  public int getDepartmentCode() {
	    return departmentCode;
	  }

	  public void setDepartmentCode(int departmentCode) {
	    this.departmentCode = departmentCode;
	  }

	  public String getDepartmentName() {
	    return departmentName;
	  }

	  public void setDepartmentName(String departmentName) {
	    this.departmentName = departmentName;
	  }

	  public double getRegularRate() {
	    return regularRate;
	  }

	  public void setRegularRate(double regularRate) {
	    this.regularRate = regularRate;
	  }

	  /*public double getOvertimeRate() {
	    return overtimeRate;
	  }

	  public void setOvertimeRate(double overtimeRate) {
	    this.overtimeRate = overtimeRate;
	  }*/

		//to string
	  public String toString() {
	    String output;
	    output = "~~~Departement Details~~~" + "\n";
	    output += "Department Code: " + departmentCode + "\n";
	    output += "Department Name: " + departmentName + "\n";
	    output += "Regular Rate: " + regularRate + "\n";
	    //output += "Overtime Rate: " + overtimeRate + "\n";

	    return output;
	  }
		
	
}
