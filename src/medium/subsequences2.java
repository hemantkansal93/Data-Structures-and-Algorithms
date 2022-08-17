package medium;

import java.util.HashSet;

public class subsequences2 {
	static HashSet<String> hs = new HashSet<>(); 
	
	public static void getSubsequence(String s, int index, String ns){
		if(index == s.length()) {
			if(!hs.contains(ns)) {
				System.out.println(ns);
			}
			hs.add(ns);
			return;
		}
		
		// without new character
		getSubsequence(s,index+1,ns);
		
		//with new character
		ns+= s.charAt(index);	
		getSubsequence(s,index+1,ns);
		
	}
	
	
	public static void main(String[] args) {
		String s  = "aaa";
		getSubsequence(s, 0,"");
	}

}
