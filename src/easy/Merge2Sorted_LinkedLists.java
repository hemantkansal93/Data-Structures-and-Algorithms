package easy;

public class Merge2Sorted_LinkedLists {

	static class ListNode {
		int data;
		ListNode next;

		ListNode(int d) {
			data = d;
			next = null;
		}
	}

	public static void main(String[] args) {
		/*
		 * Create two linked lists 1st 3->6->9->15->30 2nd 10->15->30 15 is the
		 * intersection point
		 */

		ListNode head1 = new ListNode(5);
		head1.next = new ListNode(10);
		head1.next.next = new ListNode(15);
		head1.next.next.next = new ListNode(40);

		ListNode head2 = new ListNode(2);
		head2.next = new ListNode(3);
		head2.next.next = new ListNode(20);
		
//		Printing list 1
		System.out.println("List 1: ");
		ListNode curr = head1;
		while (curr != null) {
			System.out.print(curr.data + "-->");
			curr = curr.next;
		}
		
//		Printing list 2		
		System.out.println();
		System.out.println("List 2: ");
		curr =head2;
		while (curr != null) {
			System.out.print(curr.data + "-->");
			curr = curr.next;
		}

		ListNode head = sortLinkedLists(head1, head2);

//		Printing sorted list
		System.out.println();
		System.out.println();
		System.out.println("Sorted List:");
		curr = head;
		while (curr != null) {
			System.out.print(curr.data + "-->");
			curr = curr.next;
		}
	}

//	USING MERGE TECHNIQUE from MERGE-SORT METHOD
	private static ListNode sortLinkedLists(ListNode head1, ListNode head2) {
		if (head1 == null)
			return head2;
		if (head2 == null)
			return head1;

		ListNode head = new ListNode(9999);
		ListNode curr = head;
		ListNode curr1 = head1;
		ListNode curr2 = head2;

		while (curr1 != null && curr2 != null) {
			if (curr1.data < curr2.data) {
				curr.next = curr1;
				curr1 = curr1.next;
			}

			else {
				curr.next = curr2;
				curr2 = curr2.next;
			}
			curr = curr.next;
		}

		if (curr1 != null) {
			curr.next = curr1;
		}
		if (curr2 != null) {
			curr.next = curr2;
		}
		return head.next;
	}

}
