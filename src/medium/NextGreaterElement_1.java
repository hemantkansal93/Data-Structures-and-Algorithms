package medium;

import java.util.HashMap;

public class NextGreaterElement_1 {

	/*
	 * *The next greater element of some element x in an array is the first greater
	 *  element that is to the right of x in the same array.
	 *  You are given two distinct 0-indexed integer arrays nums1 and nums2,
	 *  where nums1 is a subset of nums2. For each 0 <= i < nums1.length,
	 *  find the index j such that nums1[i] == nums2[j] and 
	 *  determine the next greater element of nums2[j] in nums2.
	 *  If there is no next greater element, then the answer for this query is -1.
	 *  Return an array ans of length nums1.length such that 
	 *  ans[i] is the next greater element as described above.
	 */
	
	public static void main(String[] args) {
		int[] nums1 = {4,1,2};
		int[] nums2 = {1,3,4,2};
		
		int[] res =findNextGreaterElement(nums1, nums2);
		System.out.println("Number: \t Next Greater number:");
		for( int i = 0 ; i < nums1.length; i++) {
			System.out.println(nums1[i] + "\t\t" +res[i]);
		}
	}

	
	private static int[] findNextGreaterElement(int[] nums1, int[] nums2) {
		int n1 = nums1.length;
		int n2 = nums2.length;
		
		java.util.Stack<Integer> st = new java.util.Stack<>();
		HashMap<Integer, Integer> hm = new HashMap<>();
		int res[] = new int[n1];
		
		for( int i = n2-1; i >= 0; i--) {
			while(!st.isEmpty() && st.peek() < nums2[i]) {
				st.pop();
			}
			if(st.isEmpty()) {
				hm.put(nums2[i], -1);
			}
			else {
				hm.put(nums2[i], st.peek());
			}
			st.push(nums2[i]);
		}
		
		for( int i = 0 ; i < n1; i++) {
			res[i] = hm.get(nums1[i]);
		}
		return res;
		
	}

}
