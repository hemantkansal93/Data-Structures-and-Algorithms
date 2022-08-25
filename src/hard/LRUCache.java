package hard;

import java.util.HashMap;

public class LRUCache {

	static class Node{
		int key;
		int value;
		Node next;
		Node prev;
		
		public Node(int key, int value) {
			this.key = key;
			this.value = value;
		}
	}
	
	static int capacity;
	static int count;
	static HashMap<Integer, Node> hm;
	static Node head;
	static Node tail;
	
	public static void main(String[] args) {
		capacity = 2;
		count = 0;
		head = new Node(-2,-2);
		tail = new Node(-2,-2);
		head.next = tail;
		head.prev = null;
		tail.next = null;
		tail.prev = head;
		hm = new HashMap<>();
		
//		Operations
		add(1,1);
		add(2,2);
		System.out.println(get(1));
		add(3,3);
		System.out.println(get(2));
		add(4,4);
		System.out.println(get(1));
		System.out.println(get(3));
		System.out.println(get(4));
	}
	
	public static void addNodeToHead(Node node) {
		head.next.prev = node;
		node.next = head.next;
		node.prev= head;
		head.next = node;
	}
	
	public static void deleteNode(Node node) {
		node.next.prev = node.prev;
		node.prev.next = node.next;
	}
	
	public static void add(int key, int val) {
		if(hm.get(key) != null) {
			Node node = hm.get(key);
			node.value = val;
			hm.put(key, node);
			deleteNode(node);
			addNodeToHead(node);
		}
		else {
			Node newNode = new Node(key, val);
			if(count == capacity) {
				Node node = tail.prev;
				deleteNode(node);
				hm.remove(node.key);
			}
			else {
				count++;
			}
			hm.put(key, newNode);
			addNodeToHead(newNode);
		}
	}
	public static int get(int key) {
		if(hm.get(key) != null) {
			Node node = hm.get(key);
			deleteNode(node);
			addNodeToHead(node);
			return node.value;
		}
		else {
			return -1;
		}
	}
}
