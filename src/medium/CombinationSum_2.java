package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class CombinationSum_2 {

	public static void main(String[] args) {
		int[] candidates = { 10, 1, 2, 7, 6, 1, 5 };
		int target = 8;
		Arrays.sort(candidates);
		HashSet<List<Integer>> hs = new HashSet<>();

		helper(candidates, target, hs, new ArrayList<>(), 0);

		List<List<Integer>> solutions = new ArrayList<>(hs);
		for (int i = 0; i < solutions.size(); i++) {
			for (int j = 0; j < solutions.get(i).size(); j++) {
				System.out.print(solutions.get(i).get(j) + ", ");
			}
			System.out.println();
		}

	}

	private static void helper(int[] candidates, int target, HashSet<List<Integer>> solutions, List<Integer> solution,
			int index) {
		if (target == 0) {
			solutions.add(new ArrayList<Integer>(solution));
			return;
		}
		if (target < 0) {
			return;
		}

		for (int i = index; i < candidates.length; i++) {
			solution.add(candidates[i]);
			helper(candidates, target - candidates[i], solutions, solution, i+1);
			solution.remove(solution.size() - 1);
		}

	}

}
