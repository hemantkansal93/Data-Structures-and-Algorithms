import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Queue;

class Node{
	int val;
	Node left;
	Node right;
	
	public Node(int val) {
		this.val = val;
	}
	
}

class NodeCoord{
	Node node;
	int value;
	
	public NodeCoord(Node node, int value){
		this.node = node;
		this.value = value;
	}
}


public class BottomViewBinaryTree {

	 Node root; //root node of tree
	  
	    // Default constructor
	    public BottomViewBinaryTree() {}
	  
	    // Parameterized tree constructor
	    public BottomViewBinaryTree(Node node)
	    {
	        root = node;
	    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 Node root = new Node(20);
	        root.left = new Node(8);
	        root.right = new Node(22);
	        root.left.left = new Node(5);
	        root.left.right = new Node(3);
	        root.right.left = new Node(4);
	        root.right.right = new Node(25);
	        root.left.right.left = new Node(10);
	        root.left.right.right = new Node(14);
	        BottomViewBinaryTree tree = new BottomViewBinaryTree(root);
	        System.out.println("Bottom view of the given binary tree:");
//	        List<Integer> res = tree.bottomView(root);
	        List<Integer> res = tree.topView(root);

//	        tree.print_bottom_view(root);
	        for(int i = 0 ; i< res.size(); i++) {
	        	System.out.print(res.get(i) +"\t");
	        }
	}
	
	public List<Integer> topView(Node root){
		List<Integer> list = new ArrayList<>();
		if(root == null) {
			return list;
		}
		
		HashMap<Integer, Node> hm = new HashMap<>();
		Queue<NodeCoord> q = new LinkedList<>();
		
		q.add(new NodeCoord(root, 0));
		
		while(!q.isEmpty()) {
			int size = q.size();
			
			for(int i = 1 ; i <= size; i++) {
				NodeCoord nodeCoord = q.remove();
				if(!hm.containsKey(nodeCoord.value))
					hm.put(nodeCoord.value, nodeCoord.node);
				
				if(nodeCoord.node.left != null) {
					q.add(new NodeCoord(nodeCoord.node.left, (nodeCoord.value -1)));
				}
				if(nodeCoord.node.right != null) {
					q.add(new NodeCoord(nodeCoord.node.right, (nodeCoord.value +1)));
				}
			}
		}
		
		for(Entry<Integer, Node> entry: hm.entrySet()) {
			list.add(entry.getValue().val);
		}
		
		
		return list;
	}
	
	public List<Integer> bottomView(Node root){
		List<Integer> list = new ArrayList<>();
		if(root == null) {
			return list;
		}
		
		HashMap<Integer, Node> hm = new HashMap<>();
		Queue<NodeCoord> q = new LinkedList<>();
		
		q.add(new NodeCoord(root, 0));
		
		while(!q.isEmpty()) {
			int size = q.size();
			
			for(int i = 1 ; i <= size; i++) {
				NodeCoord nodeCoord = q.remove();
				hm.put(nodeCoord.value, nodeCoord.node);
				
				if(nodeCoord.node.left != null) {
					q.add(new NodeCoord(nodeCoord.node.left, (nodeCoord.value -1)));
				}
				if(nodeCoord.node.right != null) {
					q.add(new NodeCoord(nodeCoord.node.right, (nodeCoord.value +1)));
				}
			}
		}
		
		for(Entry<Integer, Node> entry: hm.entrySet()) {
			list.add(entry.getValue().val);
		}
		
		
		return list;
	}
	
//	Incorrect logic
	public void print_bottom_view(Node n) {
		 if(n==null) //check whether the node is null
		       return;
		     if(n.left==null && n.right==null) // check whether the right and left side of the current nodes are null
		     {
		       System.out.print(n.val+" ");
		     }
		     print_bottom_view(n.left); 
		     print_bottom_view(n.right);
	}

}
