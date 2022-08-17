package medium;

public class QuickSort {

	public static void main(String[] args) {
		int[] nums = {2,4,1,9,4,7,10,3,20};
		quickSort(nums, 0, nums.length-1);
		for(int i = 0 ; i < nums.length; i++) {
			System.out.print(nums[i] +"\t");
		}
	}

	private static void quickSort(int[] nums, int l, int h) {
		if(l<h) {
			int pi = partition(nums, l, h);
			quickSort(nums, l , pi-1);
			quickSort(nums, pi+1, h);
		}
	}

	private static int partition(int[] nums, int l, int h) {
		int pivot = nums[h];
		int i = l-1;
		for( int j = l ; j <= h-1; j++) {
			if(nums[j] < pivot) {
				i++;
				swap(nums, i, j);
			}
		}
		swap(nums, i + 1, h);
		return (i+1);
	}

	private static void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}
