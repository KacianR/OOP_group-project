package SoftwareSolutionsNowPackage;

public class Department
{
	//attributes
	private int departmentCode;//Code of the department
	private String departmentName;//department's name
	private double regularRate;// regular pay rate per hour of work
	private double overtimeRate;//overtime pay rate per hours of overtime
	
	//default constructor
	public Department() {
		
		departmentCode = 123456;
		departmentName  = "Marketing and Research";
		regularRate = 4500.25f;
		overtimeRate = 13500.75f;
	}
	//primary constructor
	public Department(int depCode, String depName, double regRate, double overRate) {
		
		this.departmentCode = depCode;
		this.departmentName =depName;
		this.regularRate = regRate;
		this.overtimeRate = overRate;
	}
	//Getters and setters
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
	public double getOvertimeRate() {
		return overtimeRate;
	}
	public void setOvertimeRate(double overtimeRate) {
		this.overtimeRate = overtimeRate;
	}
	//to string
	public String toString() {
		
		return "Department [departmentCode=" + departmentCode + ", departmentName=" + departmentName + ", regularRate="
				+ regularRate + ", overtimeRate=" + overtimeRate + "]";
	}
	
}
