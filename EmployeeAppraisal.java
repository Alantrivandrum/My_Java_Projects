import java.util.Date;

public class EmployeeAppraisal {
	private Date appraisalDate;
	private int appraisalScore;
	
	
	public EmployeeAppraisal(Date appraisalDate, int appraisalScore) {
		this.appraisalDate = appraisalDate;
		this.appraisalScore = appraisalScore;
		
	}
	
	public Date getAppraisalDate() {
		return appraisalDate;
	}
	public void setAppraisalDate(Date appraisalDate) {
		this.appraisalDate = appraisalDate;
	}
	public int getAppraisalScore() {
		return appraisalScore;
	}
	public void setAppraisalScore(int appraisalScore) {
		this.appraisalScore = appraisalScore;
	}
	
	@Override
	public String toString() {
		return "EmployeeAppraisal [appraisalDate=" + appraisalDate + ", appraisalScore=" + appraisalScore + "]";
	}
	
	

}
