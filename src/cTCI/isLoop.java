package cTCI;

import java.util.HashMap;

public class isLoop {
	public static Node isLoop(Node head) {
		HashMap<Node, Integer> nodes  = new HashMap<Node, Integer>();
		
		while(head != null) {
			if(nodes.containsKey(head)) return head;
			
			nodes.put(head,1);
			head = head.next;
		}
		
		return null; //no loops!
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
			Node a = new Node(1);
			Node b = new Node(2);
			Node c = new Node(3);
			Node d = new Node(4);
			Node e = new Node(5);
			Node f = new Node(6);
			
			a.next = b;
			a.next.next = c;
			a.next.next.next = d;
			a.next.next.next.next = e;
			a.next.next.next.next.next = f;
			
			
			
			//print them out
//			displayNodes(a);
			
			//check for loops
			try {
			System.out.println(isLoop(a).data);
			}catch(Exception NullPointerException){
				System.out.println("No loops!");
			}
			
			
		

		}
}
