package hard;


public class MaximumPathSum_BinaryTree {

	static class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		
		public TreeNode(int val) {
			this.val = val;
		}
	}
	
	static int max = Integer.MIN_VALUE;
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(-8);
		root.left.right = new TreeNode(5);
		root.right.right = new TreeNode(6);
		
		int maxSum = maxPathSum(root);
		System.out.println("The maximum path sum of the given binary tree is " + maxSum);

	}


	private static int maxPathSum(TreeNode root) {
		if(root == null)
			return 0;
		int l = maxPathSum(root.left);
		int r = maxPathSum(root.right);
		
		int maxSingle = Math.max(Math.max(l, r) , 0) + root.val;
		int maxTop = Math.max(maxSingle, l + r + root.val);
		max = Math.max(max, maxTop);
		return maxSingle;
	}
}
