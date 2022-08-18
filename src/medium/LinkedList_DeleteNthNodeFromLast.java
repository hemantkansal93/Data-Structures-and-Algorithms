package medium;

public class LinkedList_DeleteNthNodeFromLast {

	static Node head;

	// Node class
	static class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

//		Adding nodes to linked list
	public static void pushNode(int data) {
		Node new_node = new Node(data);
		new_node.next = head;
		head = new_node;
	}

//		Driver method to create linked list using nodes and invoking another method to delete nth node.
//	 Also to print the linked list
	public static void main(String[] args) {
		int end = 10;
		for (int i = end; i >= 1; i--) {
			pushNode(i);
		}
		int n = 4;
		Node curr = deleteNthNodeFromLast(head, n);
		while (curr != null) {
			System.out.print(curr.data + "-->");
			curr = curr.next;
		}
		System.out.print("null");
	}

//	Responsible method for deleting nth node from the last
	private static Node deleteNthNodeFromLast(Node head, int n) {
		
		Node curr1 = head;
		Node curr2 = head;
		
		for(int i = 0; i < n; i++) {
			curr1 = curr1.next;
		}
		
		if(curr1 == null) {
			head = head.next;
		}
		else {
			while(curr1.next != null) {
				curr1 = curr1.next;
				curr2 = curr2.next;
			}
			curr2.next = curr2.next.next;
		}
		return head;
	}
}
