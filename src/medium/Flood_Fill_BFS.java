package medium;

import java.util.LinkedList;
import java.util.Queue;

public class Flood_Fill_BFS {

	static class Ele{
		int x;
		int y;
		
		public Ele(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
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
		Queue<Ele> q = new LinkedList<>();
		q.add(new Ele(sr,sc));
		
		while(!q.isEmpty()) {
			Ele e= q.remove();
			image[e.x][e.y] = color;
			
			int[] directions = {-1,0,1,0,-1};
			
			for( int i = 0 ; i < 4; i++) {
				int r  = e.x + directions[i];
				int c  = e.y + directions[i+1];
				
				if(r >=0  && r<image.length && c>=0 && c < image[0].length && image[r][c] == prevColor)
					q.add(new Ele(r,c));
			}
		}
	}
}
