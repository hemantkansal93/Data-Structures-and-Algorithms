package medium;

public class MaximumAreaof_Island {

	public static void main(String[] args) {
		int[][] grid = {{0,0,1,0,0,0,0,1,0,0,0,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,1,1,0,1,0,0,0,0,0,0,0,0},{0,1,0,0,1,1,0,0,1,0,1,0,0},{0,1,0,0,1,1,0,0,1,1,1,0,0},{0,0,0,0,0,0,0,0,0,0,1,0,0},{0,0,0,0,0,0,0,1,1,1,1,0,0},{0,0,0,0,0,0,0,1,1,0,0,0,0}};
		
		int area = findAreaBiggestIsland(grid);
		
		System.out.println("The area of the biggest island in the given grid is : " + area);
		
	}

	private static int findAreaBiggestIsland(int[][] grid) {

		int maxArea = 0; 
		
		for( int i = 0 ; i < grid.length; i++) {
			for( int j = 0 ; j < grid[0].length; j++) {
				if(grid[i][j] == 1)
					maxArea = Math.max(maxArea, dfs(grid, i, j));
			}
		}
		return maxArea;
		
	}

//	USING RECURSION
	private static int dfs(int[][] grid, int sr, int sc) {
		int area = 1;
		
//		Marking block of grid as traversed (to avoid repetitions)
		grid[sr][sc] = 0;
		
		int[] directions = {-1, 0 , 1, 0, -1};
		
		for ( int i = 0 ; i < 4; i++) {
			int  r = sr + directions[i];
			int c = sc + directions[i+1];
			
			if(r >= 0  && r < grid.length && c >= 0  && c < grid[0].length && grid[r][c] == 1) {
				area += dfs(grid, r, c);
			}
		}
		return area;
	}
}
