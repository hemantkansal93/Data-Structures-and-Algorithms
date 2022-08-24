package medium;

import java.util.LinkedList;
import java.util.Queue;

public class Rotting_Oranges {

	static class Ele {
		int x;
		int y;

		public Ele(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) {
		int[][] grid = { { 2, 1, 1 }, { 1, 1, 0 }, { 0, 1, 1 } };

		int time = rot(grid);
		if(time ==-1)
			System.out.println("All the oranges can not be rotten");
		else
			System.out.println("The total time taken to rot all the oranges is " + time);

	}

	private static int rot(int[][] grid) {
		int rows = grid.length;
		int cols = grid[0].length;
		int count = 0;
		Queue<Ele> q = new LinkedList<>();
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (grid[i][j] == 2) {
					q.add(new Ele(i, j));
				}
			}
		}
		q.add(new Ele(-1, -1));

		while (!q.isEmpty()) {
			boolean flag = false;
			while (!isDelimiter(q.peek())) {
				Ele rotten = q.peek();

				int[] directions = { -1, 0, 1, 0, -1 };
				for (int i = 0; i < 4; i++) {
					int r = rotten.x + directions[i];
					int c = rotten.y + directions[i + 1];
					if (r >= 0 && r < grid.length && c >= 0 && c < grid[0].length && grid[r][c] == 1) {
						grid[r][c] = 2;
						q.add(new Ele(r, c));
						if (!flag) {
							flag = true;
							count++;
						}
					}
				}
				q.remove();
			}
			q.remove();
			if (!q.isEmpty()) {
				q.add(new Ele(-1, -1));
			}
		}
		return allRotten(grid) ? count : -1;

	}

	private static boolean isDelimiter(Ele e) {
		if (e.x == -1 && e.y == -1)
			return true;
		return false;
	}

	private static boolean allRotten(int[][] grid) {
		int rows = grid.length;
		int cols = grid[0].length;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (grid[i][j] == 1) {
					return false;
				}
			}
		}
		return true;
	}
}
