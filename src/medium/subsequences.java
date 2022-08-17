package medium;


public class subsequences {

//	static List<String> res = new ArrayList<>();
	
	public static void getSubsequence(String s, int index, String ns){
		if(index == s.length()) {
			System.out.println(ns);
			return;
		}
		
		// without new character
		getSubsequence(s,index+1,ns);
		
		//with new character
		ns+= s.charAt(index);	
		getSubsequence(s,index+1,ns);
		
	}
	
	
	public static void main(String[] args) {
		String s  = "abc";
		getSubsequence(s, 0,"");
	}

}
