package medium;

import java.util.ArrayList;
import java.util.List;

public class Combinations {

	public static void main(String[] args) {
		int n = 4;
		int k = 2;
		List<List<Integer>> res = getCombinations(n, k);
		for (int i = 0; i < res.size(); i++) {
			for (int j = 0; j < res.get(i).size(); j++) {
				System.out.print(res.get(i).get(j) + ", ");
			}
			System.out.println();
		}
	}

	private static List<List<Integer>> getCombinations(int n, int k) {
		List<List<Integer>> res = new ArrayList<>();
		helper(res, new ArrayList<>(), n, k, 1);
		return res;
	}

	private static void helper(List<List<Integer>> res, List<Integer> curr, int n, int k, int index) {
		if( curr.size() == k) {
			res.add(new ArrayList<>(curr));
			return;
		}
		for( int i = index ; i <= n ; i++) {
			curr.add(i);
			helper(res, curr, n , k , i+1);
			curr.remove(curr.size() -1);
		}
	}
}
