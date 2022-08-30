package medium;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

	public static void main(String[] args) {
		int[] nums = {1,2,3};
		List<List<Integer>> res = getSubsets(nums);
		for( int i = 0; i < res.size(); i++) {
			for( int j = 0 ; j < res.get(i).size(); j++) {
				System.out.print(res.get(i).get(j) +", ");
			}
			System.out.println();
		}

	}

	private static List<List<Integer>> getSubsets(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		helper(res, new ArrayList<>(), nums, 0);
		return res;
	}

	private static void helper(List<List<Integer>> res, List<Integer> curr, int[] nums, int i) {
		if(i == nums.length) {
			res.add(new ArrayList<>(curr));
			return;
		}
		curr.add(nums[i]);
		helper(res, curr, nums, i+1);
		curr.remove(curr.size()-1);
		helper(res, curr, nums, i+1);
	}

}
