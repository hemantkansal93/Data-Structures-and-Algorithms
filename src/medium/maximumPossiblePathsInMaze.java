package medium;

public class maximumPossiblePathsInMaze {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int m= 3, n=3;
		System.out.println(getPaths(0,0,m,n));

	}

	
	public static int getPaths(int i, int j , int m, int n) {
		if(i == m || j == n) {
			return 0;
		}		
		if(i == m-1 && j == n-1) {
			return 1;
		}
		
		int downpaths = getPaths(i+1, j, m , n);
		int rightpaths = getPaths(i, j+1, m, n);
		
		return downpaths + rightpaths;
	}
}
