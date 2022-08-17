package easy;

import java.util.Scanner;

public class reverseAlphabetsOfWords {

	public static void main(String[] args) {
		Scanner sc =  new Scanner(System.in);
		System.out.print("Enter your sentence: ");
		String sentence  = sc.nextLine();
		
		java.util.Stack<Character> st = new java.util.Stack<>();
		
		System.out.print("Output: ");
		
		for(int i = 0; i < sentence.length(); i++) {
			if(sentence.charAt(i) == ' ') {
				while(!st.isEmpty()) {
					System.out.print(st.pop());
				}
				System.out.print(" ");
			}
			else {
				st.push(sentence.charAt(i));
			}
		}
		while(!st.isEmpty()) {
			System.out.print(st.pop());
		}
		
		sc.close();
		
	}
}
