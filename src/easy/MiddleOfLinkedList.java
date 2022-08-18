package easy;

public class MiddleOfLinkedList {

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

//	Adding nodes to linked list
	public static void pushNode(int data) {
		Node new_node = new Node(data);
		new_node.next = head;
		head = new_node;
	}

//	Driver method to create linked list using nodes and invoking another method to find the middle.
	public static void main(String[] args) {
		int end = 10;
		for (int i = end; i >= 1; i--) {
			pushNode(i);
		}
		Node middle = findMiddleELement(head);
		System.out.println(middle.data);
	}

//	Function to find the middle of the linked list
	private static Node findMiddleELement(Node head) {
		Node curr1 = head;
		Node curr2 = head;
		
		while(curr1 != null && curr1.next != null) {
			curr1 = curr1.next.next;
			curr2 = curr2.next;
		}
		return curr2;
	}
}
