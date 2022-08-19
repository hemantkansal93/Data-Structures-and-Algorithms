package easy;

public class Merge2BinaryTrees {

	public static void main(String[] args) {

// Creating 2 binary trees
		Node root1 = new Node(1);
		root1.left = new Node(2);
		root1.right = new Node(3);
		root1.left.left = new Node(4);
		root1.left.right = new Node(5);
		root1.right.right = new Node(6);

		Node root2 = new Node(4);
		root2.left = new Node(1);
		root2.right = new Node(7);
		root2.left.left = new Node(3);
		root2.right.left = new Node(2);
		root2.right.right = new Node(6);

		Node root = mergeBinaryTrees(root1, root2);

//		Printing full tree
		inorder(root);
	}

//	Responsible method to merge 2 binary trees
	private static Node mergeBinaryTrees(Node root1, Node root2) {
		if (root1 == null)
			return root2;
		if (root2 == null)
			return root1;

		Node root = new Node(root1.value + root2.value);

		root.left = mergeBinaryTrees(root1.left, root2.left);
		root.right = mergeBinaryTrees(root1.right, root2.right);

		return root;
	}

//	 Only purpose for printing tree
	public static void inorder(Node node) {
		if (node == null)
			return;
		inorder(node.left);
		System.out.printf("%d ", node.value);
		inorder(node.right);
	}

}
