package medium;

import java.util.ArrayList;
import java.util.List;

public class Restore_IP_Adresses {

	public static void main(String[] args) {
		String ip = "25525511135";
		List<String> res = restoreIP(ip);
		for( int i = 0 ; i < res.size(); i++) {
			System.out.println(res.get(i));
		}
	}

	private static List<String> restoreIP(String ip) {
		List<String> res = new ArrayList<>();
		helper(res, ip, "", 0, 0);
		return res;
	}

	private static void helper(List<String> res, String ip, String curr, int count, int index) {
		if(count == 4 && index == ip.length()) {
			res.add(curr.substring(0, curr.length()-1));
			return;
		}
		
		if(count > 4)
			return;
		
		for( int i = index ; i < Math.min(index+3, ip.length()); i++) {
			if(Integer.parseInt(ip.substring(index, i+1)) <256 && (index == i || ip.charAt(index) != '0')){
				helper(res, ip, curr+ ip.substring(index, i+1)+'.', count+1, i+1);
			}
		}
		
	}

}
