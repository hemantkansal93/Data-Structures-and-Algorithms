package medium;

import java.util.Scanner;

public class Implement_Min_Stack {

	static java.util.Stack<Integer> st = new java.util.Stack<>();
	static java.util.Stack<Integer> minSt = new java.util.Stack<>();
	
	public static void main(String[] args) {
		doOperation();
	}
	private static void doOperation() {
		System.out.println();
		System.out.println("Enter you choice");
		System.out.println("1. Add new element");
		System.out.println("2. Delete element");
		System.out.println("3. Peek");
		System.out.println("4. Get minimum?");
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
			getMinimum();
			doOperation();
		case 0:
			break;
		}
		input.close();
		
	}
	private static void getMinimum() {
		if(st.isEmpty())
			System.out.println("The stack is empty, nothing for minimum value.");
		else {
			System.out.println("The minimum element in the stack is :" + minSt.peek());
		}
		
	}
	private static void peek() {
		if(st.isEmpty())
			System.out.println("The stack is empty, nothing to peek.");
		else {
			System.out.println("The peek element is "+ st.peek());
		}
	}
	
	private static void pop() {
		if(st.isEmpty())
			System.out.println("The stack is empty, nothing to pop.");
		else {
			minSt.pop();
			System.out.println("The pop element is "+ st.pop());
		}
	}
	private static void push(int y) {
		st.push(y);
		if(minSt.isEmpty())
			minSt.push(y);
		else {
			int minVal = Math.min(y, minSt.peek());
			minSt.push(minVal);
		}
	}

}
