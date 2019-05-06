package etest2;
import java.util.Scanner;
public class secondEtest {
	public static int[] frequencies = new int[10000];
	public static int count;
	public static int secondCount;
	public static int countOfNumberOne;
	public static int countOfNumberTwo;
	public static int countOfNumberThree;
	public static int countOfNumberFour;
	public static int countOfNumberFive;
	public static int countOfNumberSix;
	public static int countOfNumberSeven;
	public static int countOfNumberEight;
	public static int countOfNumberNine;
	public static int number;
	public static Scanner input = new Scanner(System.in);
	public static void main(String[] args)
	{
		number = input.nextInt();
		while(count < 10 &&  number!= 1)
		{

			countDigitFrequencies(number,frequencies);
			count++;
		}
		System.out.println(java.util.Arrays.toString(frequencies));
	}
	public static void countDigitFrequencies(int number, int[] frequencies)
	{






		if(number < Integer.MAX_VALUE && number >= 0 && number != 1)
		{
			frequencies[secondCount]  = number%10;
			number= number/10;
			secondCount++;


		}
	    



	}
	public static void printDigitFrequencies(int[] frequencies)
	{
		java.util.Arrays.sort(frequencies);
		secondCount = 0;
		if(frequencies[secondCount] == 1)
		{
			countOfNumberOne++;
		}
		else if(frequencies[secondCount] == 2)
		{
			countOfNumberTwo++;
		}
		else if(frequencies[secondCount] == 3)
		{
			countOfNumberThree++;
		}
		else if(frequencies[secondCount] == 4)
		{
			countOfNumberFour++;
		}
		else if(frequencies[secondCount] == 5)
		{
			countOfNumberFive++;
		}
		else if(frequencies[secondCount] == 6)
		{
			countOfNumberSix++;
		}
		else if(frequencies[secondCount] == 7)
		{
			countOfNumberSeven++;
		}
		else if(frequencies[secondCount] == 8)
		{
			countOfNumberEight++;
		}
		else if(frequencies[secondCount] == 9)
		{
			countOfNumberNine++;
		}
		secondCount++;
	}
}
