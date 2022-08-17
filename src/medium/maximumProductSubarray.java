package medium;

public class maximumProductSubarray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {-2};
		maxProduct(nums);

	}
	
	 public static int maxProduct(int[] nums) {
	        int prod = 1;
	        int max = Integer.MIN_VALUE;
	        for(int i = 0 ; i  < nums[i] ;  i++){
	            prod *= nums[i];
	            System.out.println("Hi");
	            max = Math.max(prod, max);
	            if(prod == 0){
	                prod = 1;
	            }
	        }
	        return max;
	    }

}
