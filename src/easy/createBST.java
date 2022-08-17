package easy;

public class createBST {
	public static Node root = null;
	public static Node insertNode(int val , Node root) {
		if(root == null) {
			root = new Node(val);
			return root;
		}
		if(val < root.value)
			root.left = insertNode(val, root.left);
		else
			root.right = insertNode(val, root.right);
		
		return root;
	}

	public static void main(String[] args) {
		int[] arr = {12,10,2,19,2,11,21,13,14,500,1};
		for(int i = 0 ; i < arr.length; i++) {
			root = insertNode(arr[i], root);
		}
		inorder(root);
	}
	
	public static void inorder(Node root) {
		if(root == null) {
			return;
		}
		inorder(root.left);
		System.out.println(root.value);
		inorder(root.right);
	}
}

class Node{
	int value;
	Node left;
	Node right;
	public Node(int val) {
		this.value = val;
	}
}
