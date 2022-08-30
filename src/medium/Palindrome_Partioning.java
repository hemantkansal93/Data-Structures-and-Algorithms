package medium;

import java.util.ArrayList;
import java.util.List;

public class Palindrome_Partioning {

	public static void main(String[] args) {
		String s ="aab";
		List<List<String>> res= partioning(s);
		for( int i = 0; i < res.size(); i++) {
			for( int j = 0 ; j < res.get(i).size(); j++) {
				System.out.print(res.get(i).get(j) +", ");
			}
			System.out.println();
		}
	}

	private static List<List<String>> partioning(String s) {
		List<List<String>> res = new ArrayList<>();
		helper(s, res, new ArrayList<>(), 0);
		return res;
	}

	private static void helper(String s, List<List<String>> res, List<String> sol, int index) {
		if(index >= s.length()) {
			res.add(new ArrayList<String>(sol));
			return;
		}
		for( int i = index; i < s.length(); i++) {
			if(palindrome(s.substring(index, i+1))) {
				sol.add(s.substring(index, i+1));
				helper(s, res, sol, i+1);
				sol.remove(sol.size()-1);
			}
		}
	}

	private static boolean palindrome(String s) {
		for( int i = 0 ; i < s.length()/2; i++) {
			if(s.charAt(i) != s.charAt(s.length()-1 -i)) {
				return false;
			}
		}
		return true;
	}

}
