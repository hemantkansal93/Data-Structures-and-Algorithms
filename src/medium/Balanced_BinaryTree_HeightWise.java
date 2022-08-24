package medium;

public class Balanced_BinaryTree_HeightWise {

	static class TreeNode {
	    int key;
	    TreeNode left;
	    TreeNode right;
	    TreeNode(int k)
	    {
	        key = k;
	        left = right = null;
	    }
	}
	public static void main(String[] args) {
		TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(30);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(20);
//      root.right.right.right = new TreeNode(21);
        
        int height = balanced(root);
        if(height == -1)
        	System.out.println("Binary Tree is NOT height balanced");
        else
        	System.out.println("Binary Tree is height balanced with height = " + height);

	}
	private static int balanced(TreeNode root) {
		if(root == null)
			return 0;
		int lh = balanced(root.left);
		if(lh == -1)
			return -1;
		int rh = balanced(root.right);
		if(rh == -1)
			return -1;
		if(Math.abs(rh-lh) > 1)
			return -1;
		return 1 + Math.max(lh, rh);
	}

}
