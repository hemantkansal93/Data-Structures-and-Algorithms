package easy;

public class searchBST {
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
	
	public static boolean search( Node root, int key) {
		if(root == null) {
			return false;
		}
		if(key == root.value)
			return true;
		
		else if(key<root.value) {
			return search(root.left, key);
		}
		else{
			return search(root.right, key);
		}
	}
	
	

	public static void main(String[] args) {
		int[] arr = {12,10,2,19,2,11,21,13,14,500,1};
		Node root = null;
		for(int i = 0 ; i < arr.length; i++) {
			root = insertNode(arr[i], root);
		}
		int key = 500; 
		System.out.println(search(root, key));
	}

}


