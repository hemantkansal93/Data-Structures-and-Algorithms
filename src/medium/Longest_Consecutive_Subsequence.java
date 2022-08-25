package medium;

import java.util.HashSet;

public class Longest_Consecutive_Subsequence {

	public static void main(String[] args) {
		int[] nums = {101, 9, 3, 5, 10, 4, 20, 2,0,0,0,0,0,6};
		int length = longestSequence(nums);
		System.out.println("The longest consecutive sequence has length = " + length);
	}
//	TRICK: 1. Store all elements in HASHSET
//		2. Look for each element if it is not the first number of the the consecutive sequence
//	This can be done by looking for current number minus 1
	

	private static int longestSequence(int[] nums) {
		HashSet<Integer> hs =new HashSet<>();
		int length = 0; 
		for( int i = 0; i < nums.length; i++) {
			hs.add(nums[i]);
		}
		
		for(int i = 0 ; i < nums.length; i++) {
			int count = 1;
			if( !hs.contains(nums[i] - 1)) {
				while(hs.contains(++nums[i]))
					count++;
			}
			length = Math.max( length, count);
		}
		return length;
	}

}
