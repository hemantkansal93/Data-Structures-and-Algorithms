package hard;

import java.util.ArrayList;
import java.util.List;

public class Kth_Next_Permutation {

	public static void main(String[] args) {
		int n = 5;
		int k = 78;
		
		String answer = kthPermutation(n, k);
		System.out.println("The " + k + "th permutation is " + answer);
	}

	private static String kthPermutation(int n, int k) {
		String answer = "";
		List<Integer> numbers = new ArrayList<>();
		int fact =1;
		
		for( int i = 1 ; i < n; i++) {
			fact = fact * i;
			numbers.add(i);
		}
		numbers.add(n);
		k = k-1;
		
		while(numbers.size() != 0) {
			int value = numbers.get(k/fact);
			answer += String.valueOf(value);
			numbers.remove(k/fact);
			k = k%fact;
			if(numbers.size() != 0) {
				fact = fact/numbers.size();
			}
		}
		return answer;
	}
}
