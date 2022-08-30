package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Queue;

public class BottomView_BinaryTree {
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		public TreeNode(int val) {
			this.val = val;
		}

	}

	static class TreeNodeCoord {
		TreeNode TreeNode;
		int value;

		public TreeNodeCoord(TreeNode TreeNode, int value) {
			this.TreeNode = TreeNode;
			this.value = value;
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
		
	    List<Integer> res1 = bottomView(root);
		List<Integer> res2 = topView(root);

//	        tree.print_bottom_view(root);
		System.out.println("Bottom view of the given binary tree:");
		for (int i = 0; i < res1.size(); i++) {
			System.out.print(res1.get(i) + "\t");
		}
		System.out.println();
		System.out.println();
		System.out.println("Top view of the given binary tree:");
		for (int i = 0; i < res2.size(); i++) {
			System.out.print(res2.get(i) + "\t");
		}
	}

	public static List<Integer> topView(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		if (root == null) {
			return list;
		}

		HashMap<Integer, TreeNode> hm = new HashMap<>();
		Queue<TreeNodeCoord> q = new LinkedList<>();

		q.add(new TreeNodeCoord(root, 0));

		while (!q.isEmpty()) {
			int size = q.size();

			for (int i = 1; i <= size; i++) {
				TreeNodeCoord TreeNodeCoord = q.remove();
				if (!hm.containsKey(TreeNodeCoord.value))
					hm.put(TreeNodeCoord.value, TreeNodeCoord.TreeNode);

				if (TreeNodeCoord.TreeNode.left != null) {
					q.add(new TreeNodeCoord(TreeNodeCoord.TreeNode.left, (TreeNodeCoord.value - 1)));
				}
				if (TreeNodeCoord.TreeNode.right != null) {
					q.add(new TreeNodeCoord(TreeNodeCoord.TreeNode.right, (TreeNodeCoord.value + 1)));
				}
			}
		}

		for (Entry<Integer, TreeNode> entry : hm.entrySet()) {
			list.add(entry.getValue().val);
		}

		return list;
	}

	public static List<Integer> bottomView(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		if (root == null) {
			return list;
		}

		HashMap<Integer, TreeNode> hm = new HashMap<>();
		Queue<TreeNodeCoord> q = new LinkedList<>();

		q.add(new TreeNodeCoord(root, 0));

		while (!q.isEmpty()) {
			int size = q.size();

			for (int i = 1; i <= size; i++) {
				TreeNodeCoord TreeNodeCoord = q.remove();
				hm.put(TreeNodeCoord.value, TreeNodeCoord.TreeNode);

				if (TreeNodeCoord.TreeNode.left != null) {
					q.add(new TreeNodeCoord(TreeNodeCoord.TreeNode.left, (TreeNodeCoord.value - 1)));
				}
				if (TreeNodeCoord.TreeNode.right != null) {
					q.add(new TreeNodeCoord(TreeNodeCoord.TreeNode.right, (TreeNodeCoord.value + 1)));
				}
			}
		}

		for (Entry<Integer, TreeNode> entry : hm.entrySet()) {
			list.add(entry.getValue().val);
		}

		return list;
	}

//	Incorrect logic
	public void print_bottom_view(TreeNode n) {
		if (n == null) // check whether the TreeNode is null
			return;
		if (n.left == null && n.right == null) // check whether the right and left side of the current TreeNodes are
												// null
		{
			System.out.print(n.val + " ");
		}
		print_bottom_view(n.left);
		print_bottom_view(n.right);
	}

}
