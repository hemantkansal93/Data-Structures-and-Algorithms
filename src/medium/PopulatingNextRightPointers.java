package medium;

public class PopulatingNextRightPointers {

	static class Node1{
		int value;
		Node1 left;
		Node1 right;
		Node1 next;
		public Node1(int val) {
			this.value = val;
			this.next = null;
		}
	}
		
	public static void main(String[] args) {
		
//		Creating tree
		Node1 root = new Node1(10);
        root.left = new Node1(8);
        root.right = new Node1(2);
        root.left.left = new Node1(3);
        root.right.right = new Node1(90);
        root.left.right = new Node1(35);
        root.right.left = new Node1(95);
        
        populateRightPointers(root);
        
//		Printing full tree
		inorder(root);
        
	}

	
//	responsible method for populating right pointers to each node of the tree
	private static void populateRightPointers(Node1 root) {
		if(root == null)
			return;
		
		Node1 curr = root;
//		Traversing along the height of the tree
		while(curr.left != null) {
			Node1 next = curr.left;
			
//			Traversing along the breadth of the tree(same level) 
			while(curr != null) {
				curr.left.next = curr.right;
				if(curr.next == null)
					curr.right.next = null;
				else
					curr.right.next = curr.next.left;
				curr= curr.next;
			}
			curr = next;
		}
	}
	
//	 Only purpose for printing tree
	public static void inorder(Node1 node) {
		if (node == null)
			return;
		inorder(node.left);
		int v = node.next == null?-1:node.next.value;
		System.out.printf("%d ", v);
		inorder(node.right);
	}
}
