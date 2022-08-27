package medium;

import java.util.ArrayList;
import java.util.List;

public class N_Queen {

	public static void main(String[] args) {
		int n = 4;
		
		List<List<String>> allSol = nQueen(n);
		for (int i = 0; i < allSol.size(); i++) {
			List<String> solution = allSol.get(i);
			for (int j = 0; j < solution.size(); j++) {
				for (int k = 0; k < solution.get(j).length(); k++) {
					System.out.print(solution.get(j).charAt(k) + "\t");
				}
				System.out.println();
			}
			System.out.println();
			System.out.println();
		}

	}

	private static List<List<String>> nQueen(int n) {
		char[][] board = new char[n][n];
		List<List<String>> result = new ArrayList<>();
		getComb(board, result, 0);
		return result;
	}

	private static void getComb(char[][] board, List<List<String>> result, int col) {
		int rows = board.length;
		int cols = board[0].length;
		if(col == cols) {
			List<String> sol = saveComb(board);
			result.add(sol);
			return;
		}
		
		for( int i = 0; i< rows; i++) {
			if(safe(board, i, col)) {
				board[i][col] = 'Q';
				getComb(board, result, col+1);
				board[i][col] = '.';
			}
		}
		
	}

	private static boolean safe(char[][] board, int x, int y) {
		int rows = board.length;
		int cols = board[0].length;
		
		for( int row = 0; row < rows; row++) {
			if(board[row][y] == 'Q')
				return false;
		}
		for( int col = 0; col < cols; col++) {
			if(board[x][col] == 'Q')
				return false;
		}
		int row = x;
		for( int col = y; row >=0 && col>=0; row--,col--) {
			if(board[row][col] == 'Q')
				return false;
		}
		row = x;
		for( int col = y; row >=0 && col<cols; row--,col++) {
			if(board[row][col] == 'Q')
				return false;
		}
		row = x;
		for( int col = y; row <rows && col>=0; row++,col--) {
			if(board[row][col] == 'Q')
				return false;
		}
		row = x;
		for( int col = y; row <rows && col<cols; row++, col++) {
			if(board[row][col] == 'Q')
				return false;
		}
		return true;
	}

	private static List<String> saveComb(char[][] board) {
		int rows = board.length;
		int cols = board[0].length;
		List<String> solution = new ArrayList<>();
		for( int i = 0 ; i < rows; i++) {
			String row = "";
			for(int j = 0; j < cols; j++) {
				if(board[i][j] == 'Q')
					row += 'Q';
				else
					row += '.';
			}
			solution.add(row);
		}
		return solution;
	}
}
