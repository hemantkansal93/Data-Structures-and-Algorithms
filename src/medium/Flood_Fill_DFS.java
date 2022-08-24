package medium;

public class Flood_Fill_DFS {

	public static void main(String[] args) {
		int[][] image = {{1,1,1},{0,1,0},{1,0,1}};

//		Presenting image before flood fill
		System.out.println("***Before flood fill***");
		for(int i= 0 ; i < image.length; i++) {
			for( int j = 0 ; j < image[i].length; j++) {
				System.out.print(image[i][j] + "\t");
			}
			System.out.println();
		}
		System.out.println();
//		In following line, we are going to flood fill the image matrix 
//		by new color which is indicated by "2" (last argument).
//		Then we have two 1's in the middle arguments. Those represent the present focus (sr,sc)
		floodFill(image, 1,1, 2);
		
//		Presenting image after flood fill
		System.out.println("***After flood fill***");
		for(int i= 0 ; i < image.length; i++) {
			for( int j = 0 ; j < image[i].length; j++) {
				System.out.print(image[i][j] + "\t");
			}
			System.out.println();
		}
	}

	private static void floodFill(int[][] image, int sr, int sc, int color) {
		int prevColor = image[sr][sc];
		
		if(prevColor == color) {
			return;
		}
		fill(image, sr,sc, prevColor, color);
	}

//	USING RECURSION
	private static void fill(int[][] image, int sr, int sc, int prevColor, int newColor) {
		if(image[sr][sc] != prevColor)
			return;
		image[sr][sc] = newColor;
		
		int[] directions = {-1,0,1,0,-1};
		
		for( int i = 0 ; i < 4; i++) {
			int r  = sr + directions[i];
			int c  = sc + directions[i+1];
			
			if(r >=0  && r<image.length && c>=0 && c < image[0].length) {
				fill(image, r,c,prevColor, newColor);
			}
		}
		
	}

}
