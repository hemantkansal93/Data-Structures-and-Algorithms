package medium;

import java.util.Scanner;

public class Implement_Queue_Using_Array {
	static int n = 5;
	static int[] queue= new int[n];
	static int front = -1;
	static int rear = -1;
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
		System.out.println("5. Is queue full ?");
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
		case 5:
			isFull();
			doOperation();
		case 0:
			break;
		}
		input.close();
		
	}

	public static void isEmpty() {
		if (front == -1 )
			System.out.println("The queue is empty");
		else
			System.out.println("The queue is NOT empty");
	}
	
	public static void isFull() {
		if (rear == n-1)
			System.out.println("The queue is FULL");
		else
			System.out.println("The queue is NOT FULL");
	}
	
	public static void enqueue(int num) {
		if(rear == n-1)
			System.out.println("The queue is ALREADY FULL, can't add more elements");
		else {
			if(front == -1) {
				front++;
			}
			rear++;
			queue[rear] = num;

		}
	}
	
	public static void dequeue() {
		if(front == -1) {
			System.out.println("The queue is ALREADY empty, nothing to dequeue");
		}
		else {
			int element = queue[front];
			System.out.println("The dequeue element is " + element);
			if(rear == front)
				rear = front = -1;
			else
				front++;
		}
	}
	
	public static void peek(){
		if(front == -1) {
			System.out.println("The queue is ALREADY empty, nothing to peek");
		}
		else
			System.out.println("The peek element is " + queue[front]);
	}

}
