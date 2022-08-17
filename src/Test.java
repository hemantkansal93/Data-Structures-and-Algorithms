import java.util.HashMap;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] inorder = {23, 25, 12, 11, 9, 22};
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        for(int i = 0 ; i < inorder.length; i++){
            hm.put(inorder[i], i);
            }
        
        System.out.println(getVal(hm, 25));
	}
	
	public static int getVal(HashMap hm, int val) {
		return (int) hm.get(val);
	}

}
