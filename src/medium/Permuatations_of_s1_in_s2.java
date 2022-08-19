package medium;

import java.util.Scanner;

public class Permuatations_of_s1_in_s2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter string s1: ");
		String s1 = sc.nextLine();
		System.out.print("Enter string s2: ");
		String s2 = sc.nextLine();
		sc.close();
		boolean answer = checkPermutation(s1,s2);
		System.out.println("Does s2 contains any permuations of s1? " + answer);
	}

	private static boolean checkPermutation(String s1, String s2) {
		int[] storeS1 = new int[26];
		for( int i = 0 ; i < s1.length(); i++) {
			storeS1[s1.charAt(i) - 'a']++;
		}
		
		for( int i = 0 ; i < (s2.length() - s1.length() + 1); i++) {
			int[] storeS2 = new int[26];
			for( int j = i; j < i+s1.length(); j++) {
				storeS2[s2.charAt(j) - 'a']++;
			}
			if(matches(storeS1, storeS2))
				return true;
		}
		return false;
	}

	private static boolean matches(int[] storeS1, int[] storeS2) {
		for( int i = 0 ; i < 26; i++) {
			if(storeS1[i] != storeS2[i])
				return false;
		}
		return true;
	}

}
