package medium;

import java.util.ArrayList;
import java.util.List;

public class Rat_in_Maze {
	static List<int[][]> solutions = new ArrayList<>();

	public static void main(String[] args) {
		int[][] maze = { { 1, 0, 0, 0 }, { 1, 1, 0, 1 }, { 1, 1, 0, 0 }, { 1, 1, 1, 1 } };
		int m = maze[0].length;
		int n = maze.length;

		int[][] sol = new int[n][m];
		getPossibleSolutions(maze, sol, 0, 0);

		for (int i = 0; i < solutions.size(); i++) {
			int[][] solution = solutions.get(i);
			for (int j = 0; j < solution.length; j++) {
				for (int k = 0; k < solution[i].length; k++) {
					System.out.print(solution[j][k] + ", ");
				}
				System.out.println();
			}
			System.out.println();
			System.out.println();
		}
	}

	private static boolean getPossibleSolutions(int[][] maze, int[][] solution, int x, int y) {

//		System.out.println();
		int m = maze[0].length;
		int n = maze.length;

		if (x == m - 1 && y == n - 1) {
			solution[x][y] = 1;
			solutions.add(solution);
			return true;
		}
		if (isValid(maze, x, y)) {
			solution[x][y] = 1;
			if(getPossibleSolutions(maze, solution, x+1, y))
				return true;
			if(getPossibleSolutions(maze, solution, x, y+1))
				return true;
			solution[x][y] = 0;
			return false;
		}
		return false;
	}

	private static boolean isValid(int[][] maze, int x, int y) {
		if (x < maze[0].length && y < maze.length && maze[x][y] == 1)
			return true;
		return false;
	}

}
