package medium;



public class inorderSuccessorInBST {

	public static void main(String[] args) {
		// Creating BST tree
		Node root = null;
		int[] arr = {12,10,2,19,2,11,21,13,14,500,1};
		for(int i = 0 ; i < arr.length; i++) {
			root = insertNode(arr[i], root);
		}
//		System.out.println(root.value);
		System.out.println(inorderSuccessor(root, 9).value);
	}
	
	
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
	
//	Inorder successor
	public static Node inorderSuccessor(Node root, int node) {
		Node res = null;
		while(root != null) {
			if(root.value <= node) {
				root = root.right;
			}
			else {
				res= root;
				root= root.left;
			}
		}
		return res;
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