package medium;

import java.util.ArrayList;
import java.util.List;


public class ZigZag_Tree_Traversal {
	static class TreeNode {
		int key;
		TreeNode left;
		TreeNode right;

		TreeNode(int k) {
			key = k;
			left = right = null;
		}
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        
        List<List<Integer>> res = zigZagTraversal(root);
        for(int i = 0 ; i < res.size(); i++) {
        	for( int j = 0 ; j < res.get(i).size(); j++) {
        		System.out.print(res.get(i).get(j) + ",");
        	}
        	System.out.println();
        }
	}

	private static List<List<Integer>> zigZagTraversal(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		if(root == null)
			return result;
		java.util.Stack<TreeNode> curr = new java.util.Stack<>();
		java.util.Stack<TreeNode> next = new java.util.Stack<>();
		boolean leftToRight = true;
		curr.push(root);
		
		List<Integer> temp = new ArrayList<>();
		
		while(!curr.isEmpty()) {
			TreeNode node = curr.pop();
			temp.add(node.key);
			if(leftToRight) {
				if(node.left != null)
					next.push(node.left);
				if(node.right != null)
					next.push(node.right);
			}
			else{
				if(node.right != null)
					next.push(node.right);
				if(node.left != null)
					next.push(node.left);
			}
			
			if(curr.isEmpty()) {
				result.add(new ArrayList<Integer>(temp));
				temp.clear();
				java.util.Stack<TreeNode> t = curr;
				curr = next;
				next = t;
				leftToRight = !leftToRight;
			}
		}
		return result;
	}

}
