package easy;

public class MoveZeroesToRight {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = {0,1,0,3,12};
		moveZeroes(arr);
		
		for(int i = 0 ; i < arr.length; i++) {
			System.out.print(arr[i] +"\t");
		}
	}
	
	public static void moveZeroes(int[] nums) {
		int start = 0 ;
		for(int i = 0 ; i < nums.length; i++) {
			if(nums[i] != 0) {
				nums[start++] = nums[i];
			}
		}
		for(int i = start; i < nums.length; i++) {
			nums[i] = 0;
		}
	}

}
