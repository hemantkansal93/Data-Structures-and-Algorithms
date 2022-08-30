package medium;

import java.util.ArrayList;
import java.util.List;

public class Generate_Parenthesis {

	public static void main(String[] args) {
		int n = 3;
		List<String> res = generateParenthesis(n);
		for( int i = 0 ; i < res.size(); i++) {
			System.out.println(res.get(i));
		}

	}

	private static List<String> generateParenthesis(int n) {
		List<String> res = new ArrayList<>();
		helper(res,"", n, 0, 0);
		return res;
	}

	private static void helper(List<String> res, String s, int n, int open, int close) {
		if(open ==n && close == n) {
			res.add(s);
			return;
		}
		if(open < n) {
			s += "(";
			helper(res, s, n, open+1, close);
			s = s.substring(0,s.length()-1);
		}
		if(close < open) {
			s += ")";
			helper(res, s, n, open, close+1);
			s = s.substring(0,s.length()-1);
		}
	}
}
