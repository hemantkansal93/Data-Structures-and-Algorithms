package medium;

public class DeepCopy_LinkedList_RandomPointers {

	 static class ListNode {
	        int data;
	        ListNode next;
	        ListNode random;
	        ListNode(int d)
	        {
	            data = d;
	            next = null;
	            random = null;
	        }
	    }
	 
	public static void main(String[] args) {
		// Creating a linked list with random pointer
		ListNode head = new ListNode(1);
	    head.next = new ListNode(2);
	    head.next.next = new ListNode(3);
	    head.next.next.next = new ListNode(4);
	    head.next.next.next.next = new ListNode(5);
	    head.random = head.next.next;
	    head.next.random = head;
	    head.next.next.random = head.next.next.next.next;
	    head.next.next.next.random = head.next.next;
	    head.next.next.next.next.random = head.next;
	    
	    ListNode res = copyLinkedList(head);
	    ListNode curr =res;
	    System.out.println("Next pointers: ");
	    while(curr != null) {
	    	System.out.print(curr.data + "-->");
	    	curr = curr.next;
	    }
	    
	    curr =res;
	    System.out.println();
	    System.out.println();
    	System.out.println("Random pointers: ");
	    while(curr != null) {
	    	System.out.println(curr.data + "-->" + curr.random.data);
	    	curr = curr.next;
	    }
	}

//	TRICK: Use 3 while loops
//	Diffuse new nodes between older nodes
//	break (.next) connections of olders nodes and assign them to new nodes
//	Define random pointers for new nodes using random.next of old node.
//	Now, again break the next pointers of all nodes and assign them to
//	the required and original linked list nodes.
	private static ListNode copyLinkedList(ListNode head) {
		ListNode curr = head;
//		Edge case
		if(curr == null) {
			return curr;
		}
		
//		Breaking next pointers of existing LL
//		Diffusing new copied nodes in between existing nodes
		while(curr != null) {
			ListNode temp = curr.next;
			ListNode newNode = new ListNode(curr.data);
			curr.next = newNode;
			newNode.next = temp;
			curr = temp;
		}
		
//		Assigning random pointers
		curr = head;
		while(curr != null) {
			if(curr.random == null)
				curr.next.random = null;
			else
				curr.next.random = curr.random.next;
			curr = curr.next.next;
		}
		
//		Re-assigning next pointers for the original and required linked list
		curr = head;
		ListNode res = curr.next;
		while(curr != null) {
			ListNode temp = curr.next;
			if (curr.next != null)
				curr.next = curr.next.next;
			curr = temp;
		}
		return res;
	}
}
