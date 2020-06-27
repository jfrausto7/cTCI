package cTCI;

import java.util.HashMap;
import java.util.*;

public class removeDup {
	
	public static Node removeDup(Node head) {
		HashMap<Integer, Integer> nums = new HashMap<Integer, Integer>();
		if(head == null) return null;
		
		Node currNode = head.next;
		Node prevNode = head;
		Node temp;
		
		//initally put head in
		nums.put(head.data, 1);
		
		while(currNode != null) {
			if(nums.containsKey(currNode.data)) {
				prevNode.next = currNode.next;
				temp = currNode;
				currNode = currNode.next;
				temp.next = null;
			}else {
				nums.put(currNode.data, 1);
				prevNode = currNode;
				currNode = currNode.next;
			}
		}
		return head;
	}
	
	public static void displayNodes(Node head) {
		Node n = head;
		while(n.next != null) {
			System.out.print(n.data + "->");
			n = n.next;
		}
		System.out.println(n.data);
	}
	
	
	public static void main(String[] args) {
		Node n = new Node(4);
		n.next = new Node(2);
		n.next.next = new Node(4);
		n.next.next.next = new Node(5);
		n.next.next.next.next = new Node(5);
		n.next.next.next.next.next = new Node(9);
		n.next.next.next.next.next.next = new Node(7);
		n.next.next.next.next.next.next.next = new Node(7);
		
		//print them out
		displayNodes(n);
		
		//remove duplicates
		removeDup(n);
		
		//print again
		displayNodes(n);
		
	}

}
