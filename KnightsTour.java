public class KnightsTour {

	//list of the possible moves for a knight
	private static final int[] rowMoves = new int[] {2, 1, -1, -2, -2, -1, 1, 2};
	private static final int[] colMoves = new int[] {1, 2, 2, 1, -1, -2, -2, -1};

	private static final int maxMoves = 64; //max number of moves possible

	public static void main(String[] args) {

		int[][] chessBoard = new int[8][8];
		populate(chessBoard);

		if(knightMoves(chessBoard, 0, 0, 1)) {
			printBoard(chessBoard);
		}
		else {
			System.out.println("No solution");
		}

	}

	//knights tour
	public static boolean knightMoves(int[][] board, int sRow, int sColumn, int k) {
		//board = chess board
		//sRow = starting row; sColumn = starting column; k = move counter
		int rowNext, colNext;

		if(k == maxMoves) {//if the move you're on is equal to the max number of moves: base case
			return true;
		}

		for(int i = 0; i < 8; i++) {
			rowNext = sRow + rowMoves[i];
			colNext = sColumn + colMoves[i];

			if(isSafe(board, rowNext, colNext) && board[rowNext][colNext] == 0) {
				board[rowNext][colNext] = k;
				if(knightMoves(board, rowNext, colNext, k+1)) {
					return true;
				}
				else {
					board[rowNext][colNext] = 0; 
				}
			}
		}
		return false;
	}

	//returns true if the next move is valid 
	public static boolean isSafe(int[][] board, int r, int c) {
		//0 <= r <= board.length, 0 <= c <= board.length, 
		if (r < 0 || r >= rowMoves.length || c < 0 || c >= colMoves.length) {
			return false;
		}
		return true;
	}

	public static void populate(int[][] board) {
		//populate the array
		for(int row = 0; row < 8; row++) {
			for(int column = 0; column < 8; column++) {
				board[row][column] = 0;
			}
		}
	}

	//prints a 2-D array of the spots the knight takes to complete its tour
	public static void printBoard(int[][] board){

		for(int row = 0; row < 8; row++) {
			for(int column = 0; column < 8; column++) {
				System.out.print(board[row][column]+" ");
			}
			System.out.println();
		}
	}

}
