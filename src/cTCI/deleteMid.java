package cTCI;

import cTCI.data_structures.Node;

public class deleteMid {
	public static Node deleteMid(Node mid) {
		if(mid == null) return null;
		Node n = mid;
		Node temp;
		
		//iterate through List from this Node forward
		while(n.next.next != null) {
			temp = n;
			temp.data = n.data;
			n.data = n.next.data;
			n = n.next;
			n.next.data = temp.next.next.data;
			n.next = temp.next.next;
			
			
		}
		n.data = n.next.data;
		n.next = null;
		return mid;
	}
	
	//method for displaying and printing nodes
	public static void displayNodes(Node head) {
		Node n = head;
		while(n.next != null) {
			System.out.print(n.data + "->");
			n = n.next;
		}
		System.out.println(n.data);
	}
	
	//driver code
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
		
		//delete mid
		deleteMid(n.next.next.next.next);
		
		//print out again
		displayNodes(n);
		
	

	}
}
