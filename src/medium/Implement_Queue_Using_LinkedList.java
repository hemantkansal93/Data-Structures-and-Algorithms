package medium;

import java.util.Scanner;

public class Implement_Queue_Using_LinkedList {

	static ListNode queue = null;
	static ListNode tail = null;

	static class ListNode {
		int data;
		ListNode next;

		ListNode(int d) {
			data = d;
			next = null;
		}
	}

	public static void main(String[] args) {
		doOperation();
	}
	
	private static void doOperation() {
		System.out.println();
		System.out.println("Enter you choice");
		System.out.println("1. Add new element");
		System.out.println("2. Delete element");
		System.out.println("3. Peek");
		System.out.println("4. Is queue empty ?");
		Scanner input = new Scanner(System.in);
		int x = input.nextInt();

		switch (x) {
		case 1:
			int y = input.nextInt();
			enqueue(y);
			doOperation();
		case 2:
			dequeue();
			doOperation();
		case 3:
			peek();
			doOperation();
		case 4:
			isEmpty();
			doOperation();
		case 0:
			break;
		}
		input.close();
		
	}

	public static void isEmpty() {
		if (queue == null)
			System.out.println("The queue is empty");
		else
			System.out.println("The queue is NOT empty");
	}
	
	public static void peek() {
		if (queue == null)
			System.out.println("The queue is empty, can't peek anything");
		else {
			int element = queue.data;
			System.out.println("The peek element is " + element);
		}
	}
	
	public static void dequeue() {
		if (queue == null)
			System.out.println("The queue is empty, can't dequeue anything");
		else {
			int element = queue.data;
			queue = queue.next;
			System.out.println("The dequeue element is " + element);
			if(queue == null)
				tail = queue;
		}
	}
	
	public static void enqueue(int num) {
		if(tail == null) {
			queue = new ListNode(num);
			tail = queue;
		}
		else {
			tail.next = new ListNode(num);
			tail = tail.next;
		}
	}
}
