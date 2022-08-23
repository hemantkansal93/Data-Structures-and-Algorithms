package medium;

import java.util.Scanner;

public class Implement_Queue_Using_Stack {

	static java.util.Stack<Integer> st1 = new java.util.Stack<>();
	static java.util.Stack<Integer> st2 = new java.util.Stack<>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
		if (st1.isEmpty() && st2.isEmpty())
			System.out.println("The queue is EMPTY");
		else
			System.out.println("The queue is NOT EMPTY");
	}
	
	public static void peek() {
		if (st1.isEmpty() && st2.isEmpty())
			System.out.println("The queue is EMPTY, can't peek anything");
		else {
			int element= st1.peek();
			System.out.println("The peek element from the queue is " + element);
		}	
	}
	
	public static void dequeue() {
		if (st1.isEmpty() && st2.isEmpty())
			System.out.println("The queue is EMPTY, can't dequeue anything");
		else {
			int element= st1.pop();
			System.out.println("The dequeue element from the queue is " + element);
		}	
	}
	
	public static void enqueue(int num) {
		if (st1.isEmpty() && st2.isEmpty())
			st1.push(num);
		else {
			while(!st1.isEmpty()) {
				st2.push(st1.pop());
			}
			st2.push(num);
			while(!st2.isEmpty()) {
				st1.push(st2.pop());
			}
		}
	}
}
