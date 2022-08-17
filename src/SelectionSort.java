
public class SelectionSort {

	public static void main (String[] args) {
		int[] arr = {23, 25, 12, 11, 9, 22};
		int n = arr.length;
		
		for(int i = 0 ; i < n-1; i++ ) {
			int smallest = i;
			
			for(int j = i+1; j <n; j++) {
				if(arr[smallest] > arr[j]) {
					smallest = j;
				}
			}
			
			int temp = arr[smallest];
			arr[smallest] = arr[i];
			arr[i] = temp;
		}
		
		for(int i = 0; i<n; i++) {
			System.out.print(arr[i] +"\t");
		}
	}
}
