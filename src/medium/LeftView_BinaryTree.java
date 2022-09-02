package medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeftView_BinaryTree {
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		public TreeNode(int val) {
			this.val = val;
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		TreeNode root = new TreeNode(20);
		root.left = new TreeNode(8);
		root.right = new TreeNode(22);
		root.left.left = new TreeNode(5);
		root.left.right = new TreeNode(3);
		root.right.left = new TreeNode(4);
		root.right.right = new TreeNode(25);
		root.left.right.left = new TreeNode(10);
		root.left.right.right = new TreeNode(14);
		
		List<Integer> lv = leftView(root);
		List<Integer> rv = rightView(root);
		
		System.out.println("The right view of the given tree is as below: ");
		for (int i = 0; i < rv.size(); i++) {
			System.out.print(rv.get(i) + "\n");
		}
		System.out.println();
		System.out.println("The left view of the given tree is as below: ");
		for (int i = 0; i < lv.size(); i++) {
			System.out.print(lv.get(i) + "\n");
		}
		
	}

	private static List<Integer> rightView(TreeNode root) {
		List<Integer> rv = new ArrayList<>();
		if(root == null) {
			return rv;
		}
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		
		while(!q.isEmpty()) {
			int size = q.size();
			for( int i = 0 ; i < size; i++) {
				TreeNode node = q.remove();
				if(i == size-1) {
					rv.add(node.val);
				}
				if( node.left != null) {
					q.add(node.left);
				}
				if(node.right != null) {
					q.add(node.right);
				}
			}
		}
		return rv;
	}

	private static List<Integer> leftView(TreeNode root) {
		List<Integer> lv = new ArrayList<>();
		if(root == null) {
			return lv;
		}
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		
		while(!q.isEmpty()) {
			int size = q.size();
			for( int i = 0 ; i < size; i++) {
				TreeNode node = q.remove();
				if(i == 0) {
					lv.add(node.val);
				}
				if( node.left != null) {
					q.add(node.left);
				}
				if(node.right != null) {
					q.add(node.right);
				}
			}
		}
		return lv;
	}

}
