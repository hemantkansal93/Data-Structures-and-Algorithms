package medium;

public class LowestCommonAncestor_BST {
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
		
		TreeNode p = root.right;
		TreeNode q = root.left.right;
		
		TreeNode node = lca(root, p ,q);
		System.out.println("The value of lowest common ancestor for node:" + p.val + " and node:" + q.val + " is " + node.val);

	}
	private static TreeNode lca(TreeNode root, TreeNode p, TreeNode q) {
		if(root == null)
			return root;
		if(root.val > p.val && root.val > q.val) {
			return lca(root.left, p , q);
		}
		if(root.val < p.val && root.val < q.val) {
			return lca(root.right, p , q);
		}
		return root;
	}

}
