package medium;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Implement_Stack_Using_Queue {

	static Queue<Integer> q = new LinkedList<>();
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
			push(y);
			doOperation();
		case 2:
			pop();
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
	private static void isEmpty() {
		System.out.println("Is stack empty? :" + q.isEmpty());
	}
	private static void peek() {
		if(q.isEmpty())
			System.out.println("The stack is empty, nothing to peek.");
		else {
			int element = q.peek();
			int size = q.size();
			while (size != 0) {
				element = q.remove();
				q.add(element);
				size--;
			}
			System.out.println("The peek element is "+ element);
		}
		
		
	}
	private static void pop() {
		if(q.isEmpty())
			System.out.println("The stack is empty, nothing to pop.");
		else {
			int element = q.peek();
			for( int i = 0 ; i < q.size()-1; i++) {
				element = q.remove();
				q.add(element);
			}
			System.out.println("The peek element is "+ q.remove());
		}
		
	}
	private static void push(int y) {
		q.add(y);
	}

}
