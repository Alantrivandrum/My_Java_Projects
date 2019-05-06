/* SELF ASSESSMENT
Harness Class: Member variables (8 marks) 8
All my data members are declared. I also have a constant for the maximum number of uses of a harness.
Comment: Yes, all the data members are declared and they are accessed using Getters ad Setters. I used MAX_USE for the maximum number of uses of a harness
Harness Class: Harness constructor 1 & constructor 2 (6 marks) 6
I initialise all the variables using the parameters given and set the other members to reasonable default values.
Comment: The proper constructors have been made.
Harness Class: checkHarness method (5 marks) 5
My method takes an instructor's name as a parameter, and if the harness is not on loan sets the instructor member variable to the given parameter value (assuming the instructor's name is not null/empty). It also resets the number of times the harness was used.
Comment: Yes,it does this
Harness Class: isHarnessOnLoan method (2 marks)
My method has no parameters and returns the value of the loan status variable.
Comment: Yes, the method doesn't take any parameter and returns loan
Harness Class: canHarnessBeLoaned method (4 marks)
My method has no parameters and returns true if the harness is not on loan and if the number of times it was used is less than the maximum allowed number of times.
Comment: Yes, the method has no parameters an does this
Harness Class: loanHarness method (6 marks)
My method has a member name as a parameter and it checks if harness can be loaned by using the canHarnessBeLoaned method. If true, it sets the club member value to the parameter value, sets the on loan status to true and increments the number of times used variable.
Comment: Yes.
 
Harness Class: returnHarness method (5 marks)
My method has no parameters, checks if the harness is on loan, and if so, changes its on-loan status to false, and resets the club member value.
Comment: Yes, the method doesn't have any parameter and if the boolean loan is true, the method sets it to false and the String variable borrower to null
Harness Class: toString method (3 marks)
My method returns a String representation of all the member variables.
Comment: Yes, this method is present.
HarnessRecords Class: member variables (3 marks)
I declare the member variable as a private collection of Harnesses 
Comment: Yes, the collection of Harnesses is declared as private
HarnessRecords Class: HarnessRecords constructor 1 & 2 (9 marks)
In the first constructor, I set the member variable to null [1 mark]. In the second constructor, I use the Java I/O to read data from a text file I created containing sets of Harness characteristics. I use these set of characteristics to create Harness objects and add them to the collection. 
Comment: Yes, both the constructors have been created with the required conditions
HarnessRecords Class: isEmpty method (1 marks)
I return true if the collection is null/empty and, false otherwise.
Comment: The method returns true if the size of the collection is 0, and false otherwise
HarnessRecords Class: addHarness method (5 marks)
My method takes a Harness object as a parameter and adds the harness to the collection.
Comment: Yes, the method takes a Harness objects parameter.
HarnessRecords Class: findHarness method (6 marks)
My method takes a make and model number as parameters. It checks if a harness with such properties exists and if it does it returns harness object, otherwise returns null.
Comment: Yes, it takes the made and model number as parameters and checks for a harness with these properties and returns it. if not found it returns null
HarnessRecords Class: checkHarness method (6 marks)
must take instructor name, make and model number as parameters and return a Harness. If a harness with the make and model number exists by using the findHarness method and is not on loan, the Harness method checkHarness is called with the instructor name as a parameter and the updated Harness object is returned. If the harness is not available returns null.
Comment: Instructor name, make and model number have been passed as parameters. The required harness is found using findHarness. The harness is checked if it is not null and if it is available for loan or not using isHarnessOnLoan(). Finally, checkHarness is called with the instructor name as parameter and the Harness object is returned
HarnessRecords Class: loanHarness method (7 marks)
My method takes a club member name as a parameter and looks for an available harness by calling the method canHarnessBeLoaned be loaned. If an available harness is found it is loaned by using the Harness method loanHarness with the club member as a parameter, returning the harness. If there's no available harness null is returned.
Comment: 
HarnessRecords Class: returnHarness method (7 marks)
My method takes a make and model number as parameters. It checks if a harness with those properties exists by using the findHarness method. If the found harness is not null, it returns the harness object by using Harness method returnHarness, otherwise returns null.
Comment: Yes, the method has make and model number as parameter and does this also
HarnessRecords Class: removeHarness method (8 marks)
My method takes a make and model number as parameters and check the collection for a harness with those properties and removes it. It returns the harness object if it is found, otherwise returns null.
Comment: Yes, the method takes the make and model number as parameters, finds the required harness with the method findHarness. If found, it removes it and returns the harness object, and otherwise returns null.
GUI (Java main line) (5 marks)
My test class has a menu which implements at least the five points specified using the HarnessRecords class methods.
Comment: Yes, the main has a menu using the switch statement with the  5 options that were required in the question
*/

import java.util.Scanner;

public class ClimbingClubHarnessRecordSystem {
	
	public static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
	HarnessRecords records = new HarnessRecords("src\\AllTheHarnessRecords.txt"); //put path here 
	boolean finished = false;
	while(!finished){
	System.out.println("Enter choice(1-5)");
	System.out.println("(1)- Add a record for a newly purchased harness");
	System.out.println("(2)- remove a climbing harness from the club");
	System.out.println("(3)- record the fact that a club instructor has checked the safety of a harness");
	System.out.println("(4)- loan a harness to a club member if there is an availabe harness");
	System.out.println("(5)- return a harness which is no longer in use by a club member.");
	System.out.println("(6)-Find a specific harness");
	System.out.println("(7)- Check if the Arraylist is empty or not");
	
	String choice;
	if(input.hasNext("exit")){
	finished = true;
	}else if(input.hasNext()){
	choice = input.next();
	switch (choice){
	case "1":
	System.out.print("Enter make: ");
	String make = input.next();
	System.out.print("Enter model number: ");
	int model = input.nextInt();
	System.out.print("Enter number Of times already used: ");
	int numberOfTimesUsed = input.nextInt();
	System.out.print("Enter name of the instructor who checked it: ");
	String name = input.next();
	Harness harness = new Harness(make, model, numberOfTimesUsed, name, false, null);;
	records.addHarness(harness);
	break;
	
	case "2":
	System.out.print("Enter make: ");
	make = input.next();
	System.out.print("Enter model number: ");
	model = input.nextInt();
	records.removeHarness(make, model);
	break;
	
	case "3":
	System.out.print("Enter make: ");
	make = input.next();
	System.out.print("Enter model number: ");
	model = input.nextInt();
	System.out.print("Enter name: ");
	name = input.next();
	records.checkHarness(name, make, model);
	break;
	
	case "4":
	System.out.println("Enter member name: ");
	name = input.next();
	if(records.loanHarness(name)==null)
	System.out.println("No harnessess to loan");;
	break;
	case "5":
	System.out.print("Enter make: ");
	make = input.next();
	System.out.print("Enter model number: ");
	model = input.nextInt();
	records.returnHarness(make, model);
	break;
	case "6":
	System.out.print("Enter make: ");
	make = input.next();
	System.out.print("Enter model number: ");
	model = input.nextInt();
	System.out.println(records.findHarness(make, model));
	break;
	case "7":
	if(records.isEmpty())
	System.out.println("The Arraylist is empty");
	else
	System.out.println("The Arraylist is not empty");
	break;
	default: System.out.println("Invalid Input");
	}
	}else{
	System.out.println("Invalid input");
	
	}
	}
	input.close();
	}
}