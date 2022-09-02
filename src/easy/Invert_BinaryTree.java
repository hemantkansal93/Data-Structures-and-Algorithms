package easy;

public class Invert_BinaryTree {
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		public TreeNode(int val) {
			this.val = val;
		}

	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(20);
		root.left = new TreeNode(8);
		root.right = new TreeNode(22);
		root.left.left = new TreeNode(5);
		root.left.right = new TreeNode(3);
		root.right.left = new TreeNode(4);
		root.right.right = new TreeNode(25);
		root.left.right.left = new TreeNode(10);
		root.left.right.right = new TreeNode(14);

		TreeNode res = invertTree(root);
		
	}

	private static TreeNode invertTree(TreeNode root) {
		if(root == null)
			return null;
		TreeNode temp = root.left;
		root.left = root.right;
		root.right = temp;
		
		invertTree(root.left);
		invertTree(root.right);
		
		return root;
	}

}
