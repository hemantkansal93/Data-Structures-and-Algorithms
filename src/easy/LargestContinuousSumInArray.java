package easy;

public class LargestContinuousSumInArray {

	public static void main(String[] args) {
		int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
		
		int result = getMaxSum(nums);
		System.out.println("The maximum sum of continuous sub-array is " + result);

	}

	private static int getMaxSum(int[] nums) {
		int maxSum =  Integer.MIN_VALUE;
		int sum = 0; 
		for(int i = 0 ; i < nums.length; i++) {
			sum = nums[i] + Math.max(0, sum);
			maxSum = Math.max(maxSum, sum);
		}
		return maxSum;
	}

}
