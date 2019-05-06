
import java.util.Random;


public class Minesweeper {

	public static final int NUMBER_OF_ROWS = 6;
	public static final int NUMBER_OF_COLUMNS = 20;
	public static final int NUMBER_OF_MINES = 15;
	public static final char MINE = '*';
	public static final char NO_MINE = ' ';
	public static void main(String[] args) {
		char[][] board = new char[NUMBER_OF_ROWS][NUMBER_OF_COLUMNS];
		clearBoard(board);
		System.out.println("After clearing:");
		printBoard(board);
		layMines(board,NUMBER_OF_MINES);
		System.out.println("After laying mines:");
		printBoard(board);
		determineNumberOfMineNeighbours(board);
		System.out.println("After setting number of mine neighbours:");
		printBoard(board);
	}
	
	public static void clearBoard( char[][] board )
	{
		for (int row = 0; (row < board.length); row++)
			for (int column = 0; (column < board[row].length); column++)
				board[row][column] = NO_MINE;
	}
	
	public static void printBoard( char[][] board )
	{
		for (int row = -1; (row <= board.length); row++)
		{
			System.out.print("|");
			for (int column = 0; (column < board[0].length); column++)
				if ((row == -1) || (row == board.length))
					System.out.print("-");
				else System.out.print(board[row][column]);
			System.out.println("|");
		}
	}
		
	public static void layMines( char[][] board, int number_of_mines )
	{
	    Random randomNumberGenerator = new Random();
	    boolean mineLaid = false;
		for (int mine=0; (mine < number_of_mines); mine=mineLaid?mine+1:mine)
		{
			mineLaid = false;
			int mineRow = randomNumberGenerator.nextInt( board.length );
			int mineColumn = randomNumberGenerator.nextInt( board[mineRow].length );
			if (board[mineRow][mineColumn] == NO_MINE)
			{
				board[mineRow][mineColumn] = MINE;
				mineLaid = true;
			}
		}
	}

	public static void determineNumberOfMineNeighbours( char[][] board )
	{
		for (int row = 0; (row < board.length); row++)
			for (int column = 0; (column < board[row].length); column++)
				if (board[row][column] != MINE)
				{
					int numberOfMineNeighbours = numberOfNeighbouringMines( board, row, column );
					if (numberOfMineNeighbours > 0)
						board[row][column] = (char) (((int) '0') + numberOfMineNeighbours);
				}
	}
	
	public static int numberOfNeighbouringMines( char[][] board, int passedRow, int passedColumn )
	{
		int numberOfMines = 0;
		for (int row=(passedRow==0)?0:passedRow-1; row <= ((passedRow==board.length-1)?passedRow:passedRow+1); row++)
			for (int column=(passedColumn==0)?0:passedColumn-1; column <= ((passedColumn==board[row].length-1)?passedColumn:passedColumn+1); column++)
				if (((row != passedRow) || (column!= passedColumn)) && (board[row][column] == MINE))
					numberOfMines++;
		return numberOfMines;
	}

}