package easy;

public class FirstNodeInLoop_in_LinkedList {

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
		
		// Using 2 pointers
		ListNode node = findLoop(head);
		System.out.println("The value of first node which starts loop is " + node.data);
	}
	
	private static ListNode findLoop(ListNode head) {
		if (head == null || head.next == null)
		    return null;
		ListNode curr1 = head;
        ListNode curr2 = head;
        
        while(curr1 != null && curr1.next !=null){
        	curr1 = curr1.next.next ;
            curr2 = curr2.next;
            if(curr1 == curr2){
                break;
            }
        }

        if(curr1 != curr2) {
        	return null;
        }
        
        curr2 = head;
        while(curr1 != curr2) {
        	curr1 = curr1.next;
        	curr2 = curr2.next;
        }
        return curr1;
	}
}
