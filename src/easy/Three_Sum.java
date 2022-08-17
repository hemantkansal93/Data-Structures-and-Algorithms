package easy;

import java.util.Arrays;

public class Three_Sum {

	public static void main(String[] args) {
//		Assuming there is exactly one and only one triplet present in the nums which can sum to target
		int nums[] = {11,10,1,2,40,4,100,11};
		int target = 7;
		int[] res = new int[3];
		
		res =  find3Sum(nums, target);
		System.out.print(res[0] + "\t" +res[1] + "\t" + res[2]);

	}
	
	public static int[] find3Sum(int[] nums, int target) {
		Arrays.sort(nums);
		int[] res = new int[3];
		for(int i = 0 ; i < nums.length-2; i++) {
			int start = i+1 ;
			int end = nums.length-1;
			for(int j = i+1; j<nums.length-1; j++) {
				int sum = nums[i] + nums[start] + nums[end];
				if(sum == target) {
					res[0] = nums[i];
					res[1] = nums[start];
					res[2] = nums[end];
					break;
				}
				if(sum > target) {
					end--;
				}
				else {
					start++;
				}
			}
		}
		return res;
	}

}
