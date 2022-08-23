package easy;

public class RotateLinkedList {

	static class ListNode {
		int data;
		ListNode next;
		ListNode(int d) {
			data = d;
			next = null;
		}
	}
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(6);
		head.next.next.next.next.next.next = new ListNode(7);
		
		System.out.println("** BEFORE ROTATION **");
		
		ListNode curr = head;
		while (curr != null) {
			System.out.print(curr.data + "-->");
			curr = curr.next;
		}
		System.out.print("null");
		
		int k = 12;
		curr = rotateLinkedList(head, k);
		System.out.println();
		System.out.println();
		System.out.println("** AFTER ROTATION **");
		while (curr != null) {
			System.out.print(curr.data + "-->");
			curr = curr.next;
		}
		System.out.print("null");
	}
	
	private static ListNode rotateLinkedList(ListNode head, int k) {
		if(head == null || head.next == null)
			return head;
		ListNode curr = head;
		int count = 0;
		ListNode tail = null;
		while(curr != null) {
			count++;
			tail = curr;
			curr = curr.next;
		}
		
		k %= count;
		
		if(k == 0)
			return head;
		
		curr = head;
		for( int i = 0 ; i < (count-k-1); i++) {
			curr =curr.next;
		}
		
		ListNode temp = curr.next;
		curr.next = null;
		tail.next = head;
		return temp;
	}
}
