package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets_2 {

	public static void main(String[] args) {
		int[] nums = {1,2,2};
		List<List<Integer>> res = getSubsets(nums);
		for( int i = 0; i < res.size(); i++) {
			for( int j = 0 ; j < res.get(i).size(); j++) {
				System.out.print(res.get(i).get(j) +", ");
			}
			System.out.println();
		}
	}

	private static List<List<Integer>> getSubsets(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> res = new ArrayList<>();
		helper(nums, res, new ArrayList<>(), 0);
		return res;
	}

	private static void helper(int[] nums, List<List<Integer>> res, List<Integer> sol, int index) {
		if(index > nums.length)
			return;
		res.add(new ArrayList<Integer>(sol));
		for(int i = index ; i < nums.length; i++) {
			if(i >index && nums[i] == nums[i-1]) {
				continue;
			}
			sol.add(nums[i]);
			helper(nums, res, sol, i+1);
			sol.remove(sol.size() -1);
		}
	}
}
