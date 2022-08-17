package medium;

public class inorderPredecessorInBST {

		public static void main(String[] args) {
			// Creating BST tree
			Node root = null;
			int[] arr = {12,10,2,19,2,11,21,13,14,500,1};
			for(int i = 0 ; i < arr.length; i++) {
				root = insertNode(arr[i], root);
			}
//			System.out.println(root.value);
			System.out.println(inorderPredecessor(root, 500).value);
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
		
//		Inorder successor
		public static Node inorderPredecessor(Node root, int node) {
			Node res = null;
			while(root != null) {
				if(root.value < node) {
					res =root;
					root = root.right;
				}
				else {
					root= root.left;
				}
			}
			return res;
		}

}