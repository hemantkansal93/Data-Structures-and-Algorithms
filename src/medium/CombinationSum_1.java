package medium;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum_1 {

	public static void main(String[] args) {
		int[] candidates= {2,3,5};
		int target = 8;
		
		List<List<Integer>> solutions = new ArrayList<>();
		
		helper(candidates, target, solutions, new ArrayList<>(), 0);
		
		for ( int i = 0 ; i < solutions.size(); i++) {
			for(int j = 0; j < solutions.get(i).size(); j++) {
				System.out.print(solutions.get(i).get(j) + ", ");
			}
			System.out.println();
		}

	}

	private static void helper(int[] candidates, int target, List<List<Integer>> solutions, List<Integer> solution,
			int index) {
		if(target == 0) {
			solutions.add(new ArrayList<Integer>(solution));
			return;
		}
		if(target < 0) {
			return;
		}
		
		for(int i = index; i < candidates.length; i++) {
			solution.add(candidates[i]);
			helper(candidates, target- candidates[i], solutions, solution, i );
			solution.remove(solution.size() -1);
		}
		
	}

}
