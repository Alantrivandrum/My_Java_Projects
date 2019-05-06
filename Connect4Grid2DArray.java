public class Connect4Grid2DArray implements Connect4Grid {

	public void emptyGrid() {
		
		char columnNumber = '1';
		for (int column = 0; column < TABLE_COLUMNS; column++) {
			if (column % 2 == 0)
				grid[0][column] = ' ';
			else
				grid[0][column] = columnNumber++;
		}

		for (int row = 1; row < TABLE_ROWS - 1; row++)
			for (int column = 0; column < TABLE_COLUMNS; column += 2)
				grid[row][column] = '|';

		for (int column = 0; column < TABLE_COLUMNS; column++)
			grid[TABLE_ROWS - 1][column] = '-';
		
		for (int row = 1; row < TABLE_ROWS - 1; row++)
			for (int column = 0; column < TABLE_COLUMNS; column++)
				if (grid[row][column] != '-' && grid[row][column] != '|')
					grid[row][column] = ' ';
	}

	public boolean isValidColumn(int column) {
		if (column > 0 && column < 8) {
			if (!isColumnFull(column))
				return true;
		}
		return false;
	}

	public boolean isColumnFull(int column) {
		int columnIndex = (column * 2) - 1;
		if (grid[1][columnIndex] == 'O' || grid[1][columnIndex] == 'X') {
			return true;
		}
		return false;
	}

	public void dropPiece(ConnectPlayer player, int column) {
		boolean inserted = false;
		if (isValidColumn(column)) {
			int columnIndex = (column * 2) - 1;
			for (int row = 1; row < TABLE_ROWS && !inserted; row++) {
				if (grid[row][columnIndex] == 'O' || grid[row][columnIndex] == 'X' || row == (TABLE_ROWS - 1)) {
					row--;
					grid[row][columnIndex] = player.playerDisc;
					inserted = true;
				}
			}
		} else {
			System.out.println("Invalid Column");
		}
	}

	public boolean didLastPieceConnect4() {
		for (int row = 1; row < TABLE_ROWS - 1; row++)
			for (int column = 7; column < TABLE_COLUMNS - 1; column += 2)
				if (grid[row][column] != ' ' && grid[row][column] == grid[row][column - 2] && grid[row][column] == grid[row][column - 4]
						&& grid[row][column] == grid[row][column - 6])
					return true;

		for (int column = 1; column < TABLE_COLUMNS - 1; column += 2)
			for (int row = 4; row < TABLE_ROWS - 1; row++)
				if (grid[row][column] != ' ' && grid[row][column] == grid[row - 1][column] && grid[row][column] == grid[row - 2][column]
						&& grid[row][column] == grid[row - 3][column]) 
					return true;
				
		for (int row = 4; row < TABLE_ROWS - 1; row++) 
			for (int column = 7; column < TABLE_COLUMNS - 1; column += 2) 
				if (grid[row][column] != ' ' && grid[row][column] == grid[row - 1][column - 2] && grid[row][column] == grid[row - 2][column - 4]
						&& grid[row][column] == grid[row - 3][column - 6]) 
					return true;
		
		for (int row = TABLE_ROWS - 1; row - 3 > 0; row--)
			for (int column = 1; column + 6 < TABLE_COLUMNS - 1; column += 2)
				if (grid[row][column] != ' ' && grid[row][column] == grid[row - 1][column + 2] && grid[row][column] == grid[row - 2][column + 4]
						&& grid[row][column] == grid[row - 3][column + 6])
					return true;
		
		return false;
	}

	public boolean isGridFull() {
		boolean gridFull = true;
		for (int columnIndex = 1; columnIndex < TABLE_COLUMNS - 1; columnIndex += 2) {
			if (grid[1][columnIndex] == ' ') {
				gridFull = false;
			}
		}
		return gridFull;
	}

	public void printGrid() {
		for (int row = 0; row < TABLE_ROWS; row++) {
			for (int column = 0; column < TABLE_COLUMNS; column++) {
				System.out.print(grid[row][column]);
			}
			System.out.println();
		}
	}

}