package medium;

import java.util.Scanner;

public class LongestStringWithoutRepetition {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the string: ");
		String s = sc.nextLine();
		int maximum_length = longestString(s);
		System.out.println("The longest substring in the given string(without repetiotions) is " + maximum_length);
		sc.close();
	}

//	Responsible method for finding the length of the longest substring of given string
	private static int longestString(String s) {
		if(s.length() < 2) {
			return s.length();
		}
		int maxLength = Integer.MIN_VALUE;
		String text = "";
		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			int index = getIndex(text, c);
			text = text.substring(index + 1) + c;
			maxLength = Math.max(maxLength, text.length());
		}
		return maxLength;
	}

//	Method for finding index of character in a string
	private static int getIndex(String s, char c) {
		for( int i = 0 ; i < s.length(); i++) {
			if(s.charAt(i) == c) 
				return i;
		}
		return -1;
	}
}
