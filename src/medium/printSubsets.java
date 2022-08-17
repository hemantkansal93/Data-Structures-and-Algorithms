package medium;

import java.util.ArrayList;

public class printSubsets {

	public static void getSubsets(int n , ArrayList<Integer> subset) {
		if(n == 0 ) {
			printSubset(subset);
			return;
		}
		subset.add(n);
		getSubsets(n-1, subset);
		subset.remove(subset.size()-1);
		getSubsets(n-1, subset);
		
	}
	
	private static void printSubset(ArrayList<Integer> subset) {
		// TODO Auto-generated method stub
		for(int i = 0 ; i < subset.size(); i++) {
			System.out.print(subset.get(i) + "\t");
		}
		System.out.println();
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=3;
		ArrayList<Integer> subset = new ArrayList<>();
		getSubsets(n, subset);

	}

}
