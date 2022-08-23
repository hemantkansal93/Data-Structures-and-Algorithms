package medium;

public class Flatten_BinaryTree_to_LinkedList {

	static class TreeNode {
	    int data;
	    TreeNode left, right;
	    TreeNode(int key)
	    {
	        data = key;
	        left = right = null;
	    }
	}
	public static void main(String[] args) {
		TreeNode root;
		root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(6);
        System.out.println(" ** BEFORE FLATTENING **");
		inorderTraversal(root);

        flatten(root);
        System.out.println();
        System.out.println();
        System.out.println(" ** AFTER FLATTENING **");
        inorderTraversal(root);
	}
	
	public static void flatten(TreeNode root) {
		if( root == null || (root.left == null && root.right == null))
			return;
		if(root.left != null) {
			flatten(root.left);
			
			TreeNode temp = root.right;
			root.right = root.left;
			root.left = null;
			
			TreeNode tail = root.right;
			while(tail.right != null) {
				tail = tail.right;
			}
			tail.right= temp;
		}
		flatten(root.right);
	}
	
	public static void inorderTraversal(TreeNode root) {
		if( root == null)
			return;
		
		inorderTraversal(root.left);
		System.out.print(root.data + "-->");
		inorderTraversal(root.right);
	}

}
