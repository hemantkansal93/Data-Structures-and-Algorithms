package easy;

public class ReverseLinkedList {
	static class ListNode {
		int data;
		ListNode next;

		ListNode(int d) {
			data = d;
			next = null;
		}
	}

	public static void main(String[] args) {
		ListNode head;
		/*
		 * Create linked list
		 * 3->6->9->15->30 
		 */
		head = new ListNode(3);

		ListNode newNode = new ListNode(6);
		head.next = newNode;

		newNode = new ListNode(9);
		head.next.next = newNode;

		newNode = new ListNode(15);
		head.next.next.next = newNode;

		newNode = new ListNode(30);
		head.next.next.next.next  = newNode;
		
//		Printing LL
		System.out.println("Original LL");
		ListNode curr = head;
		while(curr != null) {
	    	System.out.print(curr.data + "-->");
	    	curr = curr.next;
	    }
		
		curr = reverseLinkedList(head);
		
//		Printing reverse LL
		System.out.println();
		System.out.println();
		System.out.println("Reverse LL");
		while(curr != null) {
	    	System.out.print(curr.data + "-->");
	    	curr = curr.next;
	    }
	}

	private static ListNode reverseLinkedList(ListNode head) {
		ListNode curr =head;
		if(curr == null)
			return null;
		ListNode prev = curr.next;
		curr.next = null;
		
		while(prev != null) {
			ListNode temp = prev.next;
			prev.next = curr;
			curr = prev;
			prev = temp;
		}
		return curr;
	}

}
