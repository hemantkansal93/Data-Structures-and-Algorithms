package easy;

public class noRepeatedChars {

	public static String ns= "";
	public static void checkChars(String s, int index, boolean[] arr) {
		if(index == s.length()) {
			return;
		}
		if(!arr[s.charAt(index) - 'a']) {
			ns += s.charAt(index);
			arr[s.charAt(index) - 'a'] = true;
		}
		checkChars(s,index+1,arr);
	}
	
	
	
	public static void main(String[] args) {
		String s = "aabcssddefea";
		boolean[] arr = new boolean[26];
		checkChars(s, 0, arr);
		System.out.println(ns);
	}
}
