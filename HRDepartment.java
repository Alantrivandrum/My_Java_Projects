import java.util.*;
public class HRDepartment {
	ArrayList<Employee> employeeList = new ArrayList<Employee>();
	
	public void addEmployee(int employeeId,String name,int role) 
	{
		Employee myEmployee = new Employee(employeeId,name,role);
		employeeList.add(myEmployee);
	}
	
	public void printAllEmployees() 
	{
		for(int i=0;i<= employeeList.size();i++) 
		{
			Employee myEmployee = employeeList.get(i);
			System.out.println("ID :" + myEmployee.getEmployeeId()  );
			System.out.println("Name :" + myEmployee.getName());
			System.out.println("PromotionDate :" + myEmployee.getPromotionDate());
			System.out.println("Role :" + myEmployee.getRole());
			System.out.println("AppraisalHistory :" + myEmployee.getAppraisalHistory());
			
		}
	}
	
	public Employee findEmployee(int employeeId)
	{
		int employeeID = 0;
		String name = "employeeNotFound";
		int role = 0;
		Employee correctEmployee = new Employee(employeeID,name,role);
		for(int i=0;i<= employeeList.size();i++) 
		{
			Employee myEmployee = employeeList.get(i);
			if(myEmployee.getEmployeeId() == employeeId)
			{
				correctEmployee = myEmployee;
			}

		}
		return correctEmployee;


	}
	
	public boolean recordEmployeeAppraisal(int employeeId,Date appraisalDate,int score)
	{
		boolean correctEmployee;
		Employee myEmployee =findEmployee(employeeId);
		if(myEmployee.getEmployeeId() != 0)
		{
			EmployeeAppraisal myAppraisal = new EmployeeAppraisal(appraisalDate,score);
			myEmployee.getAppraisalHistory().add(myAppraisal);
			correctEmployee = true;
		}
		else
		{
			correctEmployee = false;
		}
		return correctEmployee;
	}
	
	/*public boolean promoteEmployee(int employeeId) 
	{
		findEmployee(employeeId);
	}
	*/

}
