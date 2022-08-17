
public class InsertionSort {

	public static void main(String[] args) {
		int[] arr = {23, 25, 12, 11, 9, 22};
		int n = arr.length;//6
//		int sorted = 0;
		for(int i = 1; i<n; i++) {//5
			int number = arr[i];//25
			for(int j = i-1; j >=0; j--) {
				if(number > arr[j]) {
					arr[j+1] = number;
					break;
				}
				else {
					arr[j+1] = arr[j];
					if(j==0) {
						arr[j] = number;
					}
				}
			}
		}
		
		for(int i = 0 ; i < n; i++) {
			System.out.print(arr[i] +"\t");
		}
		
	}
}
