public interface Connect4Grid {
	public static final int TABLE_ROWS = 8;
	public static final int TABLE_COLUMNS = 15;
	public static final char PLAYER_X = 'X';
	public static final char PLAYER_O = 'O';
	public char[][] grid = new char[TABLE_ROWS][TABLE_COLUMNS];
	
	public void emptyGrid();
	public String toString();
	public boolean isValidColumn(int column);
	public boolean isColumnFull(int column);
	public void dropPiece(ConnectPlayer player, int column);
	public boolean didLastPieceConnect4();
	public boolean isGridFull(); 
	public void printGrid();
}