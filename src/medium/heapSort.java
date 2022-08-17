package medium;

public class heapSort {

//	Heapify algorithm
	public static void heapify(int[] arr, int i, int n) {
		if(i < 0) {
			return;
		}
		int l = 2*i + 1;
		int r = 2*i + 2;
		
		if(l<n && arr[i] < arr[l]) {
			int temp = arr[i];
			arr[i] = arr[l];
			arr[l] = temp;
		}
		if(r<n && arr[i] < arr[r]) {
			int temp = arr[i];
			arr[i] = arr[r];
			arr[r] = temp;
		}
		heapify(arr, i-1, n);
	}
	
//	Driver to call heapify algorithm (to create overall heap)
	public static void buildHeap(int[] arr, int n) {
		for(int i = n/2; i>0; i--) {
			heapify(arr, i, n);
		}
	}
	
//	Sort method 
	public static void sort(int[] arr, int n) {
		int last = arr[n-1];
		arr[n-1] = arr[0];
		arr[0] = last;
		
		n = n-1;
		buildHeap(arr,n);
	}
	
	
// Main Driver class
	public static void main(String[] args) {
		int[] arr = {3,2,3,1,2,4,5,5,6,7,7,8,2,3,1,1,1,10,11,5,6,2,4,7,8,5,6};
		int n = arr.length;
		buildHeap(arr, n);
		
		
		for(int i= 0 ; i < n; i++) {
			System.out.println(arr[i]);
		}
		
		
//		for(int i= n ; i > 1; i--) {
//			sort(arr, i);
//		}
//		
//		System.out.println("***************");
//		for(int i= 0 ; i < n; i++) {
//			System.out.println(arr[i]);
//		}
		
		int k = 20;
		
		for(int i = 0 ; i < k-1 ; i ++) {
			int last = arr[n-1];
			arr[n-1] = arr[0];
			arr[0] = last;
			n=n-1;
			
			buildHeap(arr, n);
			
		}
		System.out.println("Answer: ");
		System.out.println(arr[0]);
		
		
	}

}
