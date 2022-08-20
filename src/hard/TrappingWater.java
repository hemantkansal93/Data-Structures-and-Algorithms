package hard;

public class TrappingWater {

	public static void main(String[] args) {
//		int[] heights = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		int[] heights = { 4,2,0,3,2,5};
		int water = findTrappedwater(heights);
		System.out.println("The amount of water that can be stored in the given situation is " + water);
	}

	private static int findTrappedwater(int[] heights) {
		int n = heights.length;
		int res = 0;
		
//		Creating 2 arrays to store maximum heights on either side 
//		(left side and right side) of ith height.
		int[] maxl = new int[n];
		int[] maxr = new int[n];

//		Populate these arrays with maximum heights
		// Left maximums for each ith height
		maxl[0] = heights[0]; // Initializing first height because nothing is present on left of first height
		for (int i = 1; i < n; i++) {
			maxl[i] = Math.max(maxl[i - 1], heights[i]);
		}
		
		// Right maximums for each ith height (starting from right side)
		maxr[n - 1] = heights[n - 1]; // Initializing last height because nothing is present on right of last height
		for( int i = n-2; i >= 0; i--) {
			maxr[i] = Math.max(maxr[i+1], heights[i]);
		}
		
//		We would minimum height of these maximums (2 maximums -left maximum and right maximum)
//		because water storage would depend on small height....
//		Another thing, we would subtract calculation from height[i] 
//		because that won't be responsible for storing water (not a empty space) ....
//		Let's calculate water which can be trapped for each height.
		
//		Both the heights at the ends (left end and right end) can not store any water
		for(int i = 1; i < n-1; i++) {
			res += Math.min(maxl[i], maxr[i]) - heights[i];
		}
		return res;
	}

}
