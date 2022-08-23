package easy;

import easy.RotateLinkedList.ListNode;

public class Adding_1_to_LinkedList {

	// Node class
	static class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(9);
		head.next = new ListNode(9);
		head.next.next = new ListNode(5);
		head.next.next.next = new ListNode(9);
		
		System.out.println("** BEFORE ADDITION **");
		ListNode curr = head;
		while (curr != null) {
			System.out.print(curr.data + "-->");
			curr = curr.next;
		}
		System.out.print("null");

		curr =add1(head);
		
//		Printing sorted list
		System.out.println();
		System.out.println();
		System.out.println("** AFTER ADDITION **");
		while (curr != null) {
			System.out.print(curr.data + "-->");
			curr = curr.next;
		}
		System.out.print("null");
	}

	private static ListNode add1(ListNode head) {
		if(head == null)
			return head;
		ListNode curr = head;
		ListNode temp = head;
		boolean flag = true;
		while(curr != null) {
			if(curr.data != 9)
				temp = curr;
			curr =curr.next;
		}
		ListNode newNode = new ListNode(1);
		if(temp == head && head.data == 9) {
			head.data = 0;
			newNode.next = head;
			flag =false;
		}
		else{
			temp.data += 1;
		}
		curr = temp.next;
		while(curr != null) {
			curr.data = 0;
			curr = curr.next;
		}
		return flag?head:newNode;
	}

}
