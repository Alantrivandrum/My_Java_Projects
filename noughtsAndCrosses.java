package noughtsAndCrosses;
import java.util.Scanner;
public class noughtsAndCrosses {
	static char[][] board = new char[3][3];
	static char[] firstRow = new char[3];
	static char[] secondRow = new char[3];
	static char[] thirdRow = new char[3];
	static char[] firstColumn = new char[3];
	static char[] secondColumn = new char[3];
	static char[] thirdColumn = new char[3];
	public static int row;
	public static int column;
	public static boolean isBoardFull;
	public static boolean canMakeMove ;
	public static char winner;


	public static void main(String[] args)
	{
	
		clearBoard(board);
		printBoard(board);


	}


	public static void clearBoard(char [][] board)
	{
		for (int row = 0; row < 3; row++) 
		{
			for (int col = 0; col < 3; col++) 
			{
				board [row][col] = ' ';
			}

		}



	}
	public static void printBoard(char[][] board)
	{
		System.out.println("       0               1                2   ");
		System.out.println("0    " + board[0][0] + "        |       " + board[0][1] + "         |        "
				+ board[0][2]);
		System.out.println(" ---------------------------------------------");
		System.out.println("1    " + board[1][0] + "        |      " + board[1][1] + "          |        "
				+ board[1][2]);
		System.out.println(" ---------------------------------------------");
		System.out.println("2    " + board[2][0] + "        |       " + board[2][1] + "         |        " 
				+ board[2][2]);



	}
	public static boolean canMakeMove(char[][] board, int row , int column)
	{
       if(board [row][column] == ' ' )
       {
    	   canMakeMove = true;
       }
       else
       {
    	   canMakeMove = false;
       }


		return canMakeMove;
	}

	public static void makeMove(char[][] board, char currentPlayerPiece,int row,int column)
	{
		int n =0;
       Scanner input = new Scanner(System.in);
       row = input.nextInt();
       column = input.nextInt();
       if(n % 2 ==0)
       {
    	  board[row][column] = 'X';
       }
       else
       {
    	   board[row][column] = 'O';
       }
       input.close();




	}
	public static boolean isBoardFull(char [][] board)
	{
		char[][] boardCloned = new char[3][3];
		boardCloned[0][1] = 'X';
		boardCloned[0][2] = 'O';
		boardCloned[0][0] = 'X';
		boardCloned[1][0] = 'O';
		boardCloned[1][1] = 'X';
		boardCloned[1][2] = 'O';
		boardCloned[2][0] = 'X';
		boardCloned[2][1] = 'X';
		boardCloned[2][2] = 'O';
		
		
		
		
           if(board.equals(boardCloned))
           {
        	   isBoardFull = true;
           }
           else
           {
        	   isBoardFull = false;
           }

		return isBoardFull;
	}

	public static char winner(char[][] board)
	{
		


		return winner;
	}




}
