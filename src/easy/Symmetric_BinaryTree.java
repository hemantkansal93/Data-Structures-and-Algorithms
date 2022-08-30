package easy;

public class Symmetric_BinaryTree {

	static class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		
		public TreeNode(int val) {
			this.val = val;
		}
	}
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(2);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(4);
		root.right.left = new TreeNode(4);
		root.right.right = new TreeNode(3);
		
		boolean answer = isMirror(root, root);
		System.out.println("Is given tree symmetric (mirror around root node)? " + answer);

	}
	private static boolean isMirror(TreeNode node1, TreeNode node2) {
		if(node1 == null && node2 == null)
			return true;
		
		if(node1 != null && node2 != null) {
			return node1.val ==node2.val && isMirror(node1.left, node2.right) && isMirror(node1.right, node2.left);
		}
		return false;
	}
}
