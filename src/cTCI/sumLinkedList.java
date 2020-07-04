package cTCI;

import cTCI.data_structures.Node;

public class sumLinkedList {
	public static Node sumLinkedList(Node head1, Node head2) {
		Node a = head1;
		Node b = head2;
		Node result = null;
		Node pointer = null;
		int carry = 0;
		
		//base condition
		if(head1 == null || head2 == null) return null;
		
			int sum = a.data + b.data;
			
			if(sum > 9) {
				carry = (sum - (sum % 10)) / 10;
				sum = sum % 10;
			}
			
			result = new Node(sum);
			pointer = result;
			a = a.next;
			b = b.next;
		
		while(a != null || b != null) {
			if(a == null) {
				sum = b.data;
				b = b.next;
			}else if(b == null) {
				sum = a.data;
				a = a.next;
			}else {
				sum = a.data + b.data;
				a = a.next;
				b = b.next;
			}

			
			//check for carry
			if(carry != 0) {
				sum += carry;
				carry = 0;
			}
			if(sum > 9) {
				carry = (sum - (sum % 10)) / 10;
				sum = sum % 10;
			}
			
			pointer.next = new Node(sum);
			pointer = pointer.next;
			
			
		}
		//extra carry case!
		if(carry != 0) {
			pointer.next = new Node(carry);
		}
		return result;
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
				 * The test cases here are very important. Essentially, we first test for
				 * a case that has identical length for both LinkedLists. Afterwards, we
				 * test for a case that does not. Finally, the third test checks for carried
				 * values
				 */
				
				//first LinkedList
				Node n = new Node(7);
				n.next = new Node(1);
				n.next.next = new Node(6);
				
				//second LinkedList
				Node t = new Node(5);
				t.next = new Node(9);
				t.next.next = new Node(2);
				
				//test the method
				Node result = sumLinkedList(n,t);
				displayNodes(result);
			
				/**
				 * Below is the second test.
				 */
				
				//first LinkedList
				Node j = new Node(5);
				j.next = new Node(4);
				j.next.next = new Node(2);
				j.next.next.next = new Node(2);
				
				//second LinkedList
				Node k = new Node(2);
				k.next = new Node(9);
				k.next.next = new Node(1);
				
				//test the method
				Node result2 = sumLinkedList(j,k);
				displayNodes(result2);
				
				
				/**
				 * Below is the third test.
				 */
				
				//first LinkedList
				Node l = new Node(6);
				l.next = new Node(8);
				l.next.next = new Node(5);
				
				//second LinkedList
				Node z = new Node(9);
				z.next = new Node(7);
				z.next.next = new Node(8);
				
				//test the method
				Node result3 = sumLinkedList(l,z);
				displayNodes(result3);

			}

}
