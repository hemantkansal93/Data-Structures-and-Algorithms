package medium;

public class First_And_Last_Position_Of_Element_In_Array {
//Given array in sorted
//	Return [-1,-1] if number is not found
	public static void main(String[] args) {
		int[] nums = {5,5,6,7,9,12,12,12,12,13,19,300};
		int target = 12;
		
		int[] res = findRange(nums, target);
		System.out.println("Answer: [" + res[0] +", "+ res[1] + "]");

	}
	
//	MAIN TRICK: CREATING 2 FUNCTIONS for calculating first and last of the range.

	private static int[] findRange(int[] nums, int target) {
		int first = first(nums, target);
		int last = last(nums,target);
		int[] res = {first, last};
		return res;
	}

	private static int first(int[] nums, int target) {
		int res = -1;
		int l = 0;
		int h = nums.length - 1;
		int m;
		
		while(l <= h) {
			m = l +(h-l)/2;
			if(nums[m] == target) {
				res = m;
				h = m-1;
			}
			else if(nums[m] > target) {
				h = m -1;
			}
			else {
				l = m +1;
			}
		}
		return res;
	}

	private static int last(int[] nums, int target) {
		int res = -1;
		int l = 0;
		int h = nums.length - 1;
		int m;
		
		while(l <= h) {
			m = l +(h-l)/2;
			if(nums[m] == target) {
				res = m;
				l = m+1;
			}
			else if(nums[m] > target) {
				h = m -1;
			}
			else {
				l = m +1;
			}
		}
		return res;
	}

}
