package easy;

public class RotatingArray_LeftToRight {

	public static void main(String[] args) {
		int[] arr = {1,4,6,11,23,7,19,8};
		int positions = 9;
		rotateArray(arr, positions);
		for(int i = 0 ; i < arr.length; i++) {
			System.out.print(arr[i] +"\t");
		}

	}
	
	public static void rotateArray(int[] arr, int positions) {
		int n = arr.length;
		int k = positions%arr.length;
		reverseArray(arr, 0, n-k-1);
		if(k != 0)
			reverseArray(arr, n-k, n-1);
		reverseArray(arr, 0, n-1);
	}
	
	public static void reverseArray(int[] arr, int start, int end) {
		int l = start + (end-start)/2;
		for(int i = start; i <= l; i++) {
			int temp = arr[i];
			arr[i] = arr[end];
			arr[end--] = temp;
		}
	}

}
