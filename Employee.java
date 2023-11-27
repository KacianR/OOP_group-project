//Old employee 

package SoftwareSolutionsNowPackage;




public class Employee {
	    protected int id;
	    protected String firstName;
	    protected String lastName;
	    protected String position;
	    protected Payroll payroll;
	    protected Department dept;

	    // Default Constructors
	    public Employee() {
	    	id = 123;
	        firstName = "Bob";
	        lastName = "Dylan";
	        position = "Accountant";	       
	        payroll = new Payroll();
	        dept = new Department();
	    }
	    //primary constructor
	    public Employee(int id, String firstName, String lastName, String position, Payroll payroll, Department dept) 
	    {
	        this.id = id;
	        this.firstName = firstName;
	        this.lastName = lastName;
	        this.position = position;	        
	        this.payroll = payroll;
	        this.dept = dept;
	    }
	    
	    //copy constructor
	    public Employee(Employee obj) {
	    	this.id = obj.id;
	        this.firstName = obj.firstName;
	        this.lastName = obj.lastName;
	        this.position = obj.position;	        
	        this.payroll = obj.payroll;
	        this.dept = obj.dept;
	    }
	    
	    // Getters and Setters

	    public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
	    public String getFirstName() {
	        return firstName;
	    }

	    public void setFirstName(String firstName) {
	        this.firstName = firstName;
	    }

	    public String getLastName() {
	        return lastName;
	    }

	    public void setLastName(String lastName) {
	        this.lastName = lastName;
	    }

	   public String getPosition() {
	        return position;
	    }

	    public void setPosition(String position) {
	        this.position = position;
	    }
	    
		public Payroll getPayroll() {
			return payroll;
		}
		public void setPayroll(Payroll payroll) {
			this.payroll = payroll;
		}
		public Department getDept() {
			return dept;
		}
		public void setDept(Department dept) {
			this.dept = dept;
		}
		// ToString method	    
	    public String toString() {
	    	String out;
	    	
	    	out = "~~~Employee Details~~~" + "\n";
	    	out += "Employee Id Number: " + id + "\n";
	    	out += "Employee First Name: " + firstName + "\n";
	    	out += "Employee Last Name: " + lastName + "\n";
	    	out += "Employee Department code: " + dept.getDepartmentCode() + "\n";
	    	out += "Employee's Position: " + position + "\n";
            out += "Hours Worked by Employee: " + payroll.getHoursWorked() + "\n";
            out += "Payroll Data for Employee: \n" + payroll.toString();
            out += "Employee's Department Name: " + dept.getDepartmentName() + "\n";
	    		
	        return out;
	                
	    }
		

}
