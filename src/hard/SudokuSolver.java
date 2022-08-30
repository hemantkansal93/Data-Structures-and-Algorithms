package hard;

public class SudokuSolver {

	public static void main(String[] args) {
		char[][] board = {{'5','3','.','.','7','.','.','.','.'},
			{'6','.','.','1','9','5','.','.','.'},
			{'.','9','8','.','.','.','.','6','.'},
			{'8','.','.','.','6','.','.','.','3'},
			{'4','.','.','8','.','3','.','.','1'},
			{'7','.','.','.','2','.','.','.','6'},
			{'.','6','.','.','.','.','2','8','.'},
			{'.','.','.','4','1','9','.','.','5'},
			{'.','.','.','.','8','.','.','7','9'}};
		
		helper(board,0, 0);
		
		for( int i = 0 ; i < board.length; i++) {
			System.out.print("[");
			for( int j = 0 ; j < board[i].length; j++) {
				System.out.print(board[i][j]);
				if(j != board[i].length-1) {
					System.out.print(", ");
				}
			}
			System.out.println("]");
		}

	}

	private static boolean helper(char[][] board, int row, int col) {
		if(row == board.length) {
			return true;
		}
		
		int nrow = 0;
		int ncol = 0 ;
		
		if(col == board[0].length-1) {
			ncol = 0;
			nrow = row +1;
		}
		else {
			ncol = col+1;
			nrow = row;
		}
		
		if(board[row][col] != '.') {
			if(helper(board, nrow, ncol))
				return true;
		}
		else {
			for( int number =1; number <=9 ; number++) {
				if(valid(board, row, col, number)) {
					board[row][col] = (char)(number+'0');
					if(helper(board, nrow, ncol)) {
						return true;
					} 
					else {
						board[row][col] = '.';
					}
				}
				
			}
		}
		return false;
	}

	private static boolean valid(char[][] board, int row, int col, int number) {
		for(int i = 0 ; i < board.length; i++) {
			if(board[i][col] == (char)(number+'0')) {
				return false;
			}
		}
		for(int i = 0 ; i < board[0].length; i++) {
			if(board[row][i] == (char)(number+'0')) {
				return false;
			}
		}
		
		int sr = (row/3)*3;
		int sc = (col/3)*3;
		for( int i = sr; i < sr+3; i++) {
			for( int j = sc ; j < sc+3; j++) {
				if(board[i][j] == (char)(number+'0')) {
					return false;
				}
			}
		}
		return true;
	}
}
