package easy;

import java.util.HashMap;

public class Non_Repeating_Elements {

	public static void main(String[] args) {
		int[] nums = {1,1,4,-1,2,-1,-5,4};
		int ans = findFirstNonRepeatingElement(nums);
		System.out.println("The first non-repeating element in the given array is " + ans);
	}

	private static int findFirstNonRepeatingElement(int[] nums) {
		HashMap<Integer, Integer> hm = new HashMap<>();
		for( int i = 0 ; i < nums.length; i++) {
				hm.put(nums[i], hm.getOrDefault(nums[i],0) +1);
		}
		for (int i = 0; i < nums.length; i++) {
			if(hm.get(nums[i]) == 1)
				return nums[i];
		}
        return -9999;
	}
}
