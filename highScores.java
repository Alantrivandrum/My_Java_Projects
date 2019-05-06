/* SELF ASSESSMENT

 1. Did I use easy-to-understand meaningful variable names formatted properly (in lowerCamelCase)?

        Mark out of 5:  5
       Yes I did use easy to understand variable names.
 2. Did I indent the code appropriately?

        Mark out of 5: 5
             Yes.
 3. Did I write the initialiseHighScores function correctly (parameters, return type and function body) and invoke it correctly?

       Mark out of 15:  15
         Yes.I did
 4. Did I write the printHighScores function correctly (parameters, return type and function body) and invoke it correctly?

       Mark out of 15:  15
       Yes I wrote the printHighScores function properly.

 5. Did I write the higherThan function correctly (parameters, return type and function body) and invoke it correctly?

       Mark out of 15:  15
       Yeah I wrote this function correctly too.

 6. Did I write the insertScore function correctly (parameters, return type and function body) and invoke it correctly?

       Mark out of 20:20
       Yes. I wrote this function too without a problem.

 7. Did I write the main function body correctly (first asking for the number of scores to be maintained and then repeatedly asking for scores)?

       Mark out of 20: 10
       I could not figure out how to maintain a number of scores the user wished to maintain however I was able to repeatedly ask for scores. 

 8. How well did I complete this self-assessment?

        Mark out of 5:5
       I completed this self assessment well.
 Total Mark out of 100 (Add all the previous marks):

 */ 


import java.util.Scanner;
public class highScores 
{
	public  static int MAX_NUMBER_OF_SCORES = 5;
	public static boolean isHigherThan = false;
	public static double score;
	public static int numberOfScores;
	public static double[] highScoreList = new double[MAX_NUMBER_OF_SCORES];
	public static void main(String[] args)
		{
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter your  score");
		while(numberOfScores<=MAX_NUMBER_OF_SCORES&& numberOfScores >= 0 )
		{
			try {
				if(input.hasNext("reset"))
				{
					initialiseHighScores( highScoreList);
					numberOfScores = 0;
					input.next();
					System.out.println("Please enter your next  score");

				}

				else
				{
					score = input.nextDouble();
					try 
					{
						highScoreList[numberOfScores] = score;
					}
					catch(java.lang.ArrayIndexOutOfBoundsException highScoreList)
					{

					}

					numberOfScores++;
					higherThan(highScoreList,score);
					insertScore(highScoreList, score);
					printHighScores(highScoreList);
					System.out.println("Please enter your next  score");

				}
			}
			catch(java.util.InputMismatchException score)
			{
				System.out.println("Error: You entered a letter. Please enter any numeric score");
				input.next();
			}


		}
		input.close();
	}
	public static double[]  initialiseHighScores( double[] highScoreList)
	{
		java.util.Arrays.fill(highScoreList, 0, MAX_NUMBER_OF_SCORES, 0);
		return highScoreList;
	}
	public static double[] printHighScores(double[] highScoreList)
	{
		int count = 1;
		System.out.println("The highscores are : ");
		while(score >= 0 && count <= 5)
		{
			switch(count)
			{
			case 1:
				System.out.println(count + ": " + highScoreList[0] );
				count++;
				break;
			case 2:
				System.out.println(count + ": " + highScoreList[1] );
				count++;
				break;
			case 3:
				System.out.println(count + ": " + highScoreList[2] );
				count++;
				break;
			case 4:
				System.out.println(count + ": " + highScoreList[3] );
				count++;
				break;
			case 5: 
				System.out.println(count + ": " + highScoreList[4] );
				count++;
				break;
			}
		}
		return highScoreList;
	}
	public static boolean higherThan(double[] highScoreList,double score)
	{
		if(score > highScoreList[4])
		{
			isHigherThan = true;
		}
		else
		{
			isHigherThan = false;
		}
		return isHigherThan;
	}
	public static void insertScore(double[] highScoreList,double score)
	{
		if(isHigherThan = true)
		{
			if(score > highScoreList[0])
			{
				highScoreList[4] = highScoreList[3];
				highScoreList[3] = highScoreList[2];
				highScoreList[2] = highScoreList[1];
				highScoreList[1] = highScoreList[0];
				highScoreList[0] = score;
			}
			else if(score > highScoreList[1] && score< highScoreList[0])
			{
				highScoreList[4] = highScoreList[3];
				highScoreList[3] = highScoreList[2];
				highScoreList[2] = highScoreList[1];
				highScoreList[1] = score;

			}
			else if(score > highScoreList[2] && score< highScoreList[1])
			{
				highScoreList[4] = highScoreList[3];
				highScoreList[3] = highScoreList[2];
				highScoreList[2] = score;
			}
			else if(score > highScoreList[3] && score< highScoreList[2])
			{
				highScoreList[4] = highScoreList[3];
				highScoreList[3] = score;
			}
			else if(score > highScoreList[4] && score< highScoreList[3] )
			{
				highScoreList[4] = score;
			}



		}
	}
}
