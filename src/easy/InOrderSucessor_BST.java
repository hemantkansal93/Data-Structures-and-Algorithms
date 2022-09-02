package easy;

public class InOrderSucessor_BST {
	static int count = 0;
	static int res = -1;
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
		TreeNode root = null;
		TreeNode temp = null;
        root = insert(root, 20);
        root = insert(root, 8);
        root = insert(root, 22);
        root = insert(root, 4);
        root = insert(root, 12);
        root = insert(root, 10);
        root = insert(root, 14);
        temp = root.left.right.right;
        
        TreeNode answer = inOrderSuccessor(root, temp);
        System.out.println("The value of inorder successor of temp node (value = " + temp.val + " ) is " + answer.val);
        
 
	}
	
	private static TreeNode inOrderSuccessor(TreeNode root, TreeNode temp) {
		TreeNode res = null;
		while(root != null) {
			if(temp.val >= root.val) {
				root = root.right;
			}
			else {
				res = root;
				root = root.left;
			}
		}
		return res;
	}

	public static TreeNode insert(TreeNode node, int data)
    {
        /* 1. If the tree is empty, return a new,    
         single node */
        if (node == null) {
            return (new TreeNode(data));
        }
        else {
 
        	TreeNode temp = null;
 
            /* 2. Otherwise, recur down the tree */
            if (data <= node.val) {
                temp = insert(node.left, data);
                node.left = temp;
                temp.parent = node;
            }
            else {
                temp = insert(node.right, data);
                node.right = temp;
                temp.parent = node;
            }
 
            /* return the (unchanged) node pointer */
            return node;
        }
    }

}
