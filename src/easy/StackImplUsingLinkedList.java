package easy;

class LLNode{
	int val;
	LLNode next;
	
	public LLNode (int val) {
		this.val = val;
	}
	
}

class Stack{
	LLNode head = null;
	
//	push
	public void push(int data) {
		if(head == null) {
			head = new LLNode(data);
		}
		else {
			LLNode node = new LLNode(data);
			node.next = head;
			head = node;
		}
	}
	
//	is Empty ?
	public boolean isEmpty() {
		return head == null;
	}
	
	
//	pop
	public int pop() {
		if(head == null)
			return -1;
		int pop = head.val;
		head = head.next;
		return pop;
	}
	
//	peek
	public int peek() {
		if(head == null)
			return -1;
		return head.val;
	}
}


public class StackImplUsingLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack s = new Stack();
		s.push(10);
		s.push(14);
		s.push(12);
		s.push(8);
		
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.peek());
		System.out.println(s.pop());
		System.out.println(s.pop());
		
		

	}

}
