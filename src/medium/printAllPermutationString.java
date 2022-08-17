package medium;

import java.util.ArrayList;
import java.util.List;

public class printAllPermutationString {

	public static List<String> res;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String word = "well";
		res = new ArrayList<>();
		getAllPermutations(word, "");
		
		for(int i = 0; i< res.size(); i++) {
			System.out.println(i + ": " + res.get(i));
		}

	}
	
	public static void getAllPermutations(String word, String permutations){
		if(word.length() == 0) {
			res.add(permutations);
		}
		
		for(int i = 0 ; i < word.length(); i++) {
			char c = word.charAt(i);
			String newWord = word.substring(0, i)+word.substring(i+1);
			getAllPermutations(newWord, permutations+c);
		}
		
		
		
		
	}

}
