import java.util.Scanner;
public class Revision {
	public static int friend = 0;
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		while(friend <= 100)
		{
			if(input.hasNext("exit"))
			{
				System.out.print("Goodbye");
				break;
			}
			System.out.println("You have no friends!");
			friend = input.nextInt();
			if(friend > 100)
			{
			 System.out.println("You have some friends");
			}
			
		}
		input.close();
		
		
	}

}
