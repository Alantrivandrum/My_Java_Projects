import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class HRClient {
	
	public static int employeeId = 110000; 

	public static void main(String[] args) {
		boolean exit = false;
		HRDepartment hrDepartment = new HRDepartment();
		Scanner scanner = new Scanner(System.in);
		while (!exit) {
			System.out.println("Please enter 1 to add an employee, 2 to view all employees, \n"
					+ "3 to record an employee appraisal, 4 to promote an employee and 5 to exit");
			if (scanner.hasNextInt()) {
				int userInput = scanner.nextInt();
				switch (userInput) {
				case 1: {
					System.out.println("Separated by spaces, please enter the employee's first name followed by his/her role code \n"
							+ "(1 for Executive, 2 for manager, 3 for team lead, 4 for designer, 5 for developer and 6 for tester)");
					if (scanner.hasNext()) {
						String employeeName = scanner.next();
						if (scanner.hasNextInt()) {
							int role = scanner.nextInt();
							if (role >= HRCodes.EXECUTIVE && role <= HRCodes.TESTER){
								hrDepartment.addEmployee(employeeId++, employeeName, role);
							} else {
								System.out.println("Role code must be between " + HRCodes.EXECUTIVE + " and " + HRCodes.TESTER);
							}
						}
					}
					
					break;
				}
				case 2: {
					hrDepartment.printAllEmployees();
					break;
				}
				case 3: {
					System.out.println("Separated by spaces please enter the employeeId \nfollowed by "
							+ "appraisal score code (1 for 'exceeded expectations', "
							+ "2 for 'met expectations' and 3 for 'did not meet expectations') \n"
							+ "followed by the appraisal date in the following format 'dd-mm-yyyy')");
					if (scanner.hasNextInt()) {
						int employeeId = scanner.nextInt();	
						if (scanner.hasNextInt()) {
							int score = scanner.nextInt();
							if (score >= HRCodes.EXCEEDED_EXPECTATIONS && score <= HRCodes.DID_NOT_MEET_EXPECTATIONS) {
								if (scanner.hasNext()) {
									String date = scanner.next();
									SimpleDateFormat formatter = new SimpleDateFormat("dd-mm-yyyy");
									Date appraisalDate = null;
									try {
										appraisalDate = formatter.parse(date);
									} catch (ParseException e) {
										System.out.println("Invalid date entered");
										e.printStackTrace();
									}
									if (!hrDepartment.recordEmployeeAppraisal(employeeId, appraisalDate, score)) {
										System.out.println("Appraisal could not be recorded. Please check the employee id enetered");
									}
								}
							} else {
								System.out.println("Invalid score entered");
							}
						}
					}
					break;
				}
				case 4: {
					System.out.println("Please enter the Id (integer) of the employee to promote");
					if (scanner.hasNextInt()) {
						int employeeId = scanner.nextInt();
						if (hrDepartment.promoteEmployee(employeeId)) {
							System.out.println("Employee has been promoted");
						} else {
							System.out.println("Employee is not eligible for promotion or employee id is incorrect");
						}
					}
					break;
				}
				case 5: {
					exit = true;
					break;
				}
				}

			}
		}
		scanner.close();
		
	}
	
}
