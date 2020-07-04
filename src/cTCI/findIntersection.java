package cTCI;

import cTCI.data_structures.Node;

public class findIntersection {
	public static Node findIntersection(Node a, Node b) {
		//first check base case
		if(a == null || b == null);
		Node pa = a;
		Node pb = b;
		int aLength = 1;
		int bLength = 1;
		while(pa.next != null || pb.next != null) {
			if(pa.next != null) {
				aLength++;
				pa = pa.next;
			}
			if(pb.next != null) {
				bLength++;
				pb = pb.next;
			}
		}
		if(pa.data != pb.data) return null;	//no intersection
		int diff = Math.abs(aLength-bLength);
		if(aLength > bLength) {
			for(int i = 0; i < diff; i++) {
				a = a.next;
			}
		}else {
			for(int j = 0; j < diff; j++) {
				b = b.next;
			}
		}
		
		//iterate through one last time
		while(a.next != null) {
			if(a.data == b.data) return a;
			a = a.next;
			b = b.next;
		}
		return a;
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
			Node n = new Node(3);
			n.next = new Node(4);
			n.next.next = new Node(6);
			n.next.next.next = new Node(7);
			n.next.next.next.next = new Node(2);
			n.next.next.next.next.next = new Node(2);

			
			
			Node a = new Node(4);
			a.next = new Node(6);
			a.next.next = new Node(7);
			a.next.next.next = new Node(2);
			a.next.next.next.next = new Node(2);
			
			
			
			//print them out
			displayNodes(n);
			displayNodes(a);
			
			//check and return
			Node result = findIntersection(n,a);
			if(result == null) System.out.println("No intersection");
			else System.out.println(result.data);
			
			
			
		

		}

}
