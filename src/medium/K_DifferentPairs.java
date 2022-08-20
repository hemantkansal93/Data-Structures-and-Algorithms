package medium;

import java.util.HashMap;
import java.util.Map;

public class K_DifferentPairs {

	public static void main(String[] args) {
		int[] nums = { 3, 1, 4, 1, 5 };
		int target = 3;

		int numberOfPairs = getK_DifferentPairs(nums, target);

		System.out.println("The number of different pairs with difference = " + target + " are " + numberOfPairs);
	}

	private static int getK_DifferentPairs(int[] nums, int target) {
		HashMap<Integer, Integer> hm = new HashMap<>();
		int count = 0;
		
		// Populating HashMap with unique values
		for (int i = 0; i < nums.length; i++) {
			hm.put(nums[i], hm.getOrDefault(nums[i], 0) + 1);
		}

		// Checking for 2 different cases: k = 0 (same numbers) or k > 0
		for (Map.Entry<Integer, Integer> e : hm.entrySet()) {
			if ((target > 0 && hm.containsKey(e.getKey() + target)) || (target == 0 && hm.get(e.getKey())>1)){
				count ++;
			}
		}
		return count;
	}

}
