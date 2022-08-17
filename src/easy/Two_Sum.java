package easy;

import java.util.Arrays;

public class Two_Sum {

	
//	Given an array of integers nums and an integer target, 
//	return indices of the two numbers such that they add up to target.
//	You may assume that each input would have exactly one solution, 
//	and you may not use the same element twice.
//	You can return the answer in any order.
	public static void main(String[] args) {
		int[] arr1 = {1,4,6,11,23,7,19,8};
		int[] arr =  new int[arr1.length];
		for(int i = 0 ; i < arr1.length; i++) {
			arr[i] = arr1[i];
		}
		
		int sum = 10;
		int[] res = getTwoSum(arr, sum);
		int index = 0;
		for(int i = 0 ; i < arr1.length; i++) {
			if(index < 2 &&(arr1[i] == res[index])) {
				index++;
				System.out.println(i);
			}
		}
	}
	
	public static int[] getTwoSum(int[] arr, int givenSum) {
		int[] res= new int[2];
		Arrays.sort(arr);
		int start= 0; 
		int end = arr.length-1;
		for(int i = 0 ; i < arr.length-1; i++) {
			int sum = arr[start] + arr[end];
			if(sum == givenSum) {
				res[0] = arr[start];
				res[1] = arr[end];
				break;
			}
			else if (sum > givenSum) {
				end--;
			}
			else {
				start++;
			}
		}
		return res;
	}

}
