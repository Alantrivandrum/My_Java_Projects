import java.util.ArrayList;
import java.util.Date;

public class Employee {
	private final int employeeId;
	private String name;
	private Date promotionDate;
	private int role;
	private ArrayList<EmployeeAppraisal> appraisalHistory;
	
	public Employee(int employeeId, String name, int role) {
		this.employeeId = employeeId;
		this.name = name;
		this.promotionDate = null;
		this.role = role;
		this.appraisalHistory = new ArrayList<EmployeeAppraisal>();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getPromotionDate() {
		return promotionDate;
	}
	public void setPromotionDate(Date promotionDate) {
		this.promotionDate = promotionDate;
	}
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
	public ArrayList<EmployeeAppraisal> getAppraisalHistory() {
		return appraisalHistory;
	}
	public void setAppraisalHistory(ArrayList<EmployeeAppraisal> appraisalHistory) {
		this.appraisalHistory = appraisalHistory;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", name=" + name + ", promotionDate=" 
				+ promotionDate + ", role=" + role + ", appraisalHistory=" + appraisalHistory + "]";
	}
	
	
	
}
