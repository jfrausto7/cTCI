package cTCI;

import java.util.Stack;

import cTCI.data_structures.Node;

public class isPalindrome {
	public static boolean isPalindrome(Node head) {
		if(head == null) return false;	//null base case
		Node pointer = head;
		Stack<Integer> stack = new Stack<Integer>();
		
		//iterate to populate the stack
		while(pointer != null) {
			stack.push(pointer.data);
			pointer = pointer.next;
		}
		
		//now iterate and check validity with stack
		while(head != null) {
			int number = stack.pop();
			if(head.data != number) return false;
			head = head.next;
		}
		return true;
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
			/**
			 * First test is a false case, second is a true case with odd number of nodes.
			 * Last case is with even number of nodes.
			 */
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
			
			//check
			System.out.println(isPalindrome(n));
			
			
			Node t = new Node(1);
			t.next = new Node(2);
			t.next.next = new Node(3);
			t.next.next.next = new Node(4);
			t.next.next.next.next = new Node(3);
			t.next.next.next.next.next = new Node(2);
			t.next.next.next.next.next.next = new Node(1);
			
			
			//print them out
			displayNodes(t);
			
			//check
			System.out.println(isPalindrome(t));
			
			
			Node q = new Node(1);
			q.next = new Node(2);
			q.next.next = new Node(3);
			q.next.next.next = new Node(4);
			q.next.next.next.next = new Node(4);
			q.next.next.next.next.next = new Node(3);
			q.next.next.next.next.next.next = new Node(2);
			q.next.next.next.next.next.next.next = new Node(1);
			
			
			//print them out
			displayNodes(q);
			
			//check
			System.out.println(isPalindrome(q));
			
			
			
			Node z = new Node(1);

			
			
			//print them out
			displayNodes(z);
			
			//check
			System.out.println(isPalindrome(z));
			
		

		}
}
