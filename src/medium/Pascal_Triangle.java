package medium;

import java.util.ArrayList;
import java.util.List;

public class Pascal_Triangle {

	public static void main(String[] args) {
		int numRows = 9;
		List<List<Integer>> res =  pascaltriangle(numRows);
		
		for(int i = 0 ; i < res.size(); i++) {
			for(int j = 0; j<res.get(i).size(); j++) {
				System.out.print(res.get(i).get(j) +"\t");
			}
			System.out.println();
		}

	}

	private static List<List<Integer>> pascaltriangle(int numRows) {
		List<List<Integer>> res =  new ArrayList<>();
		
		for(int line = 1; line <= numRows; line++) {
			List<Integer> temp = new ArrayList<>();
			int c =1;
			for(int i = 1; i <= line; i++) {
				temp.add(c);
				c = c*(line-i)/i;
			}
			res.add(temp);
		}
		return res;
	}

}
