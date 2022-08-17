package easy;

import java.util.Scanner;

public class reverseWordsInSentence {

	public static void main(String[] args) {
		Scanner sc =  new Scanner(System.in);
		System.out.print("Enter your sentence: ");
		String sentence  = sc.nextLine();
		
		String newSentence="";
		
		java.util.Stack<Character> st = new java.util.Stack<>();
		
		System.out.print("Output: ");
		
		for(int i = 0; i < sentence.length(); i++) {
			if(sentence.charAt(i) == ' ') {
				while(!st.isEmpty()) {
					newSentence += st.pop();
				}
				newSentence += " ";
			}
			else {
				st.push(sentence.charAt(i));
			}
		}
		while(!st.isEmpty()) {
			newSentence += st.pop();
		}
		
		sc.close();
		
		String output = "";
		for(int i = newSentence.length()-1 ; i>=0; i--) {
			output += newSentence.charAt(i);
		}
		System.out.println(output);

	}

}
