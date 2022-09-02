package medium;

public class KthLargest_BST {

	static int count = 0;
	static int res = -1;
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		public TreeNode(int val) {
			this.val = val;
		}

	}
	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(1);
		root.right = new TreeNode(4);
		root.left.right = new TreeNode(2);
		
		int k = 2;
		kthLargest(root, k);
		System.out.println("The kth largest value of given BST is " + res + " where k = " + k);

	}
	private static void kthLargest(TreeNode root, int k) {
		if(root == null || count >= k)
			return;
		kthLargest(root.right, k);
		count++;
		if(count == k ) {
			res = root.val;
			return;
		}
		kthLargest(root.left, k);
	}

}
