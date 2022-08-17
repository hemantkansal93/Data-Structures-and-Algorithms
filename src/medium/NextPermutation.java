package medium;

public class NextPermutation {

	public static void main(String[] args) {

		int[] nums = {3,2,1};
		
		getNextPerm(nums);
		
		for(int i = 0 ; i < nums.length; i++) {
			System.out.print(nums[i] +"\t");
		}

	}

	private static void getNextPerm(int[] nums) {
		int i = nums.length -2;
		
//		Step-1: Start from right side, Find first right index where digit is decreasing
		while(i >= 0 && nums[i]>nums[i+1]) i--;
		
		
		int j = nums.length -1;
//		Step-2: If step-1 is having some result, we would then only run step-2
//		Step-2: Look into the right of this found number which digit can swap this found digit
		if(i >= 0) {
			while( j > i && nums[j]<nums[i] ) j--;
			
//			Step-3:	Swap those numbers
			swap(nums, i, j);
		}
		
		
//	Reverse all the numbers to right of the digit found in step-1 (to find the very next permuation)
		reverse(nums, i+1, nums.length -1);
		
	}

	private static void reverse(int[] nums, int start, int end) {
		while(start<end) {
			swap(nums, start++, end--);
		}
		
	}

	private static void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
		
	}

}
