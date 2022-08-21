package easy;

import java.util.HashSet;

import easy.Palindrome_LinkedLlist.ListNode;

public class Loop_in_LinkedList {

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
		// Create a loop for testing(5 is pointing to 3) /
		head.next.next.next.next.next = head.next.next;

//		3 different methods to find a loop in LL
		// Using Hashset
		boolean result1 = isLoop1(head);
		
		// Using 2 pointers
		boolean result2 = isLoop2(head);
		
		//Using next pointer of each node in thLL as flag
		boolean result3 = isLoop3(head);
		System.out.println("Is loop present in the given linked list? " + result1);
		System.out.println("Is loop present in the given linked list? " + result2);
		System.out.println("Is loop present in the given linked list? " + result3);
	}

	// Using Hashset
	private static boolean isLoop1(ListNode head) {
		HashSet<ListNode> hs = new HashSet<>();
		ListNode curr = head;
		while (curr != null) {
			if (hs.contains(curr))
				return true;
			hs.add(curr);
			curr = curr.next;
		}
		return false;
	}
	
	// Running two linked list one slow and other fast
	// If there is a loop, both would meet and would be equal
	private static boolean isLoop2(ListNode head) {
		ListNode curr1 = head;
        ListNode curr2 = head;
        
        while(curr1 != null && curr1.next !=null){
            curr1 = curr1.next.next ;
            curr2 = curr2.next;
            if(curr1 == curr2){
                return true;
            }
        }
        return false;
	}
	
	// Using next pointer of the linked list as flag
	// While traversal through each node, make next pointer of each node to some temp node
	// If there is loop, the next pointer of the node would match temp node
	private static boolean isLoop3(ListNode head) {
		 ListNode curr = head;
         ListNode temp = new ListNode(99);
         while(curr != null){
             if(curr.next == temp)
                 return true;
             ListNode temp1 = curr.next;
             curr.next = temp;
             curr = temp1;
         }
         return false;
	}
}
