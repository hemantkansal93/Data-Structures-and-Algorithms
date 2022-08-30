package medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LetterCombinations_of_PhoneNumber {
	static String[] store = {"0","1","abc","def","ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
	public static void main(String[] args) {
		String digits= "236";
		List<String> res= getCombinations(digits);
		for( int i = 0 ; i< res.size(); i++) {
			System.out.println(i+1 + ": " + res.get(i));
		}

	}
	private static List<String> getCombinations(String digits) {
		List<String> res =new ArrayList<>();
		if( digits.length() == 0) {
			return res;
		}		
		//	Using DFS
//		dfs(digits, res, "", 0);
		
		// Using BFS
		bfs(digits, res);
		return res;
	}

	
	private static void bfs(String digits, List<String> res) {
		int[] numbers = new int[digits.length()];
		for( int i = 0 ; i < digits.length(); i++) {
			numbers[i] = Character.getNumericValue(digits.charAt(i));
		}
		Queue<String> q = new LinkedList<>();
		q.add("");
		while(!q.isEmpty()) {
			String s = q.remove();
			if(s.length() == digits.length()) {
				res.add(s);
			}
			else {
				String val = store[numbers[s.length()]];
				for (int i = 0; i < val.length(); i++) {
					q.add(s + val.charAt(i));
				}
			}
		}
	}
	
	
	
	private static void dfs(String digits, List<String> res, String sol, int index) {
		if(index == digits.length()) {
			res.add(sol);
			return;
		}
		
		char c = digits.charAt(index);
		int number = Character.getNumericValue(c);
		String digitString = store[number];
		
		for( int i = 0 ; i < digitString.length(); i++) {
			sol += digitString.charAt(i);
			dfs(digits, res, sol, index+1);
			sol = sol.substring(0, sol.length()-1);
		}
		
	}

}
