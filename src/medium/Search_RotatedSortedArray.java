package medium;

public class Search_RotatedSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] nums = {4,5,6,7,0,1,2};
		int target  = 5;
		
		int index = search(nums, target);
		
		System.out.println("The index of the element " + target + " is " + index);
	}

	private static int search(int[] nums, int target) {
		int l = 0;
		int h = nums.length - 1;

		while (l <= h) {
			int m = l + (h - l) / 2;
			if (nums[m] == target) {
				return m;
			} else if (nums[m] >= nums[l]) {
				if(nums[l] <= target && target <= nums[m]) {
					h = m-1;
				}
				else {
					l = m+1;
				}
				
			} else if (nums[m] >= nums[l]) {
				if(nums[h] >= target && target >= nums[m]) {
					l = m+1;
				}
				else {
					h = m-1;
				}
			}
		}
		return -1;
	}
}
