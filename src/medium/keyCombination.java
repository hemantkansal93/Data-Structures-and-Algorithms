package medium;

public class keyCombination {

	public static String[] keys = {"0","1", "abc","def","ghi", "jkl","mno","pqrs","tuv","wxyz"};
	
	public static void printCombinations(String s, int index, String ns) {
		if(index == s.length()) {
			System.out.println(ns);
			return;
		}
		
		String key = keys[s.charAt(index) - '0'];
		
		for(int i = 0 ; i <key.length(); i++) {
			printCombinations(s,index+1, ns+key.charAt(i));
		}
		
		
	}
	public static void main(String[] args) {
		String s = "7";
		printCombinations(s, 0, "");
	}

}
