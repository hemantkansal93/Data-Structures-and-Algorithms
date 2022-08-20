package easy;

public class IntersectingNode_LinkedList {

	static class ListNode {
		int data;
		ListNode next;

		ListNode(int d) {
			data = d;
			next = null;
		}
	}

	public static void main(String[] args) {
		ListNode head1, head2;

		/*
		 * Create two linked lists
		 * 
		 * 1st 3->6->9->15->30 2nd 10->15->30
		 * 
		 * 15 is the intersection point
		 */

		head1 = new ListNode(10);
		head2 = new ListNode(3);

		ListNode newNode = new ListNode(6);
		head2.next = newNode;

		newNode = new ListNode(9);
		head2.next.next = newNode;

		newNode = new ListNode(15);
		head1.next = newNode;
		head2.next.next.next = newNode;

		newNode = new ListNode(30);
		head1.next.next = newNode;

		head1.next.next.next = null;

		ListNode intersectionPoint = getIntersectingNode(head1, head2);

		System.out.println("The value of the intersecting node is " + intersectionPoint.data);
	}

	public static ListNode getIntersectingNode(ListNode headA, ListNode headB) {
		int countA = 0;
		ListNode curr = headA;
		while (curr != null) {
			curr = curr.next;
			countA++;
		}
		int countB = 0;
		curr = headB;
		while (curr != null) {
			curr = curr.next;
			countB++;
		}
		if (countB > countA) {
//			Swapping nodes
			curr = headB;
			headB = headA;
			headA = curr;

//			Swapping counts
			int temp = countA;
			countA = countB;
			countB = temp;
		}

		int diff = countA - countB;

		while (diff > 0) {
			headA = headA.next;
			diff--;
		}

		while (countB > 0) {
			if (headA == headB) {
				return headA;
			}
			headA = headA.next;
			headB = headB.next;
			countB--;
		}

		return null;
	}

}
