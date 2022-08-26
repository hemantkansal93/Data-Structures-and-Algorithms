package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
//	Return all UNIQUE quadruplets 
	public static void main(String[] args) {
		int[] nums = {1,0,-1,0,-2,2};
		int target = 0;
		List<List<Integer>> res = findQuadruplets(nums, target);
		for ( int i = 0 ; i < res.size(); i++) {
			for( int j = 0 ; j < res.get(i).size(); j++) {
				System.out.print(res.get(i).get(j) + ", ");
			}
			System.out.println();
		}

	}

	private static List<List<Integer>> findQuadruplets(int[] nums, int target) {
		List<List<Integer>> res = new ArrayList<>();
		int n = nums.length;
		if( n < 4)
			return res;
		Arrays.sort(nums);
		for( int i = 0; i < n-3; i++) {
			for( int j = i+1; j < n-2; j++) {
				int left = j+1;
				int right = n-1;
				while(left < right) {
					int sum = nums[i] + nums[j] +nums[left] + nums[right];
					if(sum == target) {
						List<Integer> list =new ArrayList<>();
						list.add(nums[i]);
						list.add(nums[j]);
						list.add(nums[left]);
						list.add(nums[right]);
						res.add(list);
						
						int leftValue = nums[left];
						while(left < n && nums[left] == leftValue) {
							left++;
						}
						int rightValue = nums[right];
						while(right > left && nums[right] == rightValue) {
							right--;
						}
					}
					else if(sum < target) {
						left++;
					}
					else {
						right--;
					}
					while(j+1 < n && nums[j] == nums[j+1]) {
						j++;
					}
					while(i+1 < n && nums[i] == nums[i+1]) {
						i++;
					}
				}
			}
		}
		return res;
	}
}
