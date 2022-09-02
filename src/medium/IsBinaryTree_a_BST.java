package medium;


public class IsBinaryTree_a_BST {
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode parent;

		public TreeNode(int val) {
			this.val = val;
		}

	}
	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(1);
		root.right = new TreeNode(4);
		root.left.right = new TreeNode(2);
		
		boolean answer = isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
		
		System.out.println("Is the given binary tree a BST? " + answer);
	}
	private static boolean isValidBST(TreeNode root, int min, int max) {
		if(root == null) {
			return true;
		}
		if(root.val > max || root.val < min) {
			return false;
		}
		return isValidBST(root.left, min, root.val -1) && isValidBST(root.right, root.val +1, max);
	}

}
