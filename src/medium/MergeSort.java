package medium;

public class MergeSort {

	public static void main(String[] args) {
		int[] nums = {2,4,1,9,4,7,10,3,20};
		sort(nums, 0, nums.length-1);
		for(int i = 0 ; i < nums.length; i++) {
			System.out.print(nums[i] +"\t");
		}
	}

	private static void sort(int[] nums, int l, int h) {
		if(l<h) {
			int m = l +(h-l)/2;
			sort(nums, l , m);
			sort(nums, m+1, h);
			merge(nums, l, m , h);
		}
	}

	private static void merge(int[] nums, int l, int m, int h) {
//		Sizes of arrays
		int n1 = m -l + 1;
		int n2 = h - m;
		
//		Creating arrays
		int[] L = new int [n1];
		int[] R = new int [n2];
		
//		Populate values in these arrays
		for(int i = 0 ; i < n1; i++ ) {
			L[i] = nums[l+i];
		}
		for(int i = 0 ; i < n2; i++ ) {
			R[i] = nums[m+1+i];
		}
		
//		Merging arrays
		int i = 0;
		int j = 0;
		int k = l;
		
		while(i < n1 && j< n2) {
			if(L[i] < R[j]) {
				nums[k] = L[i++];
			}
			else {
				nums[k] = R[j++];
			}
			k++;
		}
		while(i < n1) {
			nums[k++] = L[i++];
		}
		while(j < n2) {
			nums[k++] = R[j++];
		}
	}

}
