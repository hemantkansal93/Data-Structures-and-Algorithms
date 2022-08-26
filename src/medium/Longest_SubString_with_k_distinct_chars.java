package medium;

import java.util.Arrays;

public class Longest_SubString_with_k_distinct_chars {

	public static void main(String[] args) {
		String s = "aabbccddeeaxaa";
		int k = 4;
		String longestString = findLongestSubString(s, k);
		System.out.println("the longest substring with k distinct characters is " + longestString);
	}

	private static String findLongestSubString(String s, int k) {
		int[] count = new int[26];
		int n = 0;
		for( int i = 0 ; i < s.length(); i++) {
			if(count[s.charAt(i)-'a'] == 0) {
				n++;
			}
			count[s.charAt(i)-'a']++;
		}
		if(n<k) {
			return "NOT POSSIBLE (number of distinct characters are lesser than required)";
		}
		
		Arrays.fill(count, 0);
		
		int curr_start = 0;
		int curr_end = 0;
		
		int max_window_size = 1;
		int max_window_start = 0;
		count[s.charAt(0) -'a']++;
		
		for( int i = 1; i < s.length(); i++) {
			count[s.charAt(i)-'a']++;
			curr_end++;
			
			while(!isValid(count,k)) {
				count[s.charAt(curr_start)-'a']--;
				curr_start++;
			}
			
			if(curr_end - curr_start + 1 > max_window_size) {
			max_window_size = curr_end - curr_start + 1;
			max_window_start = curr_start;
			}
		}
		return s.substring(max_window_start, max_window_start + max_window_size);
	}

	private static boolean isValid(int[] count, int k) {
		int n = 0;
		for (int i = 0; i < count.length; i++) {
			if (count[i] > 0)
				n++;
		}
		return (k >= n);
	}

}
