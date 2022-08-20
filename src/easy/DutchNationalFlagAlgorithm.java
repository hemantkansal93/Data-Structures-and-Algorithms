package easy;

public class DutchNationalFlagAlgorithm {

	public static void main(String[] args) {
		int nums[] = { 0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1 };
		int pivot = 1;
		System.out.println("*** BEFORE ALGORITHM ***");
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + "\t");
		}
		dnf1(nums, pivot);
		System.out.println();
		System.out.println("*** AFTER ALGORITHM ***");
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + "\t");
		}

	}

	private static void dnf1(int[] nums, int pivot) {
//		TWO Traversals
		int start = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] < pivot) {
				swap(nums, i, start);
				start++;
			}
		}

		int end = nums.length - 1;
		for (int i = nums.length-1; i >= start; i--) {
			if (nums[i] > pivot) {
				swap(nums, i, end);
				end--;
			}
		}
	}
	private static void swap(int[] nums, int i, int newIndex) {
		int temp = nums[i];
		nums[i] = nums[newIndex];
		nums[newIndex] = temp;
	}

}
