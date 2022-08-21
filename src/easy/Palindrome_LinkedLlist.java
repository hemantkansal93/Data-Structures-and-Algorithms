package easy;

public class Palindrome_LinkedLlist {

	static class ListNode {
		int data;
		ListNode next;

		ListNode(int d) {
			data = d;
			next = null;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ListNode head;
		/*
		 * Create linked list
		 * 3->6->9->6->3
		 */
		head = new ListNode(3);

		ListNode newNode = new ListNode(6);
		head.next = newNode;

		newNode = new ListNode(9);
		head.next.next = newNode;

		newNode = new ListNode(6);
		head.next.next.next = newNode;

		newNode = new ListNode(3);
		head.next.next.next.next  = newNode;
		
		boolean result = isPalindrome(head);
		
		System.out.println("Is the given linked list palindrome? " + result);		
	}
	
	
	private static boolean  isPalindrome(ListNode head) {
		ListNode curr = head;
		java.util.Stack<Integer> st = new java.util.Stack<>();
		
		while(curr != null) {
			st.push(curr.data);
			curr = curr.next;
		}
		curr = head;
		while(curr != null) {
			int nodeVal = st.pop();
			if(curr.data != nodeVal) {
				return false;
			}
			curr = curr.next;
		}
		return true;
	}
}
