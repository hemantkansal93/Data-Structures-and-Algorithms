package medium;

import java.util.HashMap;

public class Largest_SubArray_Sum_0 {

//	Logic: Track where we would get the same sum in the next iteration
	public static void main(String[] args) {
		int[] nums = { 0, 15, -2, 2, -8, -15, 1, 7, 10, 23 };

		int maxLength = getMaxLength(nums);
		System.out.println("The length of the longest sub-array with sum = 0 is " + maxLength);
	}

	private static int getMaxLength(int[] nums) {
		int length = 0;
		int sum = 0;
		HashMap<Integer, Integer> hm = new HashMap<>();
		for( int i = 0 ; i < nums.length; i++) {
			sum += nums[i];
			if(i == 0 && sum == 0 )
				length = 1;
			if(sum == 0) {
				length = i+1;
			}
			if(hm.containsKey(sum)) {
				length = Math.max(length, i - hm.get(sum));
			}
			else {
				hm.put(sum, i);
			}
		}
		return length;
	}

}
