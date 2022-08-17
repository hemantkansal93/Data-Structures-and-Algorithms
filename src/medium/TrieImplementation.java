package medium;

import java.util.HashMap;
import java.util.Scanner;

public class TrieImplementation {
	
	public static TrieNode root;
	public TrieImplementation() {
		root = new TrieNode();
	}
	
	
	public void insert(String word) {
		TrieNode curr = root;
		for(int i = 0 ; i < word.length(); i++) {
			char c = word.charAt(i);
			TrieNode node = curr.children.get(c);
			if(node == null) {
				node = new TrieNode();
				curr.children.put(c, node);
			}
			curr = node;
		}
		curr.isWord = true;
	}
	
	public boolean search (String word) {
		TrieNode curr = root;
		for(int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			TrieNode node = curr.children.get(c);
			if(node == null) {
				return false;
			}
			curr =node;
		}
		return curr.isWord;
	}
	
	public boolean startsWith(String word) {
		TrieNode curr = root;
		for(int i = 0 ; i < word.length(); i++) {
			char c = word.charAt(i);
			TrieNode node = curr.children.get(c);
			if(node == null) {
				return false;
			}
			curr = node;
		}
		return true;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TrieImplementation ti = new TrieImplementation();
		Scanner sc = new Scanner(System.in);
	
		ti.insert("Hemant");
		ti.insert("HemantKansal");
		ti.insert("Hem");
		ti.insert("Shubh");
		ti.insert("Hemant Kans");
		ti.insert("Shubham");
		System.out.print("Enter the word: ");
		String word = sc.nextLine();
		System.out.println(ti.search(word));
		System.out.println(ti.startsWith(word));
		sc.close();

	}
}

class TrieNode{
	HashMap<Character, TrieNode> children;
	boolean isWord;
	public TrieNode() {
		children = new HashMap<>();
		isWord = false;
	}
}



