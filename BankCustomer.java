import java.util.Scanner;
public class BankCustomer {
	private static int accountNumber;
	private static String customerName;
	private static String customerAddress;
	private static int customerDateOfBirth;
	private static Scanner input = new Scanner(System.in);
	
	
	public static int getAccountNumber(int numberForAccount)
	{
		return accountNumber;
	}
	public  String getCustomerName(String name)
	{
		
		return customerName;
	}
	public String getCustomerAddress(String address)
	{
		return customerAddress;
	}
	public  int getcustomerDateOfBirth(int date)
	{
		return customerDateOfBirth;
	}
	
	public  void setAccountNumber(int numberForAccount)
	{
		accountNumber = numberForAccount;
	}
	public  void setCustomerName(String name)
	{
		customerName = name;
	}
	public  void setCustomerAddress(String address)
	{
		customerAddress = address;
	}
	public  void setcustomerDateOfBirth(int date)
	{
		customerDateOfBirth = date;
	}
	
	public static void main(String[] args)
	{
     
	}

}
