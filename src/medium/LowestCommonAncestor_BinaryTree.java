package medium;

public class LowestCommonAncestor_BinaryTree {
	static class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		
		public TreeNode(int val) {
			this.val = val;
		}
	}
	public static void main(String[] args) {
		TreeNode root1 = new TreeNode(1);
		root1.left = new TreeNode(2);
		root1.right = new TreeNode(3);
		root1.left.left = new TreeNode(4);
		root1.left.right = new TreeNode(5);
		root1.right.left = new TreeNode(6);
		
		TreeNode node = lca(root1, root1.right.left, root1.left);
		System.out.println("The value of lowest common ancestor of two given nodes in a tree is "+ node.val);
	}
	private static TreeNode lca(TreeNode root, TreeNode p, TreeNode q) {
		if(root == null)
			return root;
		if(root == p || root ==q)
			return root;
		
		TreeNode left = lca(root.left, p , q);
		TreeNode right = lca(root.right, p ,q);
		
		if(left == null && right == null)
			return null;
		if(left != null && right != null)
			return root;
		
		return left==null?right:left;
	}

}
